package Java_class_17;

import java.sql.*;
import java.util.ArrayList;

public class MemberBean {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public MemberBean() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/java", "root", "root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (conn != null) {
			System.out.println("DB connected");
		}
	}
}
