package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Seats;

public interface SeatsRepository extends MongoRepository<Seats, String>{
	Seats findBy_id(ObjectId _id);
}
