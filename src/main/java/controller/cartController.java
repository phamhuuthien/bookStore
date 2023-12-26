package controller;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Books;
import model.Cart;
import model.Cart_detail;
import model.Users;

/**
 * Servlet implementation class cartController
 */
@WebServlet("/cart")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("addCart")) {
			addCart(request, response);
		}else if(action.equals("removeCart")) {
			removeCart(request, response);
		}else if(action.equals("quatityCart")) {
			quatityCart(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idBook = request.getParameter("idBook");
			String url ="";
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj==null) {
				url="/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}else {
//				kiểm tra user đó có cart chưa
				user = (Users)obj;
				cartDAO cartD = new cartDAO();
				Cart cart = null;
				if(cartD.selectByUser(user.getUserId())==null){
					String cartId = UUID.randomUUID().toString();
					cart = new Cart(cartId,user);
					cartD.insert(cart);
					
					
				}else {
					cart = cartD.selectByUser(user.getUserId());
				}
//				BookDAO bookD = new BookDAO();
				cart_detailDAO cartDetailD = new cart_detailDAO();
				Books book = new Books();
				book.setIdBook(idBook);
				if(cartDetailD.selectByIdBook(idBook)==null) {
					Cart_detail cartDetail = new Cart_detail();
					String cartDetailId = UUID.randomUUID().toString();
					cartDetail.setCartDetailId(cartDetailId);
					cartDetail.setCart(cart);
					cartDetail.setBooks(book);
					cartDetail.setQuantity(1);
					cartDetailD.insert(cartDetail);
				}else {
//					out.println("<h3 style='color:crimson; text-align:center'>Sản phẩm đã được thêm vào giỏ hàng.\n<a href='cart.jsp'>Đi đến giỏ hàng</a></h3>");
				}
			}
			
			cart_detailDAO cartDetailD = new cart_detailDAO();
			ArrayList<Cart_detail> cartList = new ArrayList<>();
			cartList = cartDetailD.selectCartDetailByUser(user.getUserId());
			session.setAttribute("cart-list", cartList);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	private void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idBook = request.getParameter("idBook");
			cart_detailDAO cartDetailD = new cart_detailDAO();
			Cart_detail cartDetail = cartDetailD.selectByIdBook(idBook);
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj!=null) {
				user = (Users)obj;
			}else {
				response.sendRedirect("login.jsp");
			}
			if(cartDetail!=null) {
				cartDetailD.delete(cartDetail);
			}else {
				System.out.println("error not found");
			}
			ArrayList<Cart_detail> cartList = new ArrayList<>();
			cartList = cartDetailD.selectCartDetailByUser(user.getUserId());
			session.setAttribute("cart-list", cartList);
			response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void quatityCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cartDetailId = request.getParameter("cartDetailId");
			String quatity = request.getParameter("quatity");
			HttpSession session = request.getSession();
			Users user = null;
			Object obj = session.getAttribute("user");
			if(obj!=null) {
				user = (Users)obj;
			}else {
				response.sendRedirect("login.jsp");
			}
			cart_detailDAO cartDetailD = new cart_detailDAO();
			Cart_detail cartDetailSeach = new Cart_detail();
			cartDetailSeach.setCartDetailId(cartDetailId);
			Cart_detail cartDetail = cartDetailD.selectById(cartDetailSeach);
			System.out.println(cartDetail);
			if(cartDetail!=null) {
				System.out.println(quatity.equals("desc"));
				if(quatity.equals("inc")) {
					cartDetail.setQuantity(cartDetail.getQuantity()+1);
				}
				if(quatity.equals("desc")) {
					if(cartDetail.getQuantity()!=1) {
						cartDetail.setQuantity(cartDetail.getQuantity()-1);						
					}
				}
				cartDetailD.updateQuantity(cartDetail);
			}
			
			ArrayList<Cart_detail> cartList = new ArrayList<>();
			cartList = cartDetailD.selectCartDetailByUser(user.getUserId());
			session.setAttribute("cart-list", cartList);
			response.sendRedirect("cart.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
