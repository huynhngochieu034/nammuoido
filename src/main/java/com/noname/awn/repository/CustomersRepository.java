package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Customers;

public interface CustomersRepository extends MongoRepository<Customers, String>{
	Customers findBy_id(ObjectId _id);
}
