package com.cropdeal.farmer.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.farmer.model.Farmer;


public interface FarmerRepo extends MongoRepository<Farmer, Integer> {


	Optional<Farmer> findByName(String name);

}
