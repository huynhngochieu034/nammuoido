package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Parameters;

public interface ParametersRepository extends MongoRepository<Parameters, String>{
	Parameters findBy_id(ObjectId _id);
}
