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

import com.noname.awn.converter.PresetsConverter;
import com.noname.awn.dto.PresetsDTO;
import com.noname.awn.model.Presets;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.repository.PresetsRepository;
import com.noname.awn.repository.SubscriptionsRepository;
import com.noname.awn.util.DevicesUtils;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/presets")
public class PresetsController {

	@Autowired
	private PresetsRepository repository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private PresetsConverter presetsConverter;
	
	@GetMapping("/")
	public List<Presets> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Presets getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Presets updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody PresetsDTO presetsDTO) {
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(presetsDTO.getId_subscription());
		Presets presets = presetsConverter.convertToEntity(presetsDTO);
		presets.setSubscriptions(subscriptions);
		presets.setLogs(LogsUtils.getListLogs(presetsDTO.getLogs()));
		presets.setDevices(DevicesUtils.getListDevices(presetsDTO.getLogs()));
		presets.set_id(id);
		repository.save(presets);
		return presets;
	}

	@PostMapping("/")
	@Transactional
	public Presets createWallets(@Valid @RequestBody PresetsDTO presetsDTO) {
		presetsDTO.set_id(ObjectId.get());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(presetsDTO.getId_subscription());
		Presets presets = presetsConverter.convertToEntity(presetsDTO);
		presets.setSubscriptions(subscriptions);
		presets.setLogs(LogsUtils.getListLogs(presetsDTO.getLogs()));
		presets.setDevices(DevicesUtils.getListDevices(presetsDTO.getLogs()));
		repository.save(presets);
		return presets;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
