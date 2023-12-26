package database;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.Books;
import model.Cart;
import model.Cart_detail;

public class cart_detailDAO implements DAOInterface<Cart_detail> {

	@Override
	public ArrayList<Cart_detail> selectAll() {
		ArrayList<Cart_detail> cartDetails = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM cart_detail";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL 
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartDetailId = rs.getString("cartDetailId");
				String bookId = rs.getString("bookId");
				Books bookSearch = new Books();
				bookSearch.setIdBook(bookId);
				BookDAO bookD = new BookDAO();
				Books book = bookD.selectById(bookSearch);
				String cartId = rs.getString("cartId");
				Cart cart = new Cart();
				cart.setCartId(cartId);
				int quantity = rs.getInt("quantity");
				Cart_detail cartDetail = new Cart_detail(cartDetailId,book,cart,quantity);
				cartDetails.add(cartDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartDetails;
	}

	
	public ArrayList<Cart_detail> selectCartDetailByUser(String userId) {
		ArrayList<Cart_detail> cartDetailsByUser = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from cart_detail\r\n"
					+ "inner join cart on cart_detail.cartid = cart.cartid\r\n"
					+ "inner join books on cart_detail.bookId = books.idBook\r\n"
					+ "where cart.userId =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,userId);
			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartDetailId = rs.getString("cartDetailId");
				String bookId = rs.getString("bookId");
				Books bookSearch = new Books();
				bookSearch.setIdBook(bookId);
				BookDAO bookD = new BookDAO();
				Books book = bookD.selectById(bookSearch);
				String cartId = rs.getString("cartId");
				Cart cart = new Cart();
				cart.setCartId(cartId);
				int quantity = rs.getInt("quantity");
				Cart_detail cartDetail = new Cart_detail(cartDetailId,book,cart,quantity);
				cartDetailsByUser.add(cartDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartDetailsByUser;
	}
	
	
	@Override
	public Cart_detail selectById(Cart_detail t) {
		Cart_detail cartDetail = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from cart_detail where cartDetailId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCartDetailId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartDetailId = rs.getString("cartDetailId");
				String bookId = rs.getString("bookId");
				Books book = new Books();
				book.setIdBook(bookId);
				String cartId = rs.getString("cartId");
				Cart cart = new Cart();
				cart.setCartId(cartId);
				int quantity = rs.getInt("quantity");
				cartDetail = new Cart_detail(cartDetailId,book,cart,quantity);
				return cartDetail;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cart_detail selectByIdBook(String bookIdParam) {
		Cart_detail cartDetail = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from cart_detail where bookId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,bookIdParam);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String cartDetailId = rs.getString("cartDetailId");
				String bookId = rs.getString("bookId");
				Books book = new Books();
				book.setIdBook(bookId);
				String cartId = rs.getString("cartId");
				Cart cart = new Cart();
				cart.setCartId(cartId);
				int quantity = rs.getInt("quantity");
				cartDetail = new Cart_detail(cartDetailId,book,cart,quantity);
				return cartDetail;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int insert(Cart_detail t) {
		int ketqua = 0 ;
		Cart_detail kiemtra= new Cart_detail();
		kiemtra.setCartDetailId(t.getCartDetailId());
		if(this.selectById(kiemtra)==null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "insert into cart_detail(cartDetailId,bookId,cartId,quantity) values (?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,t.getCartDetailId());
				st.setString(2,t.getBooks().getIdBook());
				st.setString(3,t.getCart().getCartId()); 
				st.setInt(4, t.getQuantity());
				ketqua = st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Cart_detail> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cart_detail t) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from cart_detail where cartDetailId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getCartDetailId());
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int deleteCartId(String cartId) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from cart_detail where cartId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,cartId);
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int deleteBookId(String bookId) {
		int ketqua =0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from cart_detail where bookId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,bookId);
			ketqua =st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	@Override
	public int deleteAll(ArrayList<Cart_detail> arr) {
		// TODO Auto-generated method stub
		return 0; 
	}

	@Override
	public int update(Cart_detail t) {
		
		return 0;
	}

	public int updateQuantity(Cart_detail t) {
		int ketqua = 0 ;
		Cart_detail kiemtra= new Cart_detail();
		kiemtra.setCartDetailId(t.getCartDetailId()); 
		if(this.selectById(kiemtra)!=null) {
			try {
				Connection con = JDBCUtil.getConnection();
				String sql = "update cart_detail set quantity = ?  where cartDetailId = ?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, t.getQuantity());
				st.setString(2,t.getCartDetailId());
				ketqua = st.executeUpdate();
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ketqua;
	}
	public static void main(String[] args) {
		cart_detailDAO cartDetailD = new cart_detailDAO();
		System.out.println(cartDetailD.updateQuantity(new Cart_detail("edf4d2c5-25fa-47e3-91fc-d3140aa4e7f4",null, null,1)));
	}
}
