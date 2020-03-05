package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Operations;

public interface OperationsRepository extends MongoRepository<Operations, String>{
	Operations findBy_id(ObjectId _id);
}
