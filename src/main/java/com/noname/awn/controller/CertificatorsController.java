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

import com.noname.awn.converter.CertificatorsConverter;
import com.noname.awn.dto.CertificatorsDTO;
import com.noname.awn.model.Certificators;
import com.noname.awn.repository.CertificatorsRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/certificators")
public class CertificatorsController {

	@Autowired
	private CertificatorsRepository repository;
	
	@Autowired
	private CertificatorsConverter certificatorsConverter;
	
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
	public Certificators updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody CertificatorsDTO certificatorsDTO) {
		certificatorsDTO.set_id(id);
		Certificators certificators = certificatorsConverter.convertToEntity(certificatorsDTO);
		certificators.setLogs(LogsUtils.getListLogs(certificatorsDTO.getLogs()));
		repository.save(certificators);
		return certificators;
	}

	@PostMapping("/")
	@Transactional
	public Certificators createUsers(@Valid @RequestBody CertificatorsDTO certificatorsDTO) {
		certificatorsDTO.set_id(ObjectId.get());
		Certificators certificators = certificatorsConverter.convertToEntity(certificatorsDTO);
		certificators.setLogs(LogsUtils.getListLogs(certificatorsDTO.getLogs()));
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
