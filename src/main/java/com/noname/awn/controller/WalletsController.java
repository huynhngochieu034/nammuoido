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

import com.noname.awn.converter.WalletsConverter;
import com.noname.awn.dto.WalletsDTO;
import com.noname.awn.model.Customers;
import com.noname.awn.model.Wallets;
import com.noname.awn.repository.CustomersRepository;
import com.noname.awn.repository.WalletsRepository;;

@RestController
@RequestMapping(value = "/api/wallets")
public class WalletsController {

	@Autowired
	private WalletsRepository repository;
	
	@Autowired
	private CustomersRepository customersRepository;

    @Autowired
    private WalletsConverter walletsConverter;
	
	@GetMapping("/")
	public List<Wallets> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Wallets getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Wallets updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody WalletsDTO walletsDTO) {
		Customers customer = customersRepository.findBy_id(walletsDTO.getId_customer());
		Wallets wallets = walletsConverter.convertToEntity(walletsDTO);
		wallets.setCustomer(customer);
		wallets.set_id(id);
		repository.save(wallets);
		return wallets;
	}

	@PostMapping("/")
	@Transactional
	public Wallets createWallets(@Valid @RequestBody WalletsDTO walletsDTO) {
		walletsDTO.set_id(ObjectId.get());
		Customers customer = customersRepository.findBy_id(walletsDTO.getId_customer());
		Wallets wallets = walletsConverter.convertToEntity(walletsDTO);
		wallets.setCustomer(customer);
		repository.save(wallets);
		return wallets;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
