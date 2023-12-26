package adminController;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import database.cartDAO;
import database.cart_detailDAO;
import database.orderDAO;
import database.orderDetailDAO;
import database.usersDAO;
import model.Cart;
import model.Order;
import model.Users;

/**
 * Servlet implementation class userController
 */
@WebServlet("/admin/user")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("allUser")) {
			allUser(request,response);
		}else if(action.equals("updateOrDelete")) {
			updateOrDelete(request,response);
		}else if(action.equals("updateUser")) {
			updateUser(request, response);
		}
	}

	private void updateOrDelete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idUser = request.getParameter("idUser");
			String status = request.getParameter("status");
			String url = "";
			usersDAO userD = new usersDAO();
			Users user = new Users();
			user.setUserId(idUser);
			if(status.equals("update")) {
				request.setAttribute("user", userD.selectById(user));
				url= "/Admin/updateUser.jsp";
			}
			if(status.equals("delete")) {
				deleteUser(request, response, idUser);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			
		}
	}



	private void deleteUser(HttpServletRequest request, HttpServletResponse response,String idUser) {
		cartDAO cartD = new cartDAO();
		Cart cart = cartD.selectByUser(idUser);
		if(cart!=null) {
			cart_detailDAO cartDetailD = new cart_detailDAO();
			cartDetailD.deleteCartId(cart.getCartId());
			cartD.delete(cart);			
		}
		Users user = new Users();
		user.setUserId(idUser);
		
		orderDAO orderD = new orderDAO();
		ArrayList<Order> orderList = orderD.selectAllOrderByUser(user);
		
		if(orderList!=null) {
			for(Order order : orderList) {
				orderDetailDAO orderDetailD = new orderDetailDAO();
				orderDetailD.deleteOrderId(order.getOrderId());
				orderD.delete(order);
			}
		}
		
		usersDAO usersD = new usersDAO();
		usersD.delete(user);
		allUser(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idUser = request.getParameter("idUser");
			String fullName = request.getParameter("fullName");
			String userName = request.getParameter("userName");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			
			String url ="";
			
			usersDAO userD = new usersDAO();
			Users userSearch = new Users();
			userSearch.setUserId(idUser);
			Users user = userD.selectById(userSearch);
			user.setFullName(fullName);
			user.setUserName(userName);
			user.setAddress(address);
			user.setSex(sex);
			
			userD.updateAdminUser(user);
			
			url = "/Admin/updateUser.jsp";
			
			request.setAttribute("user", userD.selectById(userSearch));
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void allUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			usersDAO userD = new usersDAO();
			request.setAttribute("listUser", userD.selectAll());
			String url = "/Admin/allUser.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
