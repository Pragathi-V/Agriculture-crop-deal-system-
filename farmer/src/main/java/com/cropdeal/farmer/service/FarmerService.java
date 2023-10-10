package com.cropdeal.farmer.service;

import java.util.List;

import com.cropdeal.farmer.exceptions.FarmerNotFoundException;
import com.cropdeal.farmer.exceptions.NoProperDataException;
import com.cropdeal.farmer.model.Farmer;

public interface FarmerService {

	List<Farmer> getAllFarmer() throws FarmerNotFoundException;

	Farmer addFarmer(Farmer farmer) throws  NoProperDataException;


	String deleteFarmer(Integer id) throws FarmerNotFoundException;

	Farmer getFarmer(int id) throws FarmerNotFoundException;

}
