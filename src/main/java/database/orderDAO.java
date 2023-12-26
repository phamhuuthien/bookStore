package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Author;
import model.Order;
import model.pay;
import model.Users;

public class orderDAO implements DAOInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			 
			// Bước 4:
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				Order order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress);
				result.add(order);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Order> selectAllStatusPending() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orders where orderStatus = 'Pending' ";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			 
			// Bước 4:
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				Double total = rs.getDouble("total");
				Order order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress,total);
				result.add(order);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Order> selectAllStatusFailed() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orders where orderStatus = 'Failed' ";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			 
			// Bước 4:
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				Double total = rs.getDouble("total");
				Order order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress,total);
				result.add(order);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<Order> selectAllStatusCompleted() {
		ArrayList result = new ArrayList();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orders where orderStatus = 'Completed' ";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			 
			// Bước 4:
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				Double total = rs.getDouble("total");
				Order order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress,total);
				result.add(order);
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
	public Order selectById(Order t) {
		Order order = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM orders where orderId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getOrderId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress);
				return order;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	public double TotalOrderMonth(int month) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select sum(total) as result from orders where month(orderDate) = ? and orderStatus = 'Completed'";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,month);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				return rs.getDouble("result");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public Order selectByUser(Users t) {
		Order order = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM orders where userId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getUserId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress);
				return order;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public ArrayList<Order> selectAllOrderByUser(Users t) {
		ArrayList result = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM orders where userId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getUserId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String orderId = rs.getString("orderId");
				String userId = rs.getString("userId");
				usersDAO userD = new usersDAO();
				Users userSearch = new Users();
				userSearch.setUserId(userId);
				Users user = userD.selectById(userSearch);
				String payId = rs.getString("payId");
				payDAO payD = new payDAO();
				pay paySearch = new pay();
				paySearch.setPayId(payId);
				pay pay = payD.selectById(paySearch);
				Date orderDate = rs.getDate("orderDate");
				String orderStatus = rs.getString("orderStatus");
				Date orderDelivery = rs.getDate("orderDelivery");
				String receivingAddress = rs.getString("receivingAddress");
				Order order = new Order(orderId, user, pay, orderDate, orderStatus, orderDelivery, receivingAddress);
				result.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	@Override
	public int insert(Order t) {
		int ketqua =0;
		Order kiemtra = new Order();
		kiemtra.setOrderId(t.getOrderId());
		if(this.selectById(kiemtra)== null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into orders(orderId, userId, payId, orderDate, orderStatus, orderDelivery, receivingAddress,total) values(?,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getOrderId());
				st.setString(2,t.getUser().getUserId());
				st.setString(3,t.getPay().getPayId());
				st.setDate(4,t.getOrderDate());
				st.setString(5, t.getOrderStatus());
				st.setDate(6, t.getOrderDelivery());
				st.setString(7, t.getReceivingAddress());
				st.setDouble(8, t.getTotal());
				ketqua =st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ketqua;
	}
	
	public Double totalOrder(Order t) {
		double total = 0;
		Order kiemtra = new Order();
		kiemtra.setOrderId(t.getOrderId());
		if (this.selectById(kiemtra) != null) {
		    try {
		        Connection con = JDBCUtil.getConnection();
		        String sql = "SELECT SUM(totalPrice) AS total FROM order_detail WHERE orderId = ?";
		        PreparedStatement st = con.prepareStatement(sql);
		        st.setString(1, t.getOrderId());
		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		            total = rs.getDouble("total");
		        }
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		return total;
	}
	@Override
	public int insertAll(ArrayList<Order> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Order t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from orders where orderId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getOrderId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int deleteAll(ArrayList<Order> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Order t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updateTotal(double total,String orderId) {
		int kiemtra = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE orders SET total = ? WHERE orderId = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setDouble(1, total);
			st.setString(2, orderId);
			kiemtra = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kiemtra;
	}
	
	
	public int updateApproval(Date orderDelivery, String orderId) {
		int kiemtra = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE orders SET  orderDelivery= ? , orderStatus = 'Approvaled' WHERE orderId = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(1, orderDelivery);
			st.setString(2, orderId);
			kiemtra = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kiemtra;
	}
	
	public int updateFailed(String orderId) {
		int kiemtra = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE orders SET orderStatus = 'Failed' WHERE orderId = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, orderId);
			kiemtra = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kiemtra;
	}
	public static void main(String[] args) {
		
		orderDAO D = new orderDAO();
//		System.out.println(D.insert(new Order("1",new Users("a0e8ab33-4561-42ca-a0b2-4d75467e6b561699344109206", "pham huu thien", "a", "2", null, null, "sdsadsa", null, "hjdasjhdsajhd",false,1),new pay("1",null),null, null, null, null)));
		System.out.println(D.totalOrder(new Order("a7b84295-cbd3-4146-bdf0-477a0b59dd29",new Users("d1642d32-3a61-4c57-847e-d658feb774531702710376115", "pham huu thien", "a", "2", null, null, "sdsadsa", null, "hjdasjhdsajhd",false,1),new pay("1",null),null, null, null, null)));
//		System.out.println(D.TotalOrderMonth(6));
	}
}
