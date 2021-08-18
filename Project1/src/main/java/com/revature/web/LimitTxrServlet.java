package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.Transaction;
import com.revature.repository.TransactionRepository;
import com.revature.repository.TransactionRepositoryImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/limit-txr" })
public class LimitTxrServlet extends HttpServlet{
	
	private TransactionRepository transactionRepository = new TransactionRepositoryImpl();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int limit = Integer.parseInt(req.getParameter("limit"));
				
		List<Transaction> txns = transactionRepository.getTransaction(HistoryServlet.account, limit);
		
		req.setAttribute("txns", txns);

		req.getRequestDispatcher("all.jsp").forward(req, resp);
	}
	
}
