package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.CertificatorsDTO;
import com.noname.awn.model.Certificators;

@Component
public class CertificatorsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CertificatorsDTO convertToDto(Certificators entity) {
		CertificatorsDTO result = modelMapper.map(entity, CertificatorsDTO.class);
        return result;
    }

    public Certificators convertToEntity(CertificatorsDTO dto) {
    	Certificators result = modelMapper.map(dto, Certificators.class);
        return result;
    }

}
