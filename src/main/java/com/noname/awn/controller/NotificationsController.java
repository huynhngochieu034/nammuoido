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

import com.noname.awn.converter.NotificationsConverter;
import com.noname.awn.dto.NotificationsDTO;
import com.noname.awn.model.Notifications;
import com.noname.awn.model.Users;
import com.noname.awn.repository.NotificationsRepository;
import com.noname.awn.repository.UsersRepository;;

@RestController
@RequestMapping(value = "/api/notifications")
public class NotificationsController {

	@Autowired
	private NotificationsRepository repository;
	
	@Autowired
	private UsersRepository usersRepository;
    
    @Autowired
    private NotificationsConverter notificationsConverter;
	
	@GetMapping("/")
	public List<Notifications> getTemplates() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Notifications getTemplates(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Notifications updateTemplates(@PathVariable("id") ObjectId id, @Valid @RequestBody NotificationsDTO notificationsDTO) {
		Users user_sender = usersRepository.findBy_id(notificationsDTO.getId_user_sender());
		Users user_receiver = usersRepository.findBy_id(notificationsDTO.getId_user_receiver());
		Notifications notifications = notificationsConverter.convertToEntity(notificationsDTO);
		notifications.setUser_sender(user_sender);
		notifications.setUser_receiver(user_receiver);
		notifications.set_id(id);
		repository.save(notifications);
		return notifications;
	}

	@PostMapping("/")
	@Transactional
	public Notifications createTemplates(@Valid @RequestBody NotificationsDTO notificationsDTO) {
		notificationsDTO.set_id(ObjectId.get());
		Users user_sender = usersRepository.findBy_id(notificationsDTO.getId_user_sender());
		Users user_receiver = usersRepository.findBy_id(notificationsDTO.getId_user_receiver());
		Notifications notifications = notificationsConverter.convertToEntity(notificationsDTO);
		notifications.setUser_sender(user_sender);
		notifications.setUser_receiver(user_receiver);
		repository.save(notifications);
		return notifications;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public String deleteTemplates(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
		return "Delete success";
	}

}
