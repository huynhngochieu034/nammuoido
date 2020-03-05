package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.ModulesDTO;
import com.noname.awn.model.Modules;

@Component
public class ModulesConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ModulesDTO convertToDto(Modules entity) {
		ModulesDTO result = modelMapper.map(entity, ModulesDTO.class);
        return result;
    }

    public Modules convertToEntity(ModulesDTO dto) {
    	Modules result = modelMapper.map(dto, Modules.class);
        return result;
    }

}
