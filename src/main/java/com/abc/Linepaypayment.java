package com.abc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.ShopLoginmanagement.model.Employee;
import net.javaguides.ShopLoginmanagement.model.ShopLog;
import net.javaguides.linepaymanagement.dao.LinepayDAO;
import net.javaguides.linepaymanagement.model.Linpay;
import net.javaguides.shopcartmanagement.dao.ShopcartDAO;
import net.javaguides.shopcartmanagement.model.Shopcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class Linepaypayment
 */
public class Linepaypayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinepayDAO linepayDAO;
	/**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		linepayDAO = new LinepayDAO();
	}
    public Linepaypayment() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html, utf-8");
		PrintWriter out=response.getWriter();
		
		
		ServletContext ctx = getServletContext();
		int uid = (int)ctx.getAttribute("id");
		
		
		Linpay url = linepayDAO.selectUrlById(uid);
		List<Linpay> utime=linepayDAO.selectUrByDate(uid);
		
		System.out.println(url.getUrl());
		
		try {
		
			if(utime.size()!=0 && utime.get(0).getTime().toString()!="") {
				response.sendRedirect(url.getUrl());
				out.close();
			}else {
				response.sendRedirect("listShop");
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
