package com.revature.exceptions;

@SuppressWarnings("serial")
public class InsufficientAmountException extends Exception{
	@Override
	public String getMessage() {
		return "Insufficient amount to debit from account ";
	}
}
