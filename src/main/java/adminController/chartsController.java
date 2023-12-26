package adminController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.categoryDAO;
import database.orderDAO;
import database.orderDetailDAO;
import model.Category;

/**
 * Servlet implementation class chartsController
 */
@WebServlet("/admin/charts")
public class chartsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chartsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String url ="";
		if(action.equals("area") || action.equals("bar")) {
			ArrayList<Double> dataArea = new ArrayList<>();
			orderDAO orderD = new orderDAO();
			for (int i=1;i<=12; i++) {
				double result = orderD.TotalOrderMonth(i);
				dataArea.add(result);
			}
			request.setAttribute("dataArea", dataArea);
			
			if(action.equals("area")) {
				url ="/Admin/chartsArea.jsp";
			}
			
			
			if(action.equals("bar")) {
				url ="/Admin/chartsBar.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}else if(action.equals("donut")) {
			categoryDAO categoryD = new categoryDAO();
			ArrayList<Category> categoryList = categoryD.selectAll();
			
			orderDetailDAO orderDetailD = new orderDetailDAO();
			
			
			ArrayList<Double> dataDonut = new ArrayList<>();
			
			int countAllCategory = orderDetailD.countOrdeDretailByAllCategory();
			
			
			for (Category category : categoryList) {
				double item = orderDetailD.countOrderDetailByCategory(category);
				double rs = (item/countAllCategory)*100;
				double result = Math.round(rs*10)/10;
				dataDonut.add(result);
			}
			request.setAttribute("lable", categoryList);
			request.setAttribute("dataDonut", dataDonut);
			url ="/Admin/chartsDonut.jsp";
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
