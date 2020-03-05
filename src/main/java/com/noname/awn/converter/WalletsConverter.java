package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.WalletsDTO;
import com.noname.awn.model.Wallets;

@Component
public class WalletsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public WalletsDTO convertToDto(Wallets entity) {
		WalletsDTO result = modelMapper.map(entity, WalletsDTO.class);
        return result;
    }

    public Wallets convertToEntity(WalletsDTO dto) {
    	Wallets result = modelMapper.map(dto, Wallets.class);
        return result;
    }

}
