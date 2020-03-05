package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Modules;

public interface ModulesRepository extends MongoRepository<Modules, String>{
	Modules findBy_id(ObjectId _id);
}
