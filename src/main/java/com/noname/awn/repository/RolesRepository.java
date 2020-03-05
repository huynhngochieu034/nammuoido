package com.noname.awn.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.noname.awn.enums.ERole;
import com.noname.awn.model.Roles;

public interface RolesRepository extends MongoRepository<Roles, String>{
	Optional<Roles> findByName(ERole name);
}
