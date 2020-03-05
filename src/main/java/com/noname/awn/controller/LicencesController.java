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

import com.noname.awn.model.Licences;
import com.noname.awn.repository.LicencesRepository;;

@RestController
@RequestMapping(value = "/api/licences")
public class LicencesController {

	@Autowired
	private LicencesRepository repository;
	
	@GetMapping("/")
	public List<Licences> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Licences getUsers(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Licences updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody Licences user) {
		user.set_id(id);
		repository.save(user);
		return user;
	}

	@PostMapping("/")
	@Transactional
	public Licences createUsers(@Valid @RequestBody Licences users) {
		users.set_id(ObjectId.get());
		repository.save(users);
		return users;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteUsers(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}


}
