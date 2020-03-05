package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.DevicesDTO;
import com.noname.awn.model.Devices;

@Component
public class DevicesConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DevicesDTO convertToDto(Devices entity) {
		DevicesDTO result = modelMapper.map(entity, DevicesDTO.class);
        return result;
    }

    public Devices convertToEntity(DevicesDTO dto) {
    	Devices result = modelMapper.map(dto, Devices.class);
        return result;
    }

}
