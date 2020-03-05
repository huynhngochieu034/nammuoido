package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Sequences;

public interface SequencesRepository extends MongoRepository<Sequences, String>{
	Sequences findBy_id(ObjectId _id);
}
