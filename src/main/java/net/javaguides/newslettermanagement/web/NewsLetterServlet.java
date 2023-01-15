package net.javaguides.newslettermanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.newslettermanagement.dao.NewsLetterDAO;
import net.javaguides.newslettermanagement.model.NewsLetter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

@SuppressWarnings("unused")
public class NewsLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsLetterDAO newsletterDAO;
	
	public void init() {
		newsletterDAO = new NewsLetterDAO();
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
			case "/insertNewsletter":
			default: 
				insertNewsletter(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	//insert & update Shopcart
	private void insertNewsletter(HttpServletRequest request, HttpServletResponse response)   //新增指定欄位insert
			throws SQLException, IOException {
		
			String uemail = request.getParameter("email");
			
			ServletContext ctx = getServletContext(); 
			int uid = (int)ctx.getAttribute("id");
			
			NewsLetter newsletter = new NewsLetter(uid, uemail);
			newsletterDAO.insertNewsletter(newsletter);
		}

}
