package adminController;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.authorDAO;
import database.categoryDAO;
import model.Author;
import model.Category;

/**
 * Servlet implementation class categoryController
 */
@WebServlet("/admin/category")
public class categoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("allCategory")) {
			allCategory(request,response);
		}else if (action.equals("insertCategory")) {
			insertCategory(request, response);
		}else if (action.equals("updateOrDelete")) {
			updateOrDelete(request, response);
		}else if (action.equals("updateCategory")) {
			updateCategory(request, response);
		}
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = request.getParameter("code");
			String titleCategory = request.getParameter("titleCategory");
			String description = request.getParameter("description");
			String url = "";
			categoryDAO categoryD = new categoryDAO();
			Category category = new Category(code,titleCategory,description);
			categoryD.update(category);
			request.setAttribute("category", categoryD.selectById(category));
			url = "/Admin/updateCategory.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void updateOrDelete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = request.getParameter("code");
			String status = request.getParameter("status");
			String url ="";
			categoryDAO categoryD = new categoryDAO();
			Category category = new Category();
			category.setCode(code);
			if(status.equals("update")) {
				request.setAttribute("category", categoryD.selectById(category));
				url = "/Admin/updateCategory.jsp";
			}
			if(status.equals("delete")) {
				deleteCategory(request, response, code);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response, String code) {
		categoryDAO categoryD = new categoryDAO();
		Category category = new Category();
		category.setCode(code);
		categoryD.delete(category);
		allCategory(request, response);
	}

	private void insertCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			String code = request.getParameter("code");
			String titleCategory = request.getParameter("titleCategory");
			String description = request.getParameter("description");
			
			String error = "";
			String url = "";
			
			categoryDAO categoryD = new categoryDAO();
			Category category = new Category();
			category.setCode(code);
			if(categoryD.selectById(category)!=null) {
				error = "category exits";
				request.setAttribute("error", error);
			}else {
				Category newCategory = new Category(code, titleCategory,description);
				categoryD.insert(newCategory);
				url ="/Admin/allCategory.jsp";
				request.setAttribute("listCategory", categoryD.selectAll());
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private void allCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			categoryDAO categoryD = new categoryDAO();
			request.setAttribute("listCategory", categoryD.selectAll());
			String url = "/Admin/allCategory.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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

}
