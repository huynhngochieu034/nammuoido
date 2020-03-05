package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.StatusDTO;
import com.noname.awn.model.Status;

@Component
public class StatusConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StatusDTO convertToDto(Status entity) {
		StatusDTO result = modelMapper.map(entity, StatusDTO.class);
        return result;
    }

    public Status convertToEntity(StatusDTO dto) {
    	Status result = modelMapper.map(dto, Status.class);
        return result;
    }

}
