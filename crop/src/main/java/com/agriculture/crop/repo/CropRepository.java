package com.agriculture.crop.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agriculture.crop.model.Crop;

public interface CropRepository extends MongoRepository<Crop, Integer> {

	Optional<Crop> findByType(String type);

	Crop findByName(String name);
}
