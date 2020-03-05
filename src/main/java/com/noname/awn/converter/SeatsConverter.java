package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.SeatsDTO;
import com.noname.awn.model.Seats;

@Component
public class SeatsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SeatsDTO convertToDto(Seats entity) {
		SeatsDTO result = modelMapper.map(entity, SeatsDTO.class);
        return result;
    }

    public Seats convertToEntity(SeatsDTO dto) {
    	Seats result = modelMapper.map(dto, Seats.class);
        return result;
    }

}
