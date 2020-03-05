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

import com.noname.awn.converter.ParametersConverter;
import com.noname.awn.dto.ParametersDTO;
import com.noname.awn.model.Parameters;
import com.noname.awn.model.Users;
import com.noname.awn.repository.ParametersRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/parameters")
public class ParametersController {

	@Autowired
	private ParametersRepository repository;
	
	@Autowired
	private UsersRepository userRepository;
	

    @Autowired
    private ParametersConverter parametersConverter;
	
	@GetMapping("/")
	public List<Parameters> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Parameters getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Parameters updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody ParametersDTO parametersDTO) {
		Users user = userRepository.findBy_id(parametersDTO.getId_user());
		Parameters parameters = parametersConverter.convertToEntity(parametersDTO);
		parameters.setUsers(user);
		parameters.set_id(id);
		repository.save(parameters);
		return parameters;
	}

	@PostMapping("/")
	@Transactional
	public Parameters createAbis(@Valid @RequestBody ParametersDTO parametersDTO) {
		parametersDTO.set_id(ObjectId.get());
		Users user = userRepository.findBy_id(parametersDTO.getId_user());
		Parameters parameters = parametersConverter.convertToEntity(parametersDTO);
		parameters.setUsers(user);
		repository.save(parameters);
		return parameters;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
