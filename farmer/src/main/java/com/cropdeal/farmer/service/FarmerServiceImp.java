package com.cropdeal.farmer.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.farmer.exceptions.FarmerNotFoundException;
import com.cropdeal.farmer.exceptions.NoProperDataException;
import com.cropdeal.farmer.model.Farmer;
import com.cropdeal.farmer.repo.FarmerRepo;

@Service
public class FarmerServiceImp implements FarmerService {

	Logger logger= LoggerFactory.getLogger(FarmerService.class);
	
	@Autowired
	private FarmerRepo farmerRepo ;
	
	
	@Override
	public List<Farmer> getAllFarmer()  {
		//System.out.printf("get all customers");
		logger.info("get all customers");
		return farmerRepo.findAll();
}
	
	@Override
	public Farmer addFarmer(Farmer farmer) throws NoProperDataException {
		
		if(farmer!=null) 
		{
			farmerRepo.save(farmer);
			//System.out.printf("farmer added {}",farmer);
			logger.info("farmer added {}",farmer);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return farmer;
	}
	

	
	@Override
	public Farmer getFarmer(int id) throws FarmerNotFoundException {
		Farmer farmers=farmerRepo.findById(id).orElseThrow(()-> new  FarmerNotFoundException("farmer Not Found"+id));
		//System.out.printf("customers getbyid {}",farmers);
		logger.info("customers getbyid {}",farmers);
		return farmers;
	}

	



	@Override
	public String deleteFarmer(Integer id) throws FarmerNotFoundException {
		//System.out.printf("Start delete");
		logger.info("Start delete");
		var isRemoved =farmerRepo.findById(id);
		if(isRemoved.isPresent())
		{
			farmerRepo.deleteById(id);
			//System.out.printf("deleted successfully {}",isRemoved.get());
			logger.error("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new FarmerNotFoundException("Id Not Available");
		}
		//System.out.printf(" deleted End");
		logger.info("deleted End");
		return " deleted successfully";
	}

public Farmer save(@Valid Farmer farmer) {
		return farmerRepo.save(farmer);
	}

	
	public Optional<Farmer> findByName(String name) {
		return farmerRepo.findByName(name);
	}

	public Optional<Farmer> findById(int id) {
		return farmerRepo.findById(id);
	}

	public void deleteById(int id) {
		farmerRepo.deleteById(id);
	}

	public void deleteAll() {
		farmerRepo.deleteAll();
	}

	public List<Farmer> findAll() {
		return farmerRepo.findAll();
	}

	public Object updateFarmer(Farmer f1) {
		// TODO Auto-generated method stub
		return null;
	}

	

}