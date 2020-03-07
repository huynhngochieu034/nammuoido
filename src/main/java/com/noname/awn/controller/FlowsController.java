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

import com.noname.awn.converter.FlowsConverter;
import com.noname.awn.dto.FlowsDTO;
import com.noname.awn.model.Flows;
import com.noname.awn.model.Users;
import com.noname.awn.repository.FlowsRepository;
import com.noname.awn.repository.UsersRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/flows")
public class FlowsController {

	@Autowired
	private FlowsRepository repository;
	
	@Autowired
	private UsersRepository userRepository;
	
    @Autowired
    private FlowsConverter flowsConverter;
	
	@GetMapping("/")
	public List<Flows> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Flows getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Flows updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody FlowsDTO flowsDTO) {
		Users user = userRepository.findBy_id(flowsDTO.getId_user());
		Flows flows = flowsConverter.convertToEntity(flowsDTO);
		flows.setUser(user);
		flows.setLogs(LogsUtils.getListLogs(flowsDTO.getLogs()));
		flows.set_id(id);
		repository.save(flows);
		return flows;
	}

	@PostMapping("/")
	@Transactional
	public Flows createAbis(@Valid @RequestBody FlowsDTO flowsDTO) {
		flowsDTO.set_id(ObjectId.get());
		Users user = userRepository.findBy_id(flowsDTO.getId_user());
		Flows flows = flowsConverter.convertToEntity(flowsDTO);
		flows.setUser(user);
		flows.setLogs(LogsUtils.getListLogs(flowsDTO.getLogs()));
		repository.save(flows);
		return flows;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
