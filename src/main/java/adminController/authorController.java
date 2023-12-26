package adminController;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;
import database.authorDAO;
import model.Author;
import model.Books;

/**
 * Servlet implementation class authorController
 */
@WebServlet("/admin/author")
public class authorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("allAuthor")) {
			allAuthor(request,response);
		}else if (action.equals("insertAuthor")) {
			insertAuthor(request, response);
		}else if (action.equals("updateOrDelete")) {
			updateOrDelete(request, response);
		}else if (action.equals("updateAuthor")) {
			updateAuthor(request, response);
		}
	}

	private void updateAuthor(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idAuthor = request.getParameter("idAuthor");
			String authorName = request.getParameter("authorName");
			String authorDes = request.getParameter("authorDes");
			String authorDate = request.getParameter("authorDate");
			String url = "";
			String error ="";
			authorDAO authorD = new authorDAO();
			Author author = new Author();
			author.setAuthorId(idAuthor);
			Author authorNew = new Author(idAuthor, authorName, authorDes,Date.valueOf(authorDate));
			authorD.update(authorNew);
			request.setAttribute("author", authorD.selectById(author));
			url = "/Admin/updateAuthor.jsp";
		    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private void updateOrDelete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idAuthor = request.getParameter("idAuthor");
			String status = request.getParameter("status");
			String url ="";
			authorDAO authorD = new authorDAO();
			Author author = new Author();
			author.setAuthorId(idAuthor);
			if(status.equals("update")) {
				request.setAttribute("author", authorD.selectById(author));
				url = "/Admin/updateAuthor.jsp";
			}
			if(status.equals("delete")) {
				deleteAuthor(request, response, idAuthor);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	private void deleteAuthor(HttpServletRequest request, HttpServletResponse response, String idAuthor) {
		authorDAO authorD = new authorDAO();
		Author author = new Author();
		author.setAuthorId(idAuthor);
		authorD.delete(author);
		allAuthor(request, response);
	}

	private void insertAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String authorName = request.getParameter("authorName");
		String authorDes = request.getParameter("authorDes");
		String authorDate = request.getParameter("authorDate");
		
		String error = "";
		String url = "";
		
		authorDAO authorD = new authorDAO();
		String authorId = Integer.toString(authorD.selectAll().size()+1);
		Author author = new Author();
		author.setAuthorId(authorId);
		if(authorD.selectById(author)!=null) {
			error = "author exits";
		}else {
			Author newAuthor = new Author(authorId, authorName, authorDes, Date.valueOf(authorDate));
			authorD.insert(newAuthor);
			url ="/Admin/allAuthor.jsp";
			request.setAttribute("listAuthor", authorD.selectAll());
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void allAuthor(HttpServletRequest request, HttpServletResponse response) {
		try {
			authorDAO authorD = new authorDAO();
			request.setAttribute("listAuthor", authorD.selectAll());
			String url = "/Admin/allAuthor.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
