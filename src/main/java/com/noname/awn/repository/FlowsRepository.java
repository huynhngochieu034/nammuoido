package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Flows;

public interface FlowsRepository extends MongoRepository<Flows, String>{
	Flows findBy_id(ObjectId _id);
}
