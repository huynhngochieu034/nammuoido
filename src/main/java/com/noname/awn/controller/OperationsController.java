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

import com.noname.awn.converter.OperationsConverter;
import com.noname.awn.dto.OperationsDTO;
import com.noname.awn.model.Operations;
import com.noname.awn.model.Sequences;
import com.noname.awn.repository.OperationsRepository;
import com.noname.awn.repository.SequencesRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/operations")
public class OperationsController {

	@Autowired
	private OperationsRepository repository;
	
	@Autowired
	private SequencesRepository sequencesRepository;

    @Autowired
    private OperationsConverter operationsConverter;
	
	@GetMapping("/")
	public List<Operations> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Operations getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Operations updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody OperationsDTO operationsDTO) {
		Sequences sequences = sequencesRepository.findBy_id(operationsDTO.getId_sequence());
		Operations operations = operationsConverter.convertToEntity(operationsDTO);
		operations.setSequences(sequences);
		operations.setLogs(LogsUtils.getListLogs(operationsDTO.getLogs()));
		operations.set_id(id);
		repository.save(operations);
		return operations;
	}

	@PostMapping("/")
	@Transactional
	public Operations createAbis(@Valid @RequestBody OperationsDTO operationsDTO) {
		operationsDTO.set_id(ObjectId.get());
		Sequences sequences = sequencesRepository.findBy_id(operationsDTO.getId_sequence());
		Operations operations = operationsConverter.convertToEntity(operationsDTO);
		operations.setSequences(sequences);
		operations.setLogs(LogsUtils.getListLogs(operationsDTO.getLogs()));
		repository.save(operations);
		return operations;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
