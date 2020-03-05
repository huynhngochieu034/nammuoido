package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Status;

public interface StatusRepository extends MongoRepository<Status, String>{
	Status findBy_id(ObjectId _id);
}
