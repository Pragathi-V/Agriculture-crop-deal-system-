package com.agriculture.authentication.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agriculture.authentication.models.ERole;
import com.agriculture.authentication.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
