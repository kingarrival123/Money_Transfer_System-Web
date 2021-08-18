package com.revature.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account", schema = "txr")
public class Account {

	@Id
	private String accountNumber;
	private double accountBalance;
	
	public Account(String accountNumber, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public Account() {

	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Amount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	
}
