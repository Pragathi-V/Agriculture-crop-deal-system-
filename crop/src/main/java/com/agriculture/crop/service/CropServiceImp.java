package com.agriculture.crop.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.agriculture.crop.exceptions.CropNotFoundException;
import com.agriculture.crop.exceptions.NoProperDataException;
import com.agriculture.crop.model.Crop;
import com.agriculture.crop.repo.CropRepository;
import org.slf4j.LoggerFactory;

@Service
public class CropServiceImp implements CropService {

	Logger logger= LoggerFactory.getLogger(CropServiceImp.class);	
	@Autowired
	private CropRepository cropRepository ;
	
	
	@Override
	public List<Crop> getAllCrop()  {
		logger.info("get all crops");
		return cropRepository.findAll();
}
	
	@Override
	public Crop addCrop(Crop crop) throws NoProperDataException {
		
	if(crop!=null) 
		{
			cropRepository.save(crop);
			logger.info("crop added {}",crop);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return crop;
	}
	

	
	@Override
	public Crop getCrop(@PathVariable int id) throws CropNotFoundException {
		Crop crops=cropRepository.findById(id).orElseThrow(()-> new  CropNotFoundException("crop Not Found for id : "+id));
		logger.info("crops getbyid {}",crops);
		return crops;
	}

	



	@Override
	public String deleteCrop(int id) throws CropNotFoundException {
		logger.info("Start delete");
		var isRemoved =cropRepository.findById(id);
		if(isRemoved.isPresent())
		{
			cropRepository.deleteById(id);
			logger.info("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new CropNotFoundException("Id Not Available");
		}
		logger.debug(" deleted End");
		return " deleted successfully";
	}

public Crop save(@Valid Crop crop) {
		return cropRepository.save(crop);
	}

	
//	public Optional<Crop> findByName(String name) {
//		return cropRepository.findByName(name);
//	}

	public Optional<Crop> findById(int id) {
		return cropRepository.findById(id);
	}

	public void deleteById(int id) {
		cropRepository.deleteById(id);
	}

	public void deleteAll() {
		cropRepository.deleteAll();
	}

	public List<Crop> findAll() {
		return cropRepository.findAll();
	}

	public Crop updateCrop(Crop p1) {
		return p1;
	}

	public Crop findByName(String name) {
		return cropRepository.findByName(name);
	}

}