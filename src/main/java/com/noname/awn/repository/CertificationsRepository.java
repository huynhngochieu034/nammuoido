package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Certifications;

public interface CertificationsRepository extends MongoRepository<Certifications, String>{
	Certifications findBy_id(ObjectId _id);
}
