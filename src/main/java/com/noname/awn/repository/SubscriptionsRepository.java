package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Subscriptions;

public interface SubscriptionsRepository extends MongoRepository<Subscriptions, String>{
	Subscriptions findBy_id(ObjectId _id);
}
