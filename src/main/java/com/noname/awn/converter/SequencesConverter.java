package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.SequencesDTO;
import com.noname.awn.model.Sequences;

@Component
public class SequencesConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SequencesDTO convertToDto(Sequences entity) {
		SequencesDTO result = modelMapper.map(entity, SequencesDTO.class);
        return result;
    }

    public Sequences convertToEntity(SequencesDTO dto) {
    	Sequences result = modelMapper.map(dto, Sequences.class);
        return result;
    }

}
