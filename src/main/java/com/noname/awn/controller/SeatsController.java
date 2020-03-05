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

import com.noname.awn.converter.SeatsConverter;
import com.noname.awn.dto.SeatsDTO;
import com.noname.awn.model.Licences;
import com.noname.awn.model.Seats;
import com.noname.awn.model.Users;
import com.noname.awn.repository.LicencesRepository;
import com.noname.awn.repository.SeatsRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/seats")
public class SeatsController {

	@Autowired
	private SeatsRepository repository;
	
	@Autowired
	private UsersRepository usersRepository;

    @Autowired
    private LicencesRepository licencesRepository;
    
    @Autowired
    private SeatsConverter seatsConverter;
	
	@GetMapping("/")
	public List<Seats> getTemplates() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Seats getTemplates(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Seats updateTemplates(@PathVariable("id") ObjectId id, @Valid @RequestBody SeatsDTO seatsDTO) {
		Licences licences = licencesRepository.findBy_id(seatsDTO.getId_licence());
		Users users = usersRepository.findBy_id(seatsDTO.getId_user());
		Seats seats = seatsConverter.convertToEntity(seatsDTO);
		seats.setLicences(licences);
		seats.setUsers(users);
		seats.set_id(id);
		repository.save(seats);
		return seats;
	}

	@PostMapping("/")
	@Transactional
	public Seats createTemplates(@Valid @RequestBody SeatsDTO seatsDTO) {
		seatsDTO.set_id(ObjectId.get());
		Licences licences = licencesRepository.findBy_id(seatsDTO.getId_licence());
		Users users = usersRepository.findBy_id(seatsDTO.getId_user());
		Seats seats = seatsConverter.convertToEntity(seatsDTO);
		seats.setLicences(licences);
		seats.setUsers(users);
		repository.save(seats);
		return seats;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteTemplates(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
