package com.revature.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(urlPatterns = { "/range-txr" })
public class RangeTxrServlet extends HttpServlet {

	private TransactionRepository transactionRepository = new TransactionRepositoryImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String from = req.getParameter("fromDate");
		String to = req.getParameter("toDate");

		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(to));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 1);
		to = sdf.format(c.getTime());
		
		Date fromDate = null, toDate = null;
		try {
			fromDate = sdf.parse(from);
			toDate = sdf.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Transaction> txns = transactionRepository.getTransaction(HistoryServlet.account, fromDate, toDate);

		req.setAttribute("txns", txns);

		req.getRequestDispatcher("all.jsp").forward(req, resp);
	}

}
