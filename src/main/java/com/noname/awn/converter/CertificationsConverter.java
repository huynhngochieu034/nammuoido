package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.CertificationsDTO;
import com.noname.awn.model.Certifications;

@Component
public class CertificationsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CertificationsDTO convertToDto(Certifications entity) {
		CertificationsDTO result = modelMapper.map(entity, CertificationsDTO.class);
        return result;
    }

    public Certifications convertToEntity(CertificationsDTO dto) {
    	Certifications result = modelMapper.map(dto, Certifications.class);
        return result;
    }

}
