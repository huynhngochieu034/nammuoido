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

import com.noname.awn.converter.TasksConverter;
import com.noname.awn.dto.TasksDTO;
import com.noname.awn.model.Sequences;
import com.noname.awn.model.Tasks;
import com.noname.awn.model.Users;
import com.noname.awn.repository.SequencesRepository;
import com.noname.awn.repository.TasksRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/tasks")
public class TasksController {

	@Autowired
	private TasksRepository repository;
	
	@Autowired
	private UsersRepository usersRepository;

    @Autowired
    private SequencesRepository sequencesRepository;
    
    @Autowired
    private TasksConverter tasksConverter;
	
	@GetMapping("/")
	public List<Tasks> getTasks() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Tasks getTasks(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Tasks updateTasks(@PathVariable("id") ObjectId id, @Valid @RequestBody TasksDTO tasksDTO) {
		Sequences sequences = sequencesRepository.findBy_id(tasksDTO.getId_sequence());
		Users user = usersRepository.findBy_id(tasksDTO.getId_user());
		Tasks tasks = tasksConverter.convertToEntity(tasksDTO);
		tasks.setUser(user);
		tasks.setSequences(sequences);
		tasks.set_id(id);
		repository.save(tasks);
		return tasks;
	}

	@PostMapping("/")
	@Transactional
	public Tasks createWallets(@Valid @RequestBody TasksDTO tasksDTO) {
		tasksDTO.set_id(ObjectId.get());
		Sequences sequences = sequencesRepository.findBy_id(tasksDTO.getId_sequence());
		Users user = usersRepository.findBy_id(tasksDTO.getId_user());
		Tasks tasks = tasksConverter.convertToEntity(tasksDTO);
		tasks.setUser(user);
		tasks.setSequences(sequences);
		repository.save(tasks);
		return tasks;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteWallets(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
