package controller;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BookDAO;
import database.cartDAO;
import database.cart_detailDAO;
import database.orderDAO;
import database.orderDetailDAO;
import database.payDAO;
import model.Books;
import model.Cart;
import model.Cart_detail;
import model.Order;
import model.Order_detail;
import model.Users;
import model.pay;

/**
 * Servlet implementation class orderController
 */
@WebServlet("/order")
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("buy")) {
			String idBook = request.getParameter("idBook");
			String url ="";
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null) {
				url="/login.jsp";
			}else {
				user = (Users)obj;
				Books bookSearch = new Books();
				bookSearch.setIdBook(idBook);
				BookDAO bookD = new BookDAO();
				Books book = bookD.selectById(bookSearch);
				request.setAttribute("user", user);
				request.setAttribute("book", book);
				System.out.println(book);
				url ="/order.jsp"; 
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}else if(action.equals("order")) {
			String url = "";
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null) {
				url="/login.jsp";
			}else {
				user = (Users)obj;
				
				String paymentMethod = request.getParameter("paymentMethod");
				String orderDate = request.getParameter("orderDate");
				String receivingAddress = request.getParameter("deliveryAddress");
				String orderDetailId = UUID.randomUUID().toString();
				String bookId = request.getParameter("idBook");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				String orderId = UUID.randomUUID().toString();
				
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(paymentMethod);
				pay pay = payD.selectById(paySearch);
				
				BookDAO bookD = new BookDAO();
				Books bookSearch = new Books();
				bookSearch.setIdBook(bookId);
				
				Books book = bookD.selectById(bookSearch);	
				
				double totalPrice = book.getPrice()*quantity;
				
				Order order = new Order(orderId, user, pay, Date.valueOf(orderDate), "Pending", null, receivingAddress,totalPrice);
				orderDAO orderD = new orderDAO();
				orderD.insert(order);
				
				
				
				
				Order_detail orderDetail = new Order_detail(orderDetailId, bookSearch, order, quantity, book.getPrice(), null, totalPrice);
				
				orderDetailDAO orderDetailD = new orderDetailDAO();
				orderDetailD.insert(orderDetail);
				request.setAttribute("cart-list",null);
				url = "/success.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}else if(action.equals("orderCart")) {
			String url = "";
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("user");
			
			cart_detailDAO cartDetailD = new cart_detailDAO();
			ArrayList<Cart_detail> cartList = cartDetailD.selectCartDetailByUser(user.getUserId());
			
			request.setAttribute("cartList", cartList);
			request.setAttribute("user", user);
			url = "/orderCart.jsp";
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}else if(action.equals("payCart")) {
			String url = "";
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null) {
				url="/login.jsp";
			}else {
				user = (Users)obj;
				
				String paymentMethod = request.getParameter("paymentMethod");
				String orderDate = request.getParameter("orderDate");
				String receivingAddress = request.getParameter("deliveryAddress");
				
				
				String orderId = UUID.randomUUID().toString();
				
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(paymentMethod);
				pay pay = payD.selectById(paySearch);
				
				Order order = new Order(orderId, user, pay, Date.valueOf(orderDate), "Pending", null, receivingAddress);
				orderDAO orderD = new orderDAO();
				orderD.insert(order);
				
				
				
				cart_detailDAO cartDetailD = new cart_detailDAO();
				ArrayList<Cart_detail> cartDetailList = cartDetailD.selectCartDetailByUser(user.getUserId());
				
				orderDetailDAO orderDetailD = new orderDetailDAO();
				for(Cart_detail cartDetail : cartDetailList) {
					double totalPrice = cartDetail.getBooks().getPrice()*cartDetail.getQuantity();
					String orderDetailId = UUID.randomUUID().toString();
					Order_detail orderDetail = new Order_detail(orderDetailId, cartDetail.getBooks(), order, cartDetail.getQuantity(), cartDetail.getBooks().getPrice(), null, totalPrice);					
					orderDetailD.insert(orderDetail);
					cartDetailD.deleteBookId(cartDetail.getBooks().getIdBook());
				}
				
				double totalOrder = orderD.totalOrder(order);
				orderD.updateTotal(totalOrder, orderId);
				url = "/success.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
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
