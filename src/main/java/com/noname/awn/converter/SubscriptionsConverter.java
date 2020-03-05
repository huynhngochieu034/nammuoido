package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.SubscriptionsDTO;
import com.noname.awn.model.Subscriptions;

@Component
public class SubscriptionsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SubscriptionsDTO convertToDto(Subscriptions entity) {
		SubscriptionsDTO result = modelMapper.map(entity, SubscriptionsDTO.class);
        return result;
    }

    public Subscriptions convertToEntity(SubscriptionsDTO dto) {
    	Subscriptions result = modelMapper.map(dto, Subscriptions.class);
        return result;
    }

}
