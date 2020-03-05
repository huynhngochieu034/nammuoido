package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Presets;

public interface PresetsRepository extends MongoRepository<Presets, String>{
	Presets findBy_id(ObjectId _id);
}
