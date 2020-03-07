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

import com.noname.awn.converter.StatusConverter;
import com.noname.awn.dto.StatusDTO;
import com.noname.awn.model.Logs;
import com.noname.awn.model.Status;
import com.noname.awn.repository.LogsRepository;
import com.noname.awn.repository.StatusRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

	@Autowired
	private StatusRepository repository;
	
	@Autowired
	private LogsRepository logsRepository;

    @Autowired
    private StatusConverter statusConverter;
	
	@GetMapping("/")
	public List<Status> getWallets() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Status getWallets(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Status updateWallets(@PathVariable("id") ObjectId id, @Valid @RequestBody StatusDTO statusDTO) {
		Logs logs = logsRepository.findBy_id(statusDTO.getId_log());
		Status status = statusConverter.convertToEntity(statusDTO);
		status.setLogss(logs);
		status.setLogs(LogsUtils.getListLogs(statusDTO.getLogs()));
		status.set_id(id);
		repository.save(status);
		return status;
	}

	@PostMapping("/")
	@Transactional
	public Status createWallets(@Valid @RequestBody StatusDTO statusDTO) {
		statusDTO.set_id(ObjectId.get());
		Logs logs = logsRepository.findBy_id(statusDTO.getId_log());
		Status status = statusConverter.convertToEntity(statusDTO);
		status.setLogss(logs);
		status.setLogs(LogsUtils.getListLogs(statusDTO.getLogs()));
		repository.save(status);
		return status;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
