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

import com.noname.awn.converter.AbisConverter;
import com.noname.awn.dto.AbisDTO;
import com.noname.awn.model.Abis;
import com.noname.awn.model.Users;
import com.noname.awn.repository.AbisRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/abis")
public class AbisController {

	@Autowired
	private AbisRepository repository;
	
	@Autowired
	private UsersRepository userRepository;
	

    @Autowired
    private AbisConverter abisConverter;
	
	@GetMapping("/")
	public List<Abis> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Abis getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Abis updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody AbisDTO abisDTO) {
		Users user = userRepository.findBy_id(abisDTO.getId_user());
		Abis abis = abisConverter.convertToEntity(abisDTO);
		abis.setUser(user);
		abis.set_id(id);
		repository.save(abis);
		return abis;
	}

	@PostMapping("/")
	@Transactional
	public Abis createAbis(@Valid @RequestBody AbisDTO abisDTO) {
		abisDTO.set_id(ObjectId.get());
		Users user = userRepository.findBy_id(abisDTO.getId_user());
		Abis abis = abisConverter.convertToEntity(abisDTO);
		abis.setUser(user);
		repository.save(abis);
		return abis;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
