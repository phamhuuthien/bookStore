package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.JDBCUtil;
import model.pay;

public class payDAO implements DAOInterface<pay>{

	@Override
	public ArrayList<pay> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public pay selectById(pay t) {
		pay pay = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM pay where payId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,t.getPayId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String payId = rs.getString("payId");
				String payMethods = rs.getString("payMethods");
				pay = new pay(payId,payMethods);
				return pay;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(pay t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<pay> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(pay t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<pay> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(pay t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String[] args) {
		payDAO d = new payDAO();
		System.out.println(d.selectById(new pay("1",null)));
	}
}
