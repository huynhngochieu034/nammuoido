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

import com.noname.awn.converter.SequencesConverter;
import com.noname.awn.dto.SequencesDTO;
import com.noname.awn.model.Sequences;
import com.noname.awn.repository.SequencesRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/sequences")
public class SequencesController {

	@Autowired
	private SequencesRepository repository;
	
	@Autowired
	private SequencesConverter sequencesConverter;
	
	@GetMapping("/")
	public List<Sequences> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Sequences getUsers(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Sequences updateUsers(@PathVariable("id") ObjectId id, @Valid @RequestBody SequencesDTO sequencesDTO) {
		Sequences sequences = sequencesConverter.convertToEntity(sequencesDTO);
		sequences.setLogs(LogsUtils.getListLogs(sequencesDTO.getLogs()));
		sequences.set_id(id);
		repository.save(sequences);
		return sequences;
	}

	@PostMapping("/")
	@Transactional
	public Sequences createUsers(@Valid @RequestBody SequencesDTO sequencesDTO) {
		sequencesDTO.set_id(ObjectId.get());
		Sequences sequences = sequencesConverter.convertToEntity(sequencesDTO);
		sequences.setLogs(LogsUtils.getListLogs(sequencesDTO.getLogs()));
		repository.save(sequences);
		return sequences;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteUsers(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}
}
