package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Devices;

public interface DevicesRepository extends MongoRepository<Devices, String>{
	Devices findBy_id(ObjectId _id);
}
