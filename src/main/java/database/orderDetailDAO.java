package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Books;
import model.Cart;
import model.Cart_detail;
import model.Category;
import model.Order;
import model.Order_detail;
import model.Users;
import model.pay;

public class orderDetailDAO implements DAOInterface<Order_detail>{

	@Override
	public ArrayList<Order_detail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order_detail selectById(Order_detail t) {
		Order_detail Order_detail = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM order_detail where order_detailId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getOrder_detailId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String order_detailId = rs.getString("order_detailId");
				String idBook = rs.getString("idBook");
				BookDAO bookD = new BookDAO();
				Books bookSearch = new Books();
				bookSearch.setIdBook(idBook);
				Books book = bookD.selectById(bookSearch);
				String orderId = rs.getString("orderId");
				orderDAO orderD = new orderDAO();
				Order orderSearch = new Order();
				orderSearch.setOrderId(orderId);
				Order order = orderD.selectById(orderSearch);
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				double discount = rs.getDouble("discount");
				double totalPrice = rs.getDouble("totalPrice");
				Order_detail = new Order_detail(order_detailId, book, order, quantity, price, discount, totalPrice);
				return Order_detail;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<Order_detail> selectOrderDetailByOrder(String orderId) {
		ArrayList<Order_detail> orderDetailsByOrder = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from order_detail\r\n"
					+ "inner join orders on order_detail.orderid = orders.orderid\r\n"
					+ "inner join books on order_detail.idBook = books.idBook\r\n"
					+ "where orders.orderId =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,orderId);
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String order_detailId = rs.getString("order_detailId");
				String idBook = rs.getString("idBook");
				Books bookSearch = new Books();
				bookSearch.setIdBook(idBook);
				BookDAO bookD = new BookDAO();
				Books book = bookD.selectById(bookSearch);
				String orderId1 = rs.getString("orderId");
				Order order = new Order();
				order.setOrderId(orderId1);
				
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				double discount = rs.getDouble("discount");
				double totalPrice = rs.getDouble("totalPrice");
				
				Order_detail orderDetail = new Order_detail(order_detailId, book, order, quantity, price, discount, totalPrice);
				orderDetailsByOrder.add(orderDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderDetailsByOrder;
	}
	
	
	public int countOrderDetailByCategory(Category category) {
		int result=0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "select count(*) as result from order_detail \r\n"
					+ "join books on books.idBook=order_detail.idBook\r\n"
					+ "join orders on order_detail.orderId = orders.orderId\r\n"
					+ "where books.code = ? and orders.orderStatus =\"completed\"";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,category.getCode());
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				result = rs.getInt("result");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int countOrdeDretailByAllCategory() {
		int result=0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "select count(*) as result from order_detail \r\n"
					+ "join books on books.idBook=order_detail.idBook\r\n";
			PreparedStatement st = con.prepareStatement(sql);
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				result = rs.getInt("result");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int insert(Order_detail t) {
		int ketqua =0;
		Order_detail kiemtra = new Order_detail();
		kiemtra.setOrder_detailId(t.getOrder_detailId());
		if(this.selectById(kiemtra)== null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into Order_detail(order_detailId,idBook,orderId,quantity, price, discount, totalPrice) values(?,?,?,?,?,null,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, t.getOrder_detailId());
				st.setString(2,t.getBook().getIdBook());
				st.setString(3,t.getOrder().getOrderId());
				st.setDouble(4,t.getQuality());
				st.setDouble(5, t.getPrice());
//				st.setDouble(6, t.getDiscount());
				st.setDouble(6, t.getTotalPrice());
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
	public int insertAll(ArrayList<Order_detail> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	@Override
	public int delete(Order_detail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteOrderId(String orderId) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from order_detail where orderId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,orderId);
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	@Override
	public int deleteAll(ArrayList<Order_detail> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Order_detail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		orderDetailDAO d = new orderDetailDAO();
//		System.out.println(d.selectOrderDetailByUser("15f19f01-72ed-4ef5-8eee-f4764a009cdd1700923271476"));
		
		Category category = new Category("LC8", null);
		
		System.out.println((10/19)*100);
		
	}
}
