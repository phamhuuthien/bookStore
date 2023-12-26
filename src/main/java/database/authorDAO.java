package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Author;

public class authorDAO implements DAOInterface<Author>{
	private ArrayList<Author> data = new ArrayList<>();
	@Override
	public ArrayList<Author> selectAll() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Author";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			 
			// Bước 4:
			while(rs.next()) {
				String authorId = rs.getString("authorId");
				String authorName = rs.getString("authorName");
				String authorDes = rs.getString("authorDes");
				Date authorDate = rs.getDate("authorDate");
				Author author = new Author(authorId, authorName, authorDes, authorDate);
				result.add(author);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Author selectById(Author t) {
		// TODO Auto-generated method stub
		Author author = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Author where authorId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getAuthorId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String authorId = rs.getString("authorId");
				String authorName = rs.getString("authorName");
				String authorDes = rs.getString("authorDes");
				Date authorDate = rs.getDate("authorDate");
				author = new Author(authorId, authorName, authorDes, authorDate);
				return author;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Author selectByName(Author t) {
		// TODO Auto-generated method stub
		Author author = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Author where authorName=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getAuthorName());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String authorId = rs.getString("authorId");
				String authorName = rs.getString("authorName");
				String authorDes = rs.getString("authorDes");
				Date authorDate = rs.getDate("authorDate");
				author = new Author(authorId, authorName, authorDes, authorDate);
				return author;
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
	public int insert(Author t) {
		int ketqua =0;
		Author kiemtra = new Author();
		kiemtra.setAuthorId(t.getAuthorId());
		if(this.selectById(kiemtra)== null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into Author(authorId,authorName,authorDes,authorDate) values(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getAuthorId());
				st.setString(2,t.getAuthorName());
				st.setString(3,t.getAuthorDes());
				st.setDate(4, t.getAuthorDate());
				ketqua =st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ketqua;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		// TODO Auto-generated method stub
		int dem = 0;
		for(Author author : arr) {
			dem +=this.insert(author);
		}
		return dem;
	}

	@Override
	public int delete(Author t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from author where authorId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getAuthorId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int deleteAll(ArrayList<Author> arr) {
		int dem = 0;
		for(Author author : arr) {
			dem +=this.delete(author);
		}
		return dem;
	}

	@Override
	public int update(Author t) {
		int result =0;
		Author kiemtra = new Author();
		kiemtra.setAuthorId(t.getAuthorId());
		if(this.selectById(kiemtra) !=null) {
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();
				
				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE author "+
						 " SET " +
						 " authorName=?"+
						 ", authorDes=?"+
						 ", authorDate=?"+
						 " WHERE authorId=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getAuthorName());
				st.setString(2, t.getAuthorDes());
				st.setDate(3, t.getAuthorDate());
				st.setString(4, t.getAuthorId());
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
		authorDAO dao = new authorDAO();
		Author author = new Author("1",null,null,null);
		System.out.println(dao.selectAll());
		
	}
}
