package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Author;
import model.Cart;
import model.Users;

public class cartDAO implements DAOInterface<Cart> {

	@Override
	public ArrayList<Cart> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart selectById(Cart t) {
		Cart cart = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM cart where cartId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCartId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartId = rs.getString("cartId");
				String userId = rs.getString("userId");
				Users user = new usersDAO().selectById(new Users(userId,null, null,null, null,null, null,null, null,null, 1));
				cart = new Cart(cartId, user);
				return cart;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cart selectByUser(String userId) {
		Cart cart = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM cart where userID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,userId);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartId = rs.getString("cartId");
				Users user = new usersDAO().selectById(new Users(userId,null, null,null, null,null, null,null, null,null, 1));
				cart = new Cart(cartId, user);
				return cart;
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
	public int insert(Cart t) {
		
		int ketqua = 0;
		Cart kiemtra = new Cart();
		kiemtra.setCartId(t.getCartId());
		if(this.selectById(kiemtra)==null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into Cart(cartId,userId) values(?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getCartId());
				st.setString(2, t.getUser().getUserId());
				ketqua = st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Cart> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cart t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from cart where cartId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCartId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int deleteAll(ArrayList<Cart> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cart t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
