package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.LogsDTO;
import com.noname.awn.model.Logs;

@Component
public class LogsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LogsDTO convertToDto(Logs entity) {
		LogsDTO result = modelMapper.map(entity, LogsDTO.class);
        return result;
    }

    public Logs convertToEntity(LogsDTO dto) {
    	Logs result = modelMapper.map(dto, Logs.class);
        return result;
    }

}
