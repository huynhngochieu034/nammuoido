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

import com.noname.awn.converter.ModulesConverter;
import com.noname.awn.dto.ModulesDTO;
import com.noname.awn.model.Modules;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.repository.ModulesRepository;
import com.noname.awn.repository.SubscriptionsRepository;;

@RestController
@RequestMapping(value = "/api/modules")
public class ModulesController {

	@Autowired
	private ModulesRepository repository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private ModulesConverter modulesConverter;
	
	@GetMapping("/")
	public List<Modules> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Modules getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Modules updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody ModulesDTO modulesDTO) {
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(modulesDTO.getId_subscription());
		Modules modules = modulesConverter.convertToEntity(modulesDTO);
		modules.setSubscriptions(subscriptions);
		modules.set_id(id);
		repository.save(modules);
		return modules;
	}

	@PostMapping("/")
	@Transactional
	public Modules createWallets(@Valid @RequestBody ModulesDTO modulesDTO) {
		modulesDTO.set_id(ObjectId.get());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(modulesDTO.getId_subscription());
		Modules modules = modulesConverter.convertToEntity(modulesDTO);
		modules.setSubscriptions(subscriptions);
		repository.save(modules);
		return modules;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
