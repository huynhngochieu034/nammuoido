package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Infos;

public interface InfosRepository extends MongoRepository<Infos, String>{
	Infos findBy_id(ObjectId _id);
}
