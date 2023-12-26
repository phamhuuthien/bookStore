package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.JDBCUtil;
import model.Author;
import model.Books;
import model.Category;

public class BookDAO implements DAOInterface<Books>{

	@Override
	public ArrayList<Books> selectAll() {
		ArrayList books = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "call allBooks";
			PreparedStatement st = con.prepareStatement(sql); 
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				books.add(book);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public ArrayList<Books> selectSearch(String nameSearch) {
		ArrayList books = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM books where title like ?" ;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + nameSearch + "%");
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				books.add(book);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	public ArrayList<Books> selectAllBestSeller() {
		ArrayList books = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM books where available <=2 ";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				books.add(book);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public ArrayList<Books> selectAllFavourite() {
		ArrayList books = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM books where star > 4 ";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				books.add(book);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	public ArrayList<Books> selectCategory(String categoryCode) {
		ArrayList books = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM books where code = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, categoryCode);
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				books.add(book);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public int getTotalBooks() {
		
		int count ;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT count(*) FROM books";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public List<Books> getRecords(int start, int total,String categoryCode){
		List<Books> list=new ArrayList<Books>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from books where code = ? limit "+(start-1)+","+total;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, categoryCode);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				Books book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				list.add(book);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Books selectById(Books t) {
		Books book = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Books where idBook=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getIdBook());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String idBook = rs.getString("idBook");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				
				Author author = new authorDAO().selectById(new Author(authorId, null, null, null));
				
				String publicYear = rs.getString("publicYear");
				Double price = rs.getDouble("price");
				int available = rs.getInt("available");
				String description = rs.getString("description");
				String code = rs.getString("code");
				
				Category category = new categoryDAO().selectById(new Category(code,null));
				
				String fileName = rs.getString("fileName");
				Double star = rs.getDouble("star");
				book = new Books(idBook, title, author, publicYear, price, available, description, category, fileName, star);
				return book;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(Books t) {
		int ketqua = 0 ;
		Books kiemtra = new Books();
		kiemtra.setIdBook(t.getIdBook());
		if(this.selectById(kiemtra)==null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into Books(idBook,title,authorId,publicYear,price,available,description,code,filename,star) values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getIdBook());
				st.setString(2,t.getTitle());
				st.setString(3,t.getAuthor().getAuthorId());
				st.setString(4,t.getPublicYear());
				st.setDouble(5, t.getPrice());
				st.setInt(6,t.getAvailable());
				st.setString(7,t.getDescription());
				st.setString(8,t.getCategory().getCode());
				st.setString(9,t.getFileName());
				st.setDouble(10,t.getStar());
				ketqua = st.executeUpdate();
				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ketqua;
	}

	@Override
	public int insertAll(ArrayList<Books> arr) {
		int ketqua =0;
		for(Books book : arr) {
			ketqua+= this.insert(book);
		}
		return ketqua;
	}

	@Override
	public int delete(Books t) {
		int result =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from Books where idBook = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getIdBook());
			result =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Books> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Books t) {
		int result =0;
		Books kiemtra = new Books();
		kiemtra.setIdBook(t.getIdBook());
		if(this.selectById(kiemtra) !=null) {
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();
				
				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE books "+
						 " SET " +
						 " title=?"+
						 ", authorID=?"+
						 ", publicYear=?"+
						 ", price=?"+
						 ", available=?"+
						 ", description=?"+
						 ", code=?"+
						 ", fileName=?"+
						 ", star=?"+
						 " WHERE idBook=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getTitle());
				st.setString(2,t.getAuthor().getAuthorId());
				st.setString(3,t.getPublicYear());
				st.setDouble(4, t.getPrice());
				st.setInt(5,t.getAvailable());
				st.setString(6,t.getDescription());
				st.setString(7,t.getCategory().getCode());
				st.setString(8,t.getFileName());
				st.setDouble(9,t.getStar());
				st.setString(10,t.getIdBook());
				result = st.executeUpdate();
				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		BookDAO d = new BookDAO();
////		Books book = new Books("2","sdsd","1","2313",2,2,"dsad","RT6","dsd",2);
////		book.setIdBook("a22124811bfa8350");
//		Author author = new Author();
//		author.setAuthorId("1");
//		Category ct = new Category();
//		ct.setCode("RT6");
////		System.out.println(d.update(new Books("2","sdsd",author,"2313",2.0,2,"dsad",ct,"dsd",2.0)));
//		System.out.println(d.selectSearch("Critique"));
		
		Books book = new Books(null, null, null, null, null, 0, null, null, null, null);
		System.out.println(book.getFileName());
	}
}
