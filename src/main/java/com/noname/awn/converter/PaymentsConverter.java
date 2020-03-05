package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.PaymentsDTO;
import com.noname.awn.model.Payments;

@Component
public class PaymentsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PaymentsDTO convertToDto(Payments entity) {
		PaymentsDTO result = modelMapper.map(entity, PaymentsDTO.class);
        return result;
    }

    public Payments convertToEntity(PaymentsDTO dto) {
    	Payments result = modelMapper.map(dto, Payments.class);
        return result;
    }

}
