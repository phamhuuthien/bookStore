package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Author;
import model.Category;

public class categoryDAO implements DAOInterface<Category>{

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList result = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String code = rs.getString("code");
				String titleCategory = rs.getString("titleCategory");
				String description = rs.getString("description");
				Category category = new Category(code,titleCategory,description);
				result.add(category);
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
	public Category selectById(Category t) {
		Category category = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category where code=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCode());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String code = rs.getString("code");
				String titleCategory = rs.getString("titleCategory");
				String description  = rs.getString("description");
				category = new Category(code,titleCategory,description);
				return category;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Category selectByTitleCategory(Category t) {
		Category category = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category where titleCategory=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getTitleCategory());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String code = rs.getString("code");
				String titleCategory = rs.getString("titleCategory");
				category = new Category(code,titleCategory);
				return category;
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
	public int insert(Category t) {
		int ketqua =0;
		Category kiemtra = new Category();
		kiemtra.setCode(t.getCode());
		if(this.selectById(kiemtra)== null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into category(code,titleCategory,description) values(?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getCode());
				st.setString(2,t.getTitleCategory());
				st.setString(3,t.getDescription());
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
	public int insertAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from category where code = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCode());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int deleteAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category t) {
		int result =0;
		Category kiemtra = new Category();
		kiemtra.setCode(t.getCode());
		if(this.selectById(kiemtra) !=null) {
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();
				
				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE category "+
						 " SET " +
						 " titleCategory=?"+
						 ", description=?"+
						 " WHERE code=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getTitleCategory());
				st.setString(2, t.getDescription());
				st.setString(3, t.getCode());
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
		categoryDAO d = new categoryDAO();
		Category ct = new Category(null,"Travel");
		System.out.println(d.selectAll());
	}
}
