package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.AbisDTO;
import com.noname.awn.model.Abis;

@Component
public class AbisConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AbisDTO convertToDto(Abis entity) {
		AbisDTO result = modelMapper.map(entity, AbisDTO.class);
        return result;
    }

    public Abis convertToEntity(AbisDTO dto) {
    	Abis result = modelMapper.map(dto, Abis.class);
        return result;
    }

}
