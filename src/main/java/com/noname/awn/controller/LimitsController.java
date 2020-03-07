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

import com.noname.awn.converter.LimitsConverter;
import com.noname.awn.dto.LimitsDTO;
import com.noname.awn.model.Limits;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.repository.LimitsRepository;
import com.noname.awn.repository.SubscriptionsRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/limits")
public class LimitsController {

	@Autowired
	private LimitsRepository repository;
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;

    @Autowired
    private LimitsConverter limitsConverter;
	
	@GetMapping("/")
	public List<Limits> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Limits getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Limits updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody LimitsDTO limitsDTO) {
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(limitsDTO.getId_subscription());
		Limits limits = limitsConverter.convertToEntity(limitsDTO);
		limits.setSubscriptions(subscriptions);
		limits.setLogs(LogsUtils.getListLogs(limitsDTO.getLogs()));
		limits.set_id(id);
		repository.save(limits);
		return limits;
	}

	@PostMapping("/")
	@Transactional
	public Limits createWallets(@Valid @RequestBody LimitsDTO limitsDTO) {
		limitsDTO.set_id(ObjectId.get());
		Subscriptions subscriptions = subscriptionsRepository.findBy_id(limitsDTO.getId_subscription());
		Limits limits = limitsConverter.convertToEntity(limitsDTO);
		limits.setSubscriptions(subscriptions);
		limits.setLogs(LogsUtils.getListLogs(limitsDTO.getLogs()));
		repository.save(limits);
		return limits;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
