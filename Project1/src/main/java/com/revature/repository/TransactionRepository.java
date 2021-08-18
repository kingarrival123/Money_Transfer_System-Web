package com.revature.repository;

import java.util.Date;
import java.util.List;

import com.revature.entity.*;

public interface TransactionRepository {

	void save(Transaction transaction);
	
	List<Transaction> getTransaction(String account);
	
	List<Transaction> getTransaction(String account, int limit);

	List<Transaction> getTransaction(String account, Date fromDate, Date toDate);
	
}
