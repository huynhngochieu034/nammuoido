package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.PresetsDTO;
import com.noname.awn.model.Presets;

@Component
public class PresetsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PresetsDTO convertToDto(Presets entity) {
		PresetsDTO result = modelMapper.map(entity, PresetsDTO.class);
        return result;
    }

    public Presets convertToEntity(PresetsDTO dto) {
    	Presets result = modelMapper.map(dto, Presets.class);
        return result;
    }

}
