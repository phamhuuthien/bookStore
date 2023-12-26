package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.mysql.cj.Session;

import database.BookDAO;
import database.cart_detailDAO;
import database.orderDAO;
import database.orderDetailDAO;
import database.usersDAO;
import model.Cart_detail;
import model.Order;
import model.Order_detail;
import model.Users;
import util.SendEmail;
import util.encode;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class usersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("login")) {
			login(request, response);
		}else if(action.equals("logout")) {
			logout(request, response); 
		}else if(action.equals("register")) {
			register(request, response);
		}else if(action.equals("updateInfo")) {
			updateInfo(request, response);
		}else if(action.equals("forgotPassword")) {
			forgotPassword(request,response);
		}else if(action.equals("changePasswordWhenLogin")) {
			changePasswordWhenLogin(request,response);
		}else if(action.equals("re_newPassword")) {
			re_newPassword(request,response);
		}else if(action.equals("changePassword")) {
			changePassword(request, response);
		}else if (action.equals("myOrder")) {
			myOder(request,response);
		}
	}


	private void re_newPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String newPassword = request.getParameter("newPassword");
			String conPassword = request.getParameter("conPassword");
			String email = (String) request.getSession().getAttribute("email");
			String url = "";
			String error = "";
			usersDAO userD = new usersDAO();
			if(!newPassword.equals(conPassword)) {
				error ="Con-password is incorrect";
				url="/re_newPassword.jsp";
			}else {
				newPassword = encode.toSHA1(newPassword);
				userD.changePasswordWhenLogin(newPassword,email);
				url = "/login.jsp";
			}
			request.setAttribute("error", error);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void changePasswordWhenLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String o1 = request.getParameter("o1");
		String o2 = request.getParameter("o2");
		String o3 = request.getParameter("o3");
		String o4 = request.getParameter("o4");
		String o5 = request.getParameter("o5");
		String o6 = request.getParameter("o6");
		String otpReset = o1 + o2 + o3 + o4 + o5 + o6;
		String otpSession = (String) request.getSession().getAttribute("otp");
		System.out.println(otpReset);
		System.out.println("====");
		System.out.println(otpSession);
		String url = "";
		if (otpSession != null) {
			if (otpReset.equals(otpSession)) {
				request.getSession().removeAttribute("otp");
				response.sendRedirect("re_newPassword.jsp");
			} else {
				url = "Incorrect authentication code, please re-enter";
				int legnthUrl = url.length();

				request.setAttribute("Mess", url);
				request.setAttribute("legnthUrl", legnthUrl);
				request.getRequestDispatcher("sms.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("sms.jsp");
		}
	}

	private void forgotPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		// check có email hay không
//		 accD = new accountDao();
		
		usersDAO userD = new usersDAO();
		
		Users user = userD.selectByEmail(email);
		String url = "";
		if (user != null) {
			String otp = SendEmail.send(email);
			System.out.println(otp);
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("otp", otp);

			request.getRequestDispatcher("sms.jsp").forward(request, response);

		} else {
			url = "Email error, please re-enter";
			int lengthUrl = url.length();
			request.setAttribute("email", email);
			request.setAttribute("Mess", url);
			request.setAttribute("lengthUrl", lengthUrl);
			request.getRequestDispatcher("mail.jsp").forward(request, response);
		}
	}

	private void myOder(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			String url = "";
			Users user = new Users();
			if(obj!= null) {
				user = (Users)obj;
			}
			if(user==null) {
				url= "/login.jsp";
			}else {
				orderDAO orderD = new orderDAO();
				ArrayList<Order> orderList = orderD.selectAllOrderByUser(user);
				request.setAttribute("orderList", orderList);
				orderDetailDAO orderDatailD = new orderDetailDAO();
				int i=0;
				for(Order order : orderList) {
					i++;
					ArrayList<Order_detail> orderDetail =  orderDatailD.selectOrderDetailByOrder(order.getOrderId());
					request.setAttribute("orderDetail"+i, orderDetail);
					System.out.println(i + " " +orderDetail);
				}
				request.setAttribute("orderList", orderList);
				url ="/myOrder.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			password = encode.toSHA1(password);
			String url ="";
			usersDAO userD = new usersDAO();
			Users user = new Users();
			user.setUserName(userName);
			user.setPassword(password);
			user = userD.selectByUsernameAndPassword(user);
			if(user!= null){
				HttpSession session = request.getSession();
				if(user.getRole()==1) {
					url ="/index.jsp";
					session.setAttribute("user", user);
					cart_detailDAO cartDetailD = new cart_detailDAO();
					ArrayList<Cart_detail> cartList = new ArrayList<>();
					cartList = cartDetailD.selectCartDetailByUser(user.getUserId());
					session.setAttribute("cart-list", cartList);
				}else {
					session.setAttribute("admin", user);
					url ="/Admin/index.jsp";
				}
			}else {
				request.setAttribute("error", "tên đăng nhâp hoặc mât khẩu không chính xác");
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullName = request.getParameter("fullName");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String encodePassword = encode.toSHA1(password);
			String conPassword = request.getParameter("conPassword");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String email = request.getParameter("email");
			String receiveEmail = request.getParameter("receiveEmail");
			
			request.setAttribute("fullName", fullName);
			request.setAttribute("userName", userName);
			request.setAttribute("sex", sex);
			request.setAttribute("address", address);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("email", email);
			request.setAttribute("receiveEmail", receiveEmail);
			
			String url ="";
			String error ="";
			
			usersDAO userD = new usersDAO();
			Users user = new Users();
			user.setUserName(userName);
			if(userD.selectByUserName(user)!=null) {
				error="ten dang nhap da ton tai";
			}else if(!password.endsWith(conPassword)){
				error +="mat khau nhap lai khong dung";
			}
			request.setAttribute("error", error);
			if(error.length()>0) {
				url = "/register.jsp";
			}else {
				String userId = UUID.randomUUID().toString()+System.currentTimeMillis();
				int role = 1;
				Users newUser = new Users(userId, fullName, userName, encodePassword, sex, address, deliveryAddress, Date.valueOf(dateOfBirth), email, receiveEmail!=null,role);
				if(userD.selectByEmail(email)==null) {
					userD.insert(newUser);					
					url ="/index.jsp";
				}else {
					url ="/register.jsp";
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullName = request.getParameter("fullName");
			String userName = request.getParameter("userName");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String email = request.getParameter("email");
			String receiveEmail = request.getParameter("receiveEmail");
			
			request.setAttribute("fullName", fullName);
			request.setAttribute("userName", userName);
			request.setAttribute("sex", sex);
			request.setAttribute("address", address);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("email", email);
			request.setAttribute("receiveEmail", receiveEmail);
			
			String url ="";
			String error ="";
			
			Object obj = request.getSession().getAttribute("user");
			if(obj!=null) {
				Users user = (Users)obj;
				usersDAO userD = new usersDAO();
				String userId = user.getUserId();
				Users newUser = new Users(userId, fullName, null, null, sex, address, deliveryAddress, Date.valueOf(dateOfBirth), email, receiveEmail!=null,1);
				userD.updateInfo(newUser);
				Users userUpdate = userD.selectById(newUser);
				request.getSession().setAttribute("user", userUpdate);
				url ="/index.jsp";
			}else {
				url ="/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			String conPassword = request.getParameter("conPassword");
			String url = "";
			String error = "";
			usersDAO userD = new usersDAO();
			Users user = null;
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj!= null) {
				user = (Users)obj;
			}
			if(user==null) {
				url= "/login.jsp";
			}else {
				if(!encode.toSHA1(currentPassword).equals(user.getPassword())) {
					error ="Current password is incorrect";
					url="/changePassword.jsp";
				}else {
					if(!newPassword.equals(conPassword)) {
						error ="Con-password is incorrect";
						url="/changePassword.jsp";
					}else {
						newPassword = encode.toSHA1(newPassword);
						user.setPassword(newPassword);
						userD.changePassword(user);
						session.invalidate();
						url = "/index.jsp";
					}
				}
			}
			request.setAttribute("error", error);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
