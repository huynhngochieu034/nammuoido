package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.CustomersDTO;
import com.noname.awn.model.Customers;

@Component
public class CustomersConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CustomersDTO convertToDto(Customers entity) {
		CustomersDTO result = modelMapper.map(entity, CustomersDTO.class);
        return result;
    }

    public Customers convertToEntity(CustomersDTO dto) {
    	Customers result = modelMapper.map(dto, Customers.class);
        return result;
    }

}
