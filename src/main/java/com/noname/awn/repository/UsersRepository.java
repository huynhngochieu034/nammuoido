package com.noname.awn.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.noname.awn.model.Users;

public interface UsersRepository extends MongoRepository<Users, String>{
	Users findBy_id(ObjectId _id);
	Optional<Users> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
