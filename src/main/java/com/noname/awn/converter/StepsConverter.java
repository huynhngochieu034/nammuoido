package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.StepsDTO;
import com.noname.awn.model.Steps;

@Component
public class StepsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StepsDTO convertToDto(Steps entity) {
		StepsDTO result = modelMapper.map(entity, StepsDTO.class);
        return result;
    }

    public Steps convertToEntity(StepsDTO dto) {
    	Steps result = modelMapper.map(dto, Steps.class);
        return result;
    }

}
