package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.InfosDTO;
import com.noname.awn.model.Infos;

@Component
public class InfosConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public InfosDTO convertToDto(Infos entity) {
		InfosDTO result = modelMapper.map(entity, InfosDTO.class);
        return result;
    }

    public Infos convertToEntity(InfosDTO dto) {
    	Infos result = modelMapper.map(dto, Infos.class);
        return result;
    }

}
