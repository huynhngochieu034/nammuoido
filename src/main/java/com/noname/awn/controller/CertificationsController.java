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

import com.noname.awn.converter.CertificationsConverter;
import com.noname.awn.dto.CertificationsDTO;
import com.noname.awn.model.Abis;
import com.noname.awn.model.Certifications;
import com.noname.awn.repository.AbisRepository;
import com.noname.awn.repository.CertificationsRepository;;

@RestController
@RequestMapping(value = "/api/certifications")
public class CertificationsController {

	@Autowired
	private CertificationsRepository repository;
	
	@Autowired
	private AbisRepository abisRepository;

	@Autowired
	private CertificationsConverter certificationsConverter; 
	
	@GetMapping("/")
	public List<Certifications> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Certifications getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Certifications updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody CertificationsDTO certificationsDTO) {
		Abis abis = abisRepository.findBy_id(certificationsDTO.getId_abis());
		Certifications certifications = certificationsConverter.convertToEntity(certificationsDTO);
		certifications.setAbis(abis);
		certifications.set_id(id);
		repository.save(certifications);
		return certifications;
	}

	@PostMapping("/")
	@Transactional
	public Certifications createWallets(@Valid @RequestBody CertificationsDTO certificationsDTO) {
		certificationsDTO.set_id(ObjectId.get());
		Abis abis = abisRepository.findBy_id(certificationsDTO.getId_abis());
		Certifications certifications = certificationsConverter.convertToEntity(certificationsDTO);
		certifications.setAbis(abis);
		repository.save(certifications);
		return certifications;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}
}
