package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.SettingsDTO;
import com.noname.awn.model.Settings;

@Component
public class SettingsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SettingsDTO convertToDto(Settings entity) {
		SettingsDTO result = modelMapper.map(entity, SettingsDTO.class);
        return result;
    }

    public Settings convertToEntity(SettingsDTO dto) {
    	Settings result = modelMapper.map(dto, Settings.class);
        return result;
    }

}
