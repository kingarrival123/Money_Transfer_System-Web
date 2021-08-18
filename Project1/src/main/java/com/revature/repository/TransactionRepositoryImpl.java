package com.revature.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.revature.entity.Transaction;
import com.revature.jpa.LocalEntityManageFactory;

public class TransactionRepositoryImpl implements TransactionRepository{

	@Override
	public void save(Transaction transaction) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		em.persist(transaction);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction(String account) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction where account = :account").setParameter("account", account).getResultList();

		em.getTransaction().commit();
		em.close();
		return txns;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction(String account, int range) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction where account = :account order by transactionId desc")
				.setParameter("account", account).setFirstResult(0).setMaxResults(range).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction(String account, Date fromDate, Date toDate) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction where account =:account and date between :fromDate and :toDate")
				.setParameter("account", account)
				.setParameter("fromDate", fromDate)
				.setParameter("toDate", toDate).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}

}
