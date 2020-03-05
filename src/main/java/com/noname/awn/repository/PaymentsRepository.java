package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Payments;

public interface PaymentsRepository extends MongoRepository<Payments, String>{
	Payments findBy_id(ObjectId _id);
}
