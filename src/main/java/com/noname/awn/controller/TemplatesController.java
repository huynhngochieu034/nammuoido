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

import com.noname.awn.converter.TemplatesConverter;
import com.noname.awn.dto.TemplatesDTO;
import com.noname.awn.model.Documents;
import com.noname.awn.model.Templates;
import com.noname.awn.model.Users;
import com.noname.awn.repository.DocumentsRepository;
import com.noname.awn.repository.TemplatesRepository;
import com.noname.awn.repository.UsersRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/templates")
public class TemplatesController {

	@Autowired
	private TemplatesRepository repository;
	
	@Autowired
	private UsersRepository usersRepository;

    @Autowired
    private DocumentsRepository documentsRepository;
    
    @Autowired
    private TemplatesConverter templatesConverter;
	
	@GetMapping("/")
	public List<Templates> getTemplates() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Templates getTemplates(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Templates updateTemplates(@PathVariable("id") ObjectId id, @Valid @RequestBody TemplatesDTO templatesDTO) {
		Documents documents = documentsRepository.findBy_id(templatesDTO.getId_document());
		Users users = usersRepository.findBy_id(templatesDTO.getId_user());
		Templates templates = templatesConverter.convertToEntity(templatesDTO);
		templates.setDocument(documents);
		templates.setUsers(users);
		templates.set_id(id);
		templates.setLogs(LogsUtils.getListLogs(templatesDTO.getLogs()));
		repository.save(templates);
		return templates;
	}

	@PostMapping("/")
	@Transactional
	public Templates createTemplates(@Valid @RequestBody TemplatesDTO templatesDTO) {
		templatesDTO.set_id(ObjectId.get());
		Documents documents = documentsRepository.findBy_id(templatesDTO.getId_document());
		Users users = usersRepository.findBy_id(templatesDTO.getId_user());
		Templates templates = templatesConverter.convertToEntity(templatesDTO);
		templates.setDocument(documents);
		templates.setUsers(users);
		templates.setLogs(LogsUtils.getListLogs(templatesDTO.getLogs()));
		repository.save(templates);
		return templates;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteTemplates(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
