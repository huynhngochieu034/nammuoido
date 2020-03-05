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

import com.noname.awn.converter.SettingsConverter;
import com.noname.awn.dto.SettingsDTO;
import com.noname.awn.model.Settings;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.repository.SettingsRepository;
import com.noname.awn.repository.SubscriptionsRepository;;

@RestController
@RequestMapping(value = "/api/settings")
public class SettingsController {

	@Autowired
	private SettingsRepository repository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;
	
    @Autowired
    private SettingsConverter settingsConverter;
	
	@GetMapping("/")
	public List<Settings> getAbis() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Settings getAbis(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Settings updateAbis(@PathVariable("id") ObjectId id, @Valid @RequestBody SettingsDTO settingsDTO) {
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(settingsDTO.getId_subscription());
		Settings settings = settingsConverter.convertToEntity(settingsDTO);
		settings.setSubscriptions(subscriptions);
		settings.set_id(id);
		repository.save(settings);
		return settings;
	}

	@PostMapping("/")
	@Transactional
	public Settings createAbis(@Valid @RequestBody SettingsDTO settingsDTO) {
		settingsDTO.set_id(ObjectId.get());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(settingsDTO.getId_subscription());
		Settings settings = settingsConverter.convertToEntity(settingsDTO);
		settings.setSubscriptions(subscriptions);
		repository.save(settings);
		return settings;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteAbis(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
