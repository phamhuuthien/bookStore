package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Author;
import model.Users;

public class usersDAO implements DAOInterface<Users>{

	@Override
	public ArrayList<Users> selectAll() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Users where role!=false";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String userId = rs.getString("userId");
				String fullName = rs.getString("fullName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String email = rs.getString("email");
				Boolean receiveEmail = rs.getBoolean("receiveEmail");
				int role = rs.getInt("role");
				Users user = new Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role);
				result.add(user);
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
	public Users selectById(Users t) {
		Users user = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Users where userId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getUserId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String fullName = rs.getString("fullName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String email = rs.getString("email");
				Boolean receiveEmail = rs.getBoolean("receiveEmail");
				int role = rs.getInt("role");
				user = new Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role);
				return user;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Users selectByEmail(String emailParam) {
		Users user = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Users where email =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,emailParam);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String fullName = rs.getString("fullName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String email = rs.getString("email");
				Boolean receiveEmail = rs.getBoolean("receiveEmail");
				int role = rs.getInt("role");
				user = new Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role);
				return user;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Users selectByUserName(Users t) {
		Users user = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Users where userName=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getUserName());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String fullName = rs.getString("fullName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String email = rs.getString("email");
				Boolean receiveEmail = rs.getBoolean("receiveEmail");
				int role = rs.getInt("role");
				user = new Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role);
				return user;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Users selectByUsernameAndPassword(Users t) {
		Users user = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM Users WHERE userName=? and password=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			st.setString(2, t.getPassword());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String fullName = rs.getString("fullName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String email = rs.getString("email");
				Boolean receiveEmail = rs.getBoolean("receiveEmail");
				int role = rs.getInt("role");
				user = new Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public int insert(Users t) {
		int ketqua =0;
		Users kiemtra = new Users();
		kiemtra.setUserId(t.getUserId());
		kiemtra.setUserName(t.getUserName());
		if(this.selectById(kiemtra)== null && this.selectByUserName(kiemtra)== null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into Users(userId, fullName, userName, password, sex, address, deliveryAddress, dateOfBirth, email, receiveEmail,role) values(?,?,?,?,?,?,?,?,?,?,1)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getUserId());
				st.setString(2,t.getFullName());
				st.setString(3,t.getUserName());
				st.setString(4, t.getPassword());
				st.setString(5, t.getSex());
				st.setString(6, t.getAddress());
				st.setString(7, t.getDeliveryAddress());
				st.setDate(8, t.getDateOfBirth());
				st.setString(9, t.getEmail());
				st.setBoolean(10, t.getReceiveEmail());
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
	public int insertAll(ArrayList<Users> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Users t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from users where userId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getUserId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	
	@Override
	public int deleteAll(ArrayList<Users> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Users t) {
		return 0;
	}
	public int updateInfo(Users t) {
		int ketqua =0;
		Users kiemtra = new Users();
		kiemtra.setUserId(t.getUserId());
		if(this.selectById(kiemtra)!= null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "update Users set fullName = ?, sex=?, address=?, deliveryAddress=?, dateOfBirth=?, email=?, receiveEmail=? where userId =?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getFullName());
				st.setString(2, t.getSex());
				st.setString(3, t.getAddress());
				st.setString(4, t.getDeliveryAddress());
				st.setDate(5, t.getDateOfBirth());
				st.setString(6, t.getEmail());
				st.setBoolean(7, t.getReceiveEmail());
				st.setString(8, t.getUserId());
				ketqua =st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return ketqua;
	}
	public int updateAdminUser(Users t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "update Users set fullName = ?, userName = ?,sex=?, address=? where userId =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getFullName());
			st.setString(2, t.getUserName());
			st.setString(3, t.getSex());
			st.setString(4, t.getAddress());
			st.setString(5, t.getUserId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int changePassword(Users t) {
		int ketqua =0;
		Users kiemtra = new Users();
		kiemtra.setUserId(t.getUserId());
		if(this.selectById(kiemtra)!= null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "update Users set password = ? where userId =?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getPassword());
				st.setString(2,t.getUserId());
				ketqua =st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return ketqua;
	}
	public int changePasswordWhenLogin(String password,String email) {
		int ketqua =0;
		
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "update Users set password = ? where email =?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,password);
				st.setString(2,email);
				ketqua =st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return ketqua;
	}
	public static void main(String[] args) {
		usersDAO d = new usersDAO();
//		System.out.println(d.changePassword(new Users("a0e8ab33-4561-42ca-a0b2-4d75467e6b561699344109206", "pham huu thien", "a", "2", null, null, "sdsadsa", null, "hjdasjhdsajhd",false,1)));
		System.out.println(d.changePasswordWhenLogin("123", "thienlala33@gmail.com"));
	}
}
