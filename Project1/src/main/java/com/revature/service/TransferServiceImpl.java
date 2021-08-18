package com.revature.service;

import java.util.Date;

import com.revature.entity.Transaction;
import com.revature.entity.TxrType;
import com.revature.exceptions.InsufficientAmountException;
import com.revature.exceptions.InvalidAccountDetailsException;
import com.revature.repository.AccountRepository;
import com.revature.repository.AccountRepositoryImpl;
import com.revature.repository.TransactionRepository;
import com.revature.repository.TransactionRepositoryImpl;

public class TransferServiceImpl implements TransferService{

	@Override
	public void txr(String fromAccount, String toAccount, double amount) {

		AccountRepository accountRepository = new AccountRepositoryImpl();
		TransactionRepository transactionRepository = new TransactionRepositoryImpl();
		Transaction transaction = null;
		
		boolean flag;
		int count = 0;
		try {
			flag = accountRepository.check(fromAccount);
			if(!flag) {
				count=1;
				throw new InvalidAccountDetailsException();
			}
			flag = accountRepository.check(toAccount);
			if(!flag) {
				throw new InvalidAccountDetailsException();
			}
			if(accountRepository.balance(fromAccount)<amount) {
				throw new InsufficientAmountException();
			}else {
				accountRepository.update(fromAccount, accountRepository.balance(fromAccount)-amount);
				transaction = new Transaction(fromAccount, new Date(), amount, TxrType.DEBIT);
				transactionRepository.save(transaction);
				accountRepository.update(toAccount, accountRepository.balance(toAccount)+amount);
				transaction = new Transaction(toAccount, new Date(), amount, TxrType.CREDIT);
				transactionRepository.save(transaction);
			}
		} catch (InvalidAccountDetailsException e) {
			if(count == 1) {
				System.out.println(e.getMessage()+fromAccount);
			}else {
				System.out.println(e.getMessage()+toAccount);
			}
			
		} catch (InsufficientAmountException e) {
			System.out.println(e.getMessage()+fromAccount);
		}
		
	}

}
