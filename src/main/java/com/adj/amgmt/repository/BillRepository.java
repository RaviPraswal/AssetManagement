package com.adj.amgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adj.amgmt.entity.Bill;
import com.adj.amgmt.entity.User;

public interface BillRepository extends MongoRepository<Bill, Integer>{

	public Bill findByfileName(String billName);
}
