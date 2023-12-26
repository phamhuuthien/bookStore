package adminController;

import java.io.IOException;
import java.util.UUID;

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
 * Servlet implementation class bookController
 */
@WebServlet("/admin/book")
public class bookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("allBook")) {
			allBook(request,response);
		}else if (action.equals("insertBook")) {
			insertBook(request, response);
		}else if (action.equals("updateOrDelete")) {
			updateOrDelete(request, response);
		}else if (action.equals("updateBook")) {
			updateBook(request, response);
		}
	}

	private void updateOrDelete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idBook = request.getParameter("idBook");
			String status = request.getParameter("status");
			String url ="";
			BookDAO bookD = new BookDAO();
			authorDAO authorD = new authorDAO();
			categoryDAO categoryD = new categoryDAO();
			Books book = new Books();
			book.setIdBook(idBook);
			if(status.equals("update")) {
				request.setAttribute("book", bookD.selectById(book));
				request.setAttribute("listAuthor", authorD.selectAll());
				request.setAttribute("listCategory", categoryD.selectAll());
				url = "/Admin/updateBook.jsp";
			}
			if(status.equals("delete")) {
				deleteBook(request, response, idBook);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	private void allBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			BookDAO bookD = new BookDAO();
			request.setAttribute("listBook", bookD.selectAll());
			String url = "/Admin/allBook.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idBook = request.getParameter("idBook");
			String url = "";
			HttpSession session = request.getSession();
			Books bookSearch = new Books();
			BookDAO bookD = new BookDAO();
			bookSearch.setIdBook(idBook);
			Books book = bookD.selectById(bookSearch);
			String title = request.getParameter("title");
			String authorName = request.getParameter("authorId");
			authorDAO authorD = new authorDAO();
			Author authorSearch = new Author();
			authorSearch.setAuthorName(authorName);
			Author author = authorD.selectByName(authorSearch);
			
			String publicYear = request.getParameter("publicYear");
			double price = Double.parseDouble(request.getParameter("price"));
			int available = Integer.parseInt(request.getParameter("available"));
			
			categoryDAO categoryD = new categoryDAO();
			String categoryName = request.getParameter("code");
			Category categorySearch = new Category();
			categorySearch.setTitleCategory(categoryName);
			Category category = categoryD.selectByTitleCategory(categorySearch);
			String description = request.getParameter("description");
			String fileName = request.getParameter("fileName");
			double star = Double.parseDouble(request.getParameter("star"));
			Books bookNew = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
			bookD.update(bookNew);
			request.setAttribute("book", bookD.selectById(bookSearch));
			request.setAttribute("listAuthor", authorD.selectAll());
			request.setAttribute("listCategory", categoryD.selectAll());
			url = "/Admin/updateBook.jsp";
		    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void deleteBook(HttpServletRequest request, HttpServletResponse response,String idBook) throws ServletException, IOException {
		String url = "";
		Books book = new Books();
		book.setIdBook(idBook);
		BookDAO bookD = new BookDAO();
		bookD.delete(book);
		allBook(request, response);
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String authorId = request.getParameter("authorId");
		String publicYear = request.getParameter("publicYear");
		double price = Double.parseDouble(request.getParameter("price"));
		int available = Integer.parseInt(request.getParameter("available"));
		String description = request.getParameter("description");
		String code = request.getParameter("code");
		String fileName = request.getParameter("fileName");
		double star = 0;
		String idBook = UUID.randomUUID().toString();
		String url="";
		
		BookDAO bookD = new BookDAO();
		Author author = new Author();
		author.setAuthorId(authorId);
		
		Category category = new Category();
		category.setCode(code);
		
		Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
		int check = bookD.insert(book);
		
		request.setAttribute("book", bookD.selectById(book));
		authorDAO authorD = new authorDAO();
		categoryDAO categoryD = new categoryDAO();
		request.setAttribute("listAuthor", authorD.selectAll());
		request.setAttribute("listCategory", categoryD.selectAll());
		if(check==1) {
			url = "/Admin/insertBook.jsp";
		}else {
			System.out.println("thất bại");
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

}
