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

import com.noname.awn.converter.StepsConverter;
import com.noname.awn.dto.StepsDTO;
import com.noname.awn.model.Sequences;
import com.noname.awn.model.Steps;
import com.noname.awn.repository.SequencesRepository;
import com.noname.awn.repository.StepsRepository;
import com.noname.awn.util.LogsUtils;;

@RestController
@RequestMapping(value = "/api/steps")
public class StepsController {

	@Autowired
	private StepsRepository repository;

    @Autowired
    private SequencesRepository sequencesRepository;
    
    @Autowired
    private StepsConverter stepsConverter;
	
	@GetMapping("/")
	public List<Steps> getSteps() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Steps getSteps(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Steps updateSteps(@PathVariable("id") ObjectId id, @Valid @RequestBody StepsDTO stepsDTO) {
		Sequences sequences = sequencesRepository.findBy_id(stepsDTO.getId_sequence());
		Steps steps = stepsConverter.convertToEntity(stepsDTO);
		steps.setSequences(sequences);
		steps.setLogs(LogsUtils.getListLogs(stepsDTO.getLogs()));
		steps.set_id(id);
		repository.save(steps);
		return steps;
	}

	@PostMapping("/")
	@Transactional
	public Steps createWallets(@Valid @RequestBody StepsDTO stepsDTO) {
		stepsDTO.set_id(ObjectId.get());
		Sequences sequences = sequencesRepository.findBy_id(stepsDTO.getId_sequence());
		Steps steps = stepsConverter.convertToEntity(stepsDTO);
		steps.setSequences(sequences);
		steps.setLogs(LogsUtils.getListLogs(stepsDTO.getLogs()));
		repository.save(steps);
		return steps;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
