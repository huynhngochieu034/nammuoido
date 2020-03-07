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

import com.noname.awn.converter.CustomersConverter;
import com.noname.awn.dto.CustomersDTO;
import com.noname.awn.model.Customers;
import com.noname.awn.repository.CustomersRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomersController {

	@Autowired
	private CustomersRepository repository;
	
	@Autowired
	private CustomersConverter customersConverter;
	
	@GetMapping("/")
	public List<Customers> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Customers getUsers(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Customers updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody CustomersDTO customersDTO) {
		customersDTO.set_id(id);
		Customers customers = customersConverter.convertToEntity(customersDTO);
		customers.setLogs(LogsUtils.getListLogs(customersDTO.getLogs()));
		repository.save(customers);
		return customers;
	}

	@PostMapping("/")
	@Transactional
	public Customers createUsers(@Valid @RequestBody CustomersDTO customersDTO) {
		customersDTO.set_id(ObjectId.get());
		Customers customers = customersConverter.convertToEntity(customersDTO);
		customers.setLogs(LogsUtils.getListLogs(customersDTO.getLogs()));
		repository.save(customers);
		return customers;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteUsers(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
