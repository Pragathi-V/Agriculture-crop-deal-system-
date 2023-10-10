package com.agriculture.dealerms.service;

import java.util.List;

import com.agriculture.dealerms.exceptions.DealerNotFoundException;
import com.agriculture.dealerms.model.Dealer;
import com.agriculture.dealerms.exceptions.NoProperDataException;

public interface DealerService {

	List<Dealer> getAllDealer() throws DealerNotFoundException;

	Dealer addDealer(Dealer dealer) throws NoProperDataException;


	String deleteDealer(Integer id) throws DealerNotFoundException;

	Dealer getDealer(int id) throws DealerNotFoundException;

}
