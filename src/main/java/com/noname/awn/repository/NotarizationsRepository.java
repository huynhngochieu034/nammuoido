package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Notarizations;

public interface NotarizationsRepository extends MongoRepository<Notarizations, String>{
	Notarizations findBy_id(ObjectId _id);
}
