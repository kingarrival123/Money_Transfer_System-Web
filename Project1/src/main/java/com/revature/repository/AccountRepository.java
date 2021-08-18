package com.revature.repository;

public interface AccountRepository {

	boolean check(String account);
	
	double balance(String account);

	void update(String accountNumber, double balance);
	
}
