package net.javaguides.shopcartmanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.menumanagement.dao.MenuDAO;
import net.javaguides.menumanagement.model.menu;
import net.javaguides.shopcartmanagement.dao.ShopcartDAO;
import net.javaguides.shopcartmanagement.model.Shopcart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

@SuppressWarnings("unused")
public class shopcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopcartDAO shopcartDAO;
	private MenuDAO menuDAO;
	
	public void init() {
		shopcartDAO = new ShopcartDAO();
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
			case "/insertShop":
				insertShop(request, response);
				break;
				
			case "/deleteShop":
				deleteShop(request, response);
				break;
				
			case "/deleteAllShop":
				deleteALlShop(request, response);
				break;
				
			case "/updateShopPlus":
				updateShopPlus(request, response);
				break;
				
			case "/updateShopMinus":
				updateShopMinus(request, response);
				break;
				
			case "/insertTotalPrice":
				insertTotalPrice(request, response);
				break;
				
			case "/listShop":
			default: 
				listShop(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		};
	}
	

	//shopcart-list.jsp
	private void listShop(HttpServletRequest request, HttpServletResponse response)  //default
			throws SQLException, IOException, ServletException {
		ServletContext ctx=getServletContext();
		//object type
		int id = (int)ctx.getAttribute("id");
		
		List<Shopcart> shopcartlist = shopcartDAO.selectAllShop(id);
		request.setAttribute("shopcartlist", shopcartlist);
		jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("shopcart-list.jsp");
		dispatcher.forward(request, response);
	}
	
	//insert & update Shopcart
	private void insertShop(HttpServletRequest request, HttpServletResponse response)   //新增指定欄位insert
			throws SQLException, IOException {
		
		String menuNo[] = request.getParameterValues("item");
		for(String no : menuNo) {
			int uno = Integer.parseInt(no);
			menu menu = menuDAO.selectItem(uno);
			String uitem = menu.getItem();
			int uquantity = menu.getQuantity();
			int uprice = menu.getPrice();
			String uimage = menu.getImage();
			
			ServletContext ctx = getServletContext(); 
			int uid = (int)ctx.getAttribute("id");
			
			request.setAttribute("menu", menu);
			Shopcart shopcart = new Shopcart(uno, uquantity, uid, uitem, uprice, uimage);
			shopcartDAO.insertShop(shopcart);
		}
		response.sendRedirect("listShop");
	}

	//delete shopcart row by id & no
	private void deleteShop(HttpServletRequest request, HttpServletResponse response)   //刪除欄位delete
			throws SQLException, IOException {
		
		String ShopcartNo[] = request.getParameterValues("no");
		
		for(String no : ShopcartNo) {
			int uno = Integer.parseInt(no);
		
			ServletContext ctx = getServletContext(); 
			int uid = (int)ctx.getAttribute("id");
		
			shopcartDAO.deleteShop(uid, uno);
		}
		response.sendRedirect("listShop");

	}
	
	private void updateShopPlus(HttpServletRequest request, HttpServletResponse response)  //修改欄位update
			throws SQLException, IOException {
		ServletContext ctx = getServletContext(); 
		int uid = (int)ctx.getAttribute("id");
		int uno = Integer.parseInt(request.getParameter("no"));
		
		//from DB
		Shopcart shopcart = shopcartDAO.selectQuantity(uid, uno);
		menu menu = menuDAO.selectItem(uno);
		
		int uquantity = shopcart.getQuantity() + 1;
		int uprice = menu.getPrice() * uquantity;

		Shopcart updatequantity = new Shopcart(uno, uquantity, uid, menu.getItem(), uprice, menu.getImage());
		shopcartDAO.updateQuantity(updatequantity);
		response.sendRedirect("listShop");
	}
	
	private void updateShopMinus(HttpServletRequest request, HttpServletResponse response)  //修改欄位update
			throws SQLException, IOException {
		ServletContext ctx = getServletContext(); 
		int uid = (int)ctx.getAttribute("id");
		int uno = Integer.parseInt(request.getParameter("no"));
		
		//from DB
		Shopcart shopcart = shopcartDAO.selectQuantity(uid, uno);
		menu menu = menuDAO.selectItem(uno);
		
		int uquantity = shopcart.getQuantity();
		if(shopcart.getQuantity() > 1) {
			uquantity  -= 1;
		}else {
			uquantity  += 0;
		}
		int uprice = menu.getPrice() * uquantity;
		
		Shopcart updatequantity = new Shopcart(uno, uquantity, uid, menu.getItem(), uprice, menu.getImage());
		shopcartDAO.updateQuantity(updatequantity);
		response.sendRedirect("listShop");
	}
	
	//delete all Shopcart
		private void deleteALlShop(HttpServletRequest request, HttpServletResponse response)   //刪除欄位delete
				throws SQLException, IOException {
			
				ServletContext ctx = getServletContext(); 
				int uid = (int)ctx.getAttribute("id");
			
				shopcartDAO.deleteAllShop(uid);
				response.sendRedirect("home.html");
		}


	private void insertTotalPrice(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		ServletContext ctx = getServletContext(); 
		int uid = (int)ctx.getAttribute("id");
		int uno = Integer.parseInt(request.getParameter("no"));
		
		//from DB
		menu menu = menuDAO.selectItem(uno);
		
		int uquantity = shopcart.getQuantity();
		int uprice = menu.getPrice() * uquantity;
		
		List<Shopcart> shopcartlist = shopcartDAO.selectAllShop(uid);
		
		
		for(Shopcart price : shopcartlist) {
			int uno = Integer.parseInt(request.getParameter("no"));
		
			ServletContext ctx = getServletContext(); 
			int uid = (int)ctx.getAttribute("id");
		
		shopcartDAO.deleteShop(uid, uno);
		}
			
	}
}
