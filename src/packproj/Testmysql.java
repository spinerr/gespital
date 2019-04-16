package packproj;

import java.sql.*;
import java.util.Properties;

public class Testmysql {
	Connection conn;
	
	public Connection sqlconnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hopital?autoReconnect=true&useSSL=false","root","toor");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
}

