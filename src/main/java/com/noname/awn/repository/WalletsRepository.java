package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.model.Wallets;

public interface WalletsRepository extends MongoRepository<Wallets, String>{
	Wallets findBy_id(ObjectId _id);
}
