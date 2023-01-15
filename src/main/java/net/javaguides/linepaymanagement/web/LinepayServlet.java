package net.javaguides.linepaymanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.linepaymanagement.dao.LinepayDAO;
import net.javaguides.linepaymanagement.model.Linpay;
import net.javaguides.shopcartmanagement.model.Shopcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

@SuppressWarnings("unused")
public class LinepayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinepayDAO linepayDAO;
	
	public void init() {
		linepayDAO = new LinepayDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/listUrl":
			default: 
				listUrl(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	//jsp.listItem
	private void listUrl(HttpServletRequest request, HttpServletResponse response)  //default
			throws SQLException, IOException, ServletException {
		
		ServletContext ctx = getServletContext();
		int id =(int)ctx.getAttribute("id");
		
		List<Linpay> linepayUrl = linepayDAO.selectUrByDate(id);
		request.setAttribute("linepayUrl", linepayUrl);
		jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("linepay.jsp");
		dispatcher.forward(request, response);
	}


}
