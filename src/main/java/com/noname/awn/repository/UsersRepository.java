package com.noname.awn.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.noname.awn.model.Users;

public interface UsersRepository extends MongoRepository<Users, String>{
	Users findBy_id(ObjectId _id);
}
