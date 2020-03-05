package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Steps;

public interface StepsRepository extends MongoRepository<Steps, String>{
	Steps findBy_id(ObjectId _id);
}
