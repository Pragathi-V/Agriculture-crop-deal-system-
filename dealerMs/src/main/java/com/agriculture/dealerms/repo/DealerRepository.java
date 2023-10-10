package com.agriculture.dealerms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agriculture.dealerms.model.Dealer;

public interface DealerRepository extends MongoRepository<Dealer, Integer> {

	//Optional<Dealer> findByType(String type);

	Optional<Dealer> findByName(String name);

}
