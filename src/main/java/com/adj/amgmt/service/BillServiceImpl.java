package com.adj.amgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adj.amgmt.entity.Bill;
import com.adj.amgmt.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillRepository billRepository;
	
	public Bill getByName(String billName) {
		Bill findByfileName = billRepository.findByfileName(billName);
		return findByfileName;
	}
}
