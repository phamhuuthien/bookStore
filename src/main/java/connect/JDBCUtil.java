package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
     public static Connection getConnection()
     {
    	 Connection connect = null ;
    	 try {
			String url  = "jdbc:mysql://localhost:3306/ecommerce_bookStore";
			String user = "root";
			String password = "huuthien@26082003";
			Class.forName("com.mysql.jdbc.Driver");
			connect =  DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 return connect ;
     }
     public static void closeConnection(Connection con)
     {
    	 try {
			if(con!=null)
			{
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     public static void main(String[] args) {
    	 JDBCUtil db =  new JDBCUtil();
		if(db.getConnection()!=null)
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Error");
		}
	}
}
