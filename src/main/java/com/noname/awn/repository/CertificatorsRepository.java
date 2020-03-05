package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Certificators;

public interface CertificatorsRepository extends MongoRepository<Certificators, String>{
	Certificators findBy_id(ObjectId _id);
}
