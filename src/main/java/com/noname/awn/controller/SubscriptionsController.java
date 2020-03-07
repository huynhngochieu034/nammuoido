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

import com.noname.awn.converter.SubscriptionsConverter;
import com.noname.awn.dto.SubscriptionsDTO;
import com.noname.awn.model.Customers;
import com.noname.awn.model.Subscriptions;
import com.noname.awn.repository.CustomersRepository;
import com.noname.awn.repository.SubscriptionsRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/subscriptions")
public class SubscriptionsController {

	@Autowired
	private SubscriptionsRepository repository;
	
	@Autowired
	private CustomersRepository customersRepository;

    @Autowired
    private SubscriptionsConverter subscriptionsConverter;
	
	@GetMapping("/")
	public List<Subscriptions> getSubscriptions() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Subscriptions geSubscriptions(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Subscriptions updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody SubscriptionsDTO subscriptionsDTO) {
		Customers customer = customersRepository.findBy_id(subscriptionsDTO.getId_customer());
		Subscriptions subscriptions = subscriptionsConverter.convertToEntity(subscriptionsDTO);
		subscriptions.setCustomer(customer);
		subscriptions.setLogs(LogsUtils.getListLogs(subscriptionsDTO.getLogs()));
		subscriptions.set_id(id);
		repository.save(subscriptions);
		return subscriptions;
	}

	@PostMapping("/")
	@Transactional
	public Subscriptions createSubscriptions(@Valid @RequestBody SubscriptionsDTO subscriptionsDTO) {
		subscriptionsDTO.set_id(ObjectId.get());
		Customers customer = customersRepository.findBy_id(subscriptionsDTO.getId_customer());
		Subscriptions subscriptions = subscriptionsConverter.convertToEntity(subscriptionsDTO);
		subscriptions.setCustomer(customer);
		subscriptions.setLogs(LogsUtils.getListLogs(subscriptionsDTO.getLogs()));
		repository.save(subscriptions);
		return subscriptions;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
