package com.agriculture.crop.service;

import java.util.List;

import com.agriculture.crop.exceptions.CropNotFoundException;
import com.agriculture.crop.exceptions.NoProperDataException;
import com.agriculture.crop.model.Crop;

public interface CropService {

	List<Crop> getAllCrop() ;

	Crop addCrop(Crop crop) throws NoProperDataException;


	String deleteCrop(int id) throws CropNotFoundException;

	Crop getCrop(int id) throws CropNotFoundException;

}
