package com.abc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.ShopLoginmanagement.dao.ShopLogDAO;
import net.javaguides.ShopLoginmanagement.model.Employee;
import net.javaguides.ShopLoginmanagement.model.ShopLog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ShoppingCartLogin
 */
@SuppressWarnings("unused")
public class ShoppingCartLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopLogDAO shoplogDAO;
	
	public void init() {
		shoplogDAO = new ShopLogDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartLogin() {
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
		
		//get html value 若學生ID格式不正確
		// if id is not equal String"" or is not int ? true: convert to 0, false: int id
		// ^\\d+ means input starts with 0-9, ()d? means may or may not occur, .\\ means allow one period in input
		int id= request.getParameter("id").equals("") || !request.getParameter("id").matches("^\\d+(\\.\\d+)?") ? 0 : Integer.parseInt(request.getParameter("id"));

		//get DB data
		Employee uid=shoplogDAO.selectUserId(id);
		List<ShopLog> utime=shoplogDAO.selectUserByDate(id);
		

		try {
			//無學生編號則返回登入頁面(alert：請輸入正確格式ID編號)
			if(id == 0) {
				out.print("<script>alert('Please enter Student ID!')</script>");		
				RequestDispatcher rd = request.getRequestDispatcher("restaurantlog.html");
				rd.include(request, response);
			}else {
				//id不正確則返回登入頁面(alert：請輸入有效學生ID)
				 if(uid == null) {
					 out.print("<script>alert('Student ID is invaild! If you have any questions, please contact us.')</script>");		
					 RequestDispatcher rd = request.getRequestDispatcher("restaurantlog.html");
					 rd.include(request, response);
				 }

				 //id存在且今日的time為10點前,成功登入且記得此用戶
				 if(id==uid.getId() && utime.size()!=0 && utime.get(0).getTime().getHours()<10) {	
					ServletContext ctx=getServletContext();
					//如果使用者不重複則成功登入,且寫入ServletContext
					ctx.setAttribute("id", id);
					response.sendRedirect("home.html");
					out.close();
					
				}else{
					out.print("<script>alert('Please clock-in first!')</script>");		
					RequestDispatcher rd = request.getRequestDispatcher("restaurantlog.html");
					rd.include(request, response);
//					response.sendRedirect("restaurantlog.html");
				}
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
