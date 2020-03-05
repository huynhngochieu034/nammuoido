package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Notifications;

public interface NotificationsRepository extends MongoRepository<Notifications, String>{
	Notifications findBy_id(ObjectId _id);
}
