package adminController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.orderDAO;
import database.orderDetailDAO;
import model.Order;
import model.Order_detail;

/**
 * Servlet implementation class adminController
 */
@WebServlet(name = "adminOrderController", urlPatterns = { "/admin/order" })
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
		if(action.equals("orderApproval")) {
			orderApproval(request,response);
		}else if(action.equals("orderApprovalUpdate")) {
			String idOrder = request.getParameter("idOrder");
			orderDAO orderD = new orderDAO();
			Calendar calendar = Calendar.getInstance();
	        Date currentDate = new Date(calendar.getTimeInMillis());

	        // Convert to java.sql.Date
	        java.sql.Date deliveryDate = currentDate;

			orderD.updateApproval(deliveryDate, idOrder);
			
			System.out.println(orderD.updateApproval(deliveryDate, idOrder));
			this.orderApproval(request, response);
		}else if(action.equals("orderFailedUpdate")) {
			String idOrder = request.getParameter("idOrder");
			orderDAO orderD = new orderDAO();
	        
			orderD.updateFailed(idOrder);
			this.orderApproval(request, response);
		}else if(action.equals("orderDelivery")) {
			String status = request.getParameter("status");
			String url ="";
			orderDAO orderD = new orderDAO();
			ArrayList<Order> orderList = new ArrayList<>();
			if(status.equals("failed")) {
				orderList = orderD.selectAllStatusFailed();
			}
			if(status.equals("completed")) {
				orderList = orderD.selectAllStatusCompleted();
			}
			request.setAttribute("orderList", orderList);
			orderDetailDAO orderDatailD = new orderDetailDAO();
			int i=0;
			for(Order order : orderList) {
				i++;
				ArrayList<Order_detail> orderDetail =  orderDatailD.selectOrderDetailByOrder(order.getOrderId());
				request.setAttribute("orderDetail"+i, orderDetail);
			}
			request.setAttribute("orderList", orderList);
			url ="/Admin/statusOrder.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

	
	private void orderApproval(HttpServletRequest request, HttpServletResponse response) {
		try {
			String url ="";
			orderDAO orderD = new orderDAO();
			ArrayList<Order> orderList = orderD.selectAllStatusPending();
			request.setAttribute("orderList", orderList);
			orderDetailDAO orderDatailD = new orderDetailDAO();
			int i=0;
			for(Order order : orderList) {
				i++;
				ArrayList<Order_detail> orderDetail =  orderDatailD.selectOrderDetailByOrder(order.getOrderId());
				request.setAttribute("orderDetail"+i, orderDetail);
			}
			request.setAttribute("orderList", orderList);
			url ="/Admin/approvalOrder.jsp";
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
