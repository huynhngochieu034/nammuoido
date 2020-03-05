package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Limits;

public interface LimitsRepository extends MongoRepository<Limits, String>{
	Limits findBy_id(ObjectId _id);
}
