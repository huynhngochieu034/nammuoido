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

import com.noname.awn.converter.LicencesConverter;
import com.noname.awn.dto.LicencesDTO;
import com.noname.awn.model.Licences;
import com.noname.awn.repository.LicencesRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/licences")
public class LicencesController {

	@Autowired
	private LicencesRepository repository;
	
	@Autowired
	private LicencesConverter licencesConverter;
	
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
	public Licences updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody LicencesDTO licencesDTO) {
		Licences licences = licencesConverter.convertToEntity(licencesDTO);
		licences.setLogs(LogsUtils.getListLogs(licencesDTO.getLogs()));
		licences.set_id(id);
		repository.save(licences);
		return licences;
	}

	@PostMapping("/")
	@Transactional
	public Licences createUsers(@Valid @RequestBody LicencesDTO licencesDTO) {
		licencesDTO.set_id(ObjectId.get());
		Licences licences = licencesConverter.convertToEntity(licencesDTO);
		licences.setLogs(LogsUtils.getListLogs(licencesDTO.getLogs()));
		repository.save(licences);
		return licences;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteUsers(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}


}
