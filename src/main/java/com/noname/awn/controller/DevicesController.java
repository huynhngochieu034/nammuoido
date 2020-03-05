package com.noname.awn.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noname.awn.converter.DevicesConverter;
import com.noname.awn.dto.DevicesDTO;
import com.noname.awn.model.Devices;
import com.noname.awn.model.Seats;
import com.noname.awn.repository.DevicesRepository;
import com.noname.awn.repository.SeatsRepository;;

@RestController
@RequestMapping(value = "/api/devices")
public class DevicesController {

	@Autowired
	private DevicesRepository repository;
	
	@Autowired
	private SeatsRepository seatsRepository;

    @Autowired
    private DevicesConverter devicesConverter;
	
	@GetMapping("/")
	public List<Devices> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Devices getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Devices updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody DevicesDTO devicesDTO) {
		Seats seats = seatsRepository.findBy_id(devicesDTO.getId_seat());
		Devices devices = devicesConverter.convertToEntity(devicesDTO);
		devices.setSeats(seats);
		devices.set_id(id);
		repository.save(devices);
		return devices;
	}

	@PostMapping("/")
	@Transactional
	public Devices createAbis(@Valid @RequestBody DevicesDTO devicesDTO) {
		devicesDTO.set_id(ObjectId.get());
		Seats seats = seatsRepository.findBy_id(devicesDTO.getId_seat());
		Devices devices = devicesConverter.convertToEntity(devicesDTO);
		devices.setSeats(seats);
		repository.save(devices);
		return devices;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
