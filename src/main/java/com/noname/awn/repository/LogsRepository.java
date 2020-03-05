package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Logs;

public interface LogsRepository extends MongoRepository<Logs, String>{
	Logs findBy_id(ObjectId _id);
}
