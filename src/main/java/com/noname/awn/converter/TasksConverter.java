package com.noname.awn.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noname.awn.dto.TasksDTO;
import com.noname.awn.model.Tasks;

@Component
public class TasksConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public TasksDTO convertToDto(Tasks entity) {
		TasksDTO result = modelMapper.map(entity, TasksDTO.class);
        return result;
    }

    public Tasks convertToEntity(TasksDTO dto) {
    	Tasks result = modelMapper.map(dto, Tasks.class);
        return result;
    }

}
