package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.noname.awn.model.Abis;

public interface AbisRepository extends MongoRepository<Abis, String>{
	Abis findBy_id(ObjectId _id);
}
