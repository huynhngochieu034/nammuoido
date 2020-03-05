package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Templates;

public interface TemplatesRepository extends MongoRepository<Templates, String>{
	Templates findBy_id(ObjectId _id);
}
