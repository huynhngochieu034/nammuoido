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

import com.noname.awn.converter.NotarizationsConverter;
import com.noname.awn.dto.NotarizationsDTO;
import com.noname.awn.model.Abis;
import com.noname.awn.model.Documents;
import com.noname.awn.model.Logs;
import com.noname.awn.model.Notarizations;
import com.noname.awn.model.Operations;
import com.noname.awn.repository.AbisRepository;
import com.noname.awn.repository.DocumentsRepository;
import com.noname.awn.repository.LogsRepository;
import com.noname.awn.repository.NotarizationsRepository;
import com.noname.awn.repository.OperationsRepository;;

@RestController
@RequestMapping(value = "/api/notarizations")
public class NotarizationsController {

	@Autowired
	private NotarizationsRepository repository;
	
	@Autowired
	private DocumentsRepository documentsRepository;
	
	@Autowired
	private AbisRepository abisRepository;
	
	@Autowired
	private OperationsRepository operationsRepository;
	
	@Autowired
	private LogsRepository logsRepository;

    @Autowired
    private NotarizationsConverter notarizationsConverter;
	
	@GetMapping("/")
	public List<Notarizations> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Notarizations getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Notarizations updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody NotarizationsDTO notarizationsDTO) {
		Documents documents = documentsRepository.findBy_id(notarizationsDTO.getId_document());
		Abis abis = abisRepository.findBy_id(notarizationsDTO.getId_abis());
		Operations operations = operationsRepository.findBy_id(notarizationsDTO.getId_operation());
		Logs logs = logsRepository.findBy_id(notarizationsDTO.getId_log());
		
		Notarizations notarizations = notarizationsConverter.convertToEntity(notarizationsDTO);
		notarizations.setAbis(abis);
		notarizations.setDocuments(documents);
		notarizations.setOperations(operations);
		notarizations.setLogss(logs);
		abis.set_id(id);
		repository.save(notarizations);
		return notarizations;
	}

	@PostMapping("/")
	@Transactional
	public Notarizations createAbis(@Valid @RequestBody NotarizationsDTO notarizationsDTO) {
		notarizationsDTO.set_id(ObjectId.get());
		Documents documents = documentsRepository.findBy_id(notarizationsDTO.getId_document());
		Abis abis = abisRepository.findBy_id(notarizationsDTO.getId_abis());
		Operations operations = operationsRepository.findBy_id(notarizationsDTO.getId_operation());
		Logs logs = logsRepository.findBy_id(notarizationsDTO.getId_log());
		Notarizations notarizations = notarizationsConverter.convertToEntity(notarizationsDTO);
		notarizations.setAbis(abis);
		notarizations.setDocuments(documents);
		notarizations.setOperations(operations);
		notarizations.setLogss(logs);
		repository.save(notarizations);
		return notarizations;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
