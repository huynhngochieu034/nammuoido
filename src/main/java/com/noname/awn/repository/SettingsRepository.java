package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Settings;

public interface SettingsRepository extends MongoRepository<Settings, String>{
	Settings findBy_id(ObjectId _id);
}
