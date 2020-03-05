package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.OperationsDTO;
import com.noname.awn.model.Operations;

@Component
public class OperationsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OperationsDTO convertToDto(Operations entity) {
		OperationsDTO result = modelMapper.map(entity, OperationsDTO.class);
        return result;
    }

    public Operations convertToEntity(OperationsDTO dto) {
    	Operations result = modelMapper.map(dto, Operations.class);
        return result;
    }

}
