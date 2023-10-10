package com.agriculture.dealerms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agriculture.dealerms.exceptions.DealerNotFoundException;
import com.agriculture.dealerms.model.Dealer;
import com.agriculture.dealerms.repo.DealerRepository;
import com.agriculture.dealerms.exceptions.NoProperDataException;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DealerServiceImp implements DealerService {
	Logger logger= LoggerFactory.getLogger(DealerServiceImp.class);
	
	@Autowired
	private DealerRepository dealerRepository ;
	
	
	@Override
	public List<Dealer> getAllDealer()  {
		logger.info("get all customers");
		return dealerRepository.findAll();
}
	
	@Override
	public Dealer addDealer(Dealer dealer) throws NoProperDataException {
		
		if(dealer!=null) 
		{
			dealerRepository.save(dealer);
			logger.info("dealer added {}",dealer);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return dealer;
	}
	

	
	@Override
	public Dealer getDealer(int id) throws DealerNotFoundException {
		Dealer dealers=dealerRepository.findById(id).orElseThrow(()-> new  DealerNotFoundException("dealer Not Found"+id));
		logger.info("customers getbyid {}",dealers);
		return dealers;
	}

	



	@Override
	public String deleteDealer(Integer id) throws DealerNotFoundException {
		logger.info("Start delete");
		var isRemoved =dealerRepository.findById(id);
		if(isRemoved.isPresent())
		{
			dealerRepository.deleteById(id);
			logger.info("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new DealerNotFoundException("Id Not Available");
		}
		logger.info(" deleted End");
		return " deleted successfully";
	}

public Dealer save(@Valid Dealer dealer) {
		return dealerRepository.save(dealer);
	}

	
	public Optional<Dealer> findByName(String name) {
		return dealerRepository.findByName(name);
	}

	public Optional<Dealer> findById(int id) {
		return dealerRepository.findById(id);
	}

	public void deleteById(int id) {
		dealerRepository.deleteById(id);
	}

	public void deleteAll() {
		dealerRepository.deleteAll();
	}

	public List<Dealer> findAll() {
		return dealerRepository.findAll();
	}

	public Object getDealerById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object deleteDealerById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object updateDealer(Dealer p1) {
		// TODO Auto-generated method stub
		return null;
	}

	

}