package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.LicencesDTO;
import com.noname.awn.model.Licences;

@Component
public class LicencesConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public LicencesDTO convertToDto(Licences entity) {
		LicencesDTO result = modelMapper.map(entity, LicencesDTO.class);
        return result;
    }

    public Licences convertToEntity(LicencesDTO dto) {
    	Licences result = modelMapper.map(dto, Licences.class);
        return result;
    }

}
