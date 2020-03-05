package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.TemplatesDTO;
import com.noname.awn.model.Templates;

@Component
public class TemplatesConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TemplatesDTO convertToDto(Templates entity) {
		TemplatesDTO result = modelMapper.map(entity, TemplatesDTO.class);
        return result;
    }

    public Templates convertToEntity(TemplatesDTO dto) {
    	Templates result = modelMapper.map(dto, Templates.class);
        return result;
    }

}
