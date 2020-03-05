package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.FlowsDTO;
import com.noname.awn.model.Flows;

@Component
public class FlowsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public FlowsDTO convertToDto(Flows entity) {
		FlowsDTO result = modelMapper.map(entity, FlowsDTO.class);
        return result;
    }

    public Flows convertToEntity(FlowsDTO dto) {
    	Flows result = modelMapper.map(dto, Flows.class);
        return result;
    }

}
