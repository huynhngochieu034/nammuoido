package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.DocumentsDTO;
import com.noname.awn.model.Documents;

@Component
public class DocumentsConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DocumentsDTO convertToDto(Documents entity) {
		DocumentsDTO result = modelMapper.map(entity, DocumentsDTO.class);
        return result;
    }

    public Documents convertToEntity(DocumentsDTO dto) {
    	Documents result = modelMapper.map(dto, Documents.class);
        return result;
    }

}
