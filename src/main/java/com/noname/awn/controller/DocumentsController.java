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

import com.noname.awn.converter.DocumentsConverter;
import com.noname.awn.dto.DocumentsDTO;
import com.noname.awn.model.Documents;
import com.noname.awn.model.Users;
import com.noname.awn.repository.DocumentsRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/documents")
public class DocumentsController {

	@Autowired
	private DocumentsRepository repository;
	
	@Autowired
	private UsersRepository userRepository;
	
    @Autowired
    private DocumentsConverter documentsConverter;
	
	@GetMapping("/")
	public List<Documents> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Documents getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Documents updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody DocumentsDTO documentsDTO) {
		Users user = userRepository.findBy_id(documentsDTO.getId_user());
		Documents documents = documentsConverter.convertToEntity(documentsDTO);
		documents.setUser(user);
		documents.set_id(id);
		repository.save(documents);
		return documents;
	}

	@PostMapping("/")
	@Transactional
	public Documents createAbis(@Valid @RequestBody DocumentsDTO documentsDTO) {
		documentsDTO.set_id(ObjectId.get());
		Users user = userRepository.findBy_id(documentsDTO.getId_user());
		Documents documents = documentsConverter.convertToEntity(documentsDTO);
		documents.setUser(user);
		repository.save(documents);
		return documents;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
