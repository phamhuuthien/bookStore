package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BookDAO;
import database.authorDAO;
import database.categoryDAO;
import model.Author;
import model.Books;
import model.Category;

/**
 * Servlet implementation class productsController
 */
@WebServlet("/products")
public class productsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String status = request.getParameter("status");
		String page = request.getParameter("page");
		if (action.equals("test")) {
			String spageid=request.getParameter("page");   
			String code = request.getParameter("code");
	        int pageid=Integer.parseInt(spageid);  
	        int total=6;  
	        if(pageid==1){}  
	        else{  
	            pageid=pageid-1;  
	            pageid=pageid*total+1;  
	        }  
	        BookDAO bookD = new BookDAO();
	        categoryDAO categoryD = new categoryDAO();
	        Category category = new Category();
	        category.setCode(code);
			request.setAttribute("books", bookD.getRecords(pageid,total,code));
			System.out.println(categoryD.selectById(category));
			request.setAttribute("category", categoryD.selectById(category));
			String url = "/Products/allBooks.jsp";
		    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);  
		}
//		new
		else if (action.equals("more")&&status.equals("bestseller")) {
			BookDAO bookD = new BookDAO();
			request.setAttribute("nameStatus", status);
			request.setAttribute("more", bookD.selectAllBestSeller());
			moreSpecial(request, response);
		}else if (action.equals("more")&&status.equals("favourite")) {
			BookDAO bookD = new BookDAO();
			request.setAttribute("nameStatus", status);
			request.setAttribute("more", bookD.selectAllFavourite());
			moreSpecial(request, response);
		}
//		else if (action.equals("more")&&status.equals("category")) {
//			String categoryCode = request.getParameter("code");
//			String categoryName = request.getParameter("categoryName");
//			BookDAO bookD = new BookDAO();
//			request.setAttribute("nameStatus",categoryName);
//			request.setAttribute("more", bookD.selectCategory(categoryCode));
//			more(request, response);
//		}
		else if (action.equals("more")&&status.equals("category")) {
			String spageid= page;   
			String code = request.getParameter("code");
			String categoryName = request.getParameter("categoryName");
	        int pageid=Integer.parseInt(spageid);  
	        int total=8;  
	        if(pageid==1){}  
	        else{  
	            pageid=pageid-1;  
	            pageid=pageid*total+1;  
	        }  
	        BookDAO bookD = new BookDAO();
			request.setAttribute("more", bookD.getRecords(pageid,total,code));
			request.setAttribute("nameStatus",categoryName);
			more(request, response);
		}
		else if(action.equals("search")) {
			String nameSearch = request.getParameter("search");
			BookDAO bookD = new BookDAO();
			request.setAttribute("nameStatus","result Search");
			request.setAttribute("more", bookD.selectSearch(nameSearch));
			moreSpecial(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void more(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/more.jsp";
	    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response); 
	}
	private void moreSpecial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/moreSpecial.jsp";
	    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response); 
	}
	
}
