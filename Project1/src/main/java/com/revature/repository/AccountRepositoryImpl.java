package com.revature.repository;

import javax.persistence.EntityManager;

import com.revature.entity.Account;
import com.revature.jpa.LocalEntityManageFactory;

public class AccountRepositoryImpl implements AccountRepository{

	public boolean check(String account) {
		
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, account);
		
		em.getTransaction().commit();
		em.close();
		
		if(acc==null) {
			return false;
		}else {
			return true;
		}
	}

	public double balance(String account) {
		
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		Account acc = em.find(Account.class, account);
		double bal = acc.getAccountBalance();
		
		em.getTransaction().commit();
		em.close();
		
		return bal;
	}

	public void update(String accountNumber, double balance) {
		
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();

		Account account = em.find(Account.class, accountNumber);
		account.setAccountBalance(balance);

		em.getTransaction().commit();
		em.close();
		
	}
	
	
	
}
