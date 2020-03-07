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

import com.noname.awn.converter.PaymentsConverter;
import com.noname.awn.dto.PaymentsDTO;
import com.noname.awn.model.Payments;
import com.noname.awn.model.Wallets;
import com.noname.awn.repository.PaymentsRepository;
import com.noname.awn.repository.WalletsRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/payments")
public class PaymentsController {

	@Autowired
	private PaymentsRepository repository;
	
	@Autowired
	private WalletsRepository walletsRepository;

    @Autowired
    private PaymentsConverter paymentsConverter;
	
	@GetMapping("/")
	public List<Payments> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Payments getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Payments updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody PaymentsDTO paymentsDTO) {
		Wallets wallets = walletsRepository.findBy_id(paymentsDTO.getId_wallet());
		Payments payments = paymentsConverter.convertToEntity(paymentsDTO);
		payments.setWallets(wallets);
		payments.setLogs(LogsUtils.getListLogs(paymentsDTO.getLogs()));
		payments.set_id(id);
		repository.save(payments);
		return payments;
	}

	@PostMapping("/")
	@Transactional
	public Payments createWallets(@Valid @RequestBody PaymentsDTO paymentsDTO) {
		paymentsDTO.set_id(ObjectId.get());
		Wallets wallets = walletsRepository.findBy_id(paymentsDTO.getId_wallet());
		Payments payments = paymentsConverter.convertToEntity(paymentsDTO);
		payments.setWallets(wallets);
		payments.setLogs(LogsUtils.getListLogs(paymentsDTO.getLogs()));
		repository.save(payments);
		return payments;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
