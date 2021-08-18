package com.revature.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction",schema = "txr")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	private double amount;
	@Column(name = "time_stamp")
	private Date date;
	@Column(name="creditOrDebit")
	
	private TxrType creditOrDebit;
	@Column(name="accountNumber")
	
	private String account;

	public Transaction(String account, Date date, double amount, TxrType creditOrDebit) {
		super();
		this.account = account;
		this.date = date;
		this.amount = amount;
		this.creditOrDebit = creditOrDebit;
	}

	public Transaction() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getTransactionId() {
		return transaction_id;
	}

	public void setTransactionId(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxrType getCreditOrDebit() {
		return creditOrDebit;
	}

	public void setCreditOrDebit(TxrType creditOrDebit) {
		this.creditOrDebit = creditOrDebit;
	}

	@Override
	public String toString() {
		return "TransactionId = " + transaction_id + ", Account Number = " + account + ", date = " + date + ", amount = "
				+ amount + ", creditOrDebit = " + creditOrDebit;
	}

}
