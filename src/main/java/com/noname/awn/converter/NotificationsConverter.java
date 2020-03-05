package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.NotificationsDTO;
import com.noname.awn.model.Notifications;

@Component
public class NotificationsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public NotificationsDTO convertToDto(Notifications entity) {
		NotificationsDTO result = modelMapper.map(entity, NotificationsDTO.class);
        return result;
    }

    public Notifications convertToEntity(NotificationsDTO dto) {
    	Notifications result = modelMapper.map(dto, Notifications.class);
        return result;
    }

}
