package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Tasks;

public interface TasksRepository extends MongoRepository<Tasks, String>{
	Tasks findBy_id(ObjectId _id);
}
