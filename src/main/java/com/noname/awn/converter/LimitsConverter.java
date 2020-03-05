package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.LimitsDTO;
import com.noname.awn.model.Limits;

@Component
public class LimitsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LimitsDTO convertToDto(Limits entity) {
		LimitsDTO result = modelMapper.map(entity, LimitsDTO.class);
        return result;
    }

    public Limits convertToEntity(LimitsDTO dto) {
    	Limits result = modelMapper.map(dto, Limits.class);
        return result;
    }

}
