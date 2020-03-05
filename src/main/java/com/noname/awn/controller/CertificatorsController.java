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

import com.noname.awn.model.Certificators;
import com.noname.awn.repository.CertificatorsRepository;;

@RestController
@RequestMapping(value = "/api/certificators")
public class CertificatorsController {

	@Autowired
	private CertificatorsRepository repository;
	
	@GetMapping("/")
	public List<Certificators> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Certificators getUsers(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Certificators updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody Certificators certificators) {
		certificators.set_id(id);
		repository.save(certificators);
		return certificators;
	}

	@PostMapping("/")
	@Transactional
	public Certificators createUsers(@Valid @RequestBody Certificators certificators) {
		certificators.set_id(ObjectId.get());
		repository.save(certificators);
		return certificators;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteUsers(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
