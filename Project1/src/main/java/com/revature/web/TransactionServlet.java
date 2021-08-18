package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.TransferService;
import com.revature.service.TransferServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/new-transaction" })
public class TransactionServlet extends HttpServlet{

	TransferService transferService = new TransferServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fromAccount = req.getParameter("fromAccount");
		String toAccount = req.getParameter("toAccount");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		transferService.txr(fromAccount, toAccount, amount);

		resp.sendRedirect("transaction.html");
	}
	
}
