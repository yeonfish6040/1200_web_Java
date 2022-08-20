package Java_class_016;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.ResultSet;

public class DB_Connect {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mariadb://127.0.0.1:3307/java",
					"root", "root"
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (conn != null) {
			System.out.println("DB Connect Success.");
		}else {
			System.out.println("Failed to connect DB");
		}
		
		MemberVO vo = new MemberVO();
		vo.Idx = 3;
		vo.id = "kkk1234";
		vo.name = "Abdula";
		vo.pw = "pw";
		String sql = "INSERT INTO member VALUES("+vo.Idx+", '"+vo.id+"', '"+vo.name+"', '"+vo.pw+"')";
		System.out.println(sql);
		
		Statement stmt = null;
		ResultSet rs = null;
		
//		try {
//			stmt = conn.createStatement();
//			System.out.println(stmt.executeUpdate(sql));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		sql = "SELECT * FROM member WHERE Idx = 2";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				vo.Idx = rs.getInt("Idx");
				vo.id = rs.getString("Id");
				vo.name = rs.getString("name");
				vo.pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(vo.Idx);
		System.out.println(vo.id);
		System.out.println(vo.name);
		System.out.println(vo.pw);
	}
}

class MemberVO {
	int Idx;
	String id;
	String name;
	String pw;
}