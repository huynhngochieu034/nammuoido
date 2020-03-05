package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.NotarizationsDTO;
import com.noname.awn.model.Notarizations;

@Component
public class NotarizationsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public NotarizationsDTO convertToDto(Notarizations entity) {
		NotarizationsDTO result = modelMapper.map(entity, NotarizationsDTO.class);
        return result;
    }

    public Notarizations convertToEntity(NotarizationsDTO dto) {
    	Notarizations result = modelMapper.map(dto, Notarizations.class);
        return result;
    }

}
