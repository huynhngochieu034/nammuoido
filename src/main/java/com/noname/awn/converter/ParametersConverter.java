package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.ParametersDTO;
import com.noname.awn.model.Parameters;

@Component
public class ParametersConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ParametersDTO convertToDto(Parameters entity) {
		ParametersDTO result = modelMapper.map(entity, ParametersDTO.class);
        return result;
    }

    public Parameters convertToEntity(ParametersDTO dto) {
    	Parameters result = modelMapper.map(dto, Parameters.class);
        return result;
    }

}
