package net.javaguides.menumanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.menumanagement.dao.MenuDAO;
import net.javaguides.menumanagement.model.menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

@SuppressWarnings("unused")
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO menuDAO;
	
	public void init() {
		menuDAO = new MenuDAO();
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
			case "/listItem":
			default: 
				listItem(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	//jsp.listItem
	private void listItem(HttpServletRequest request, HttpServletResponse response)  //default
			throws SQLException, IOException, ServletException {
		List<menu> menulist = menuDAO.selectAllItem();
		request.setAttribute("menulist", menulist);
		jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
	}


}
