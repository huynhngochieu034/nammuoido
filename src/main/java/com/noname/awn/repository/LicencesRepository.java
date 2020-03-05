package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Licences;

public interface LicencesRepository extends MongoRepository<Licences, String>{
	Licences findBy_id(ObjectId _id);
}
