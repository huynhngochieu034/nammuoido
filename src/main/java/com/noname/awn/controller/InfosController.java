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

import com.noname.awn.converter.InfosConverter;
import com.noname.awn.dto.InfosDTO;
import com.noname.awn.model.Infos;
import com.noname.awn.model.Users;
import com.noname.awn.repository.InfosRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/infos")
public class InfosController {

	@Autowired
	private InfosRepository repository;
	
	@Autowired
	private UsersRepository userRepository;
	
    @Autowired
    private InfosConverter infosConverter;
	
	@GetMapping("/")
	public List<Infos> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Infos getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Infos updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody InfosDTO infosDTO) {
		Users user = userRepository.findBy_id(infosDTO.getId_user());
		Infos infos = infosConverter.convertToEntity(infosDTO);
		infos.setUser(user);
		infos.set_id(id);
		repository.save(infos);
		return infos;
	}

	@PostMapping("/")
	@Transactional
	public Infos createAbis(@Valid @RequestBody InfosDTO infosDTO) {
		infosDTO.set_id(ObjectId.get());
		Users user = userRepository.findBy_id(infosDTO.getId_user());
		Infos infos = infosConverter.convertToEntity(infosDTO);
		infos.setUser(user);
		repository.save(infos);
		return infos;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
