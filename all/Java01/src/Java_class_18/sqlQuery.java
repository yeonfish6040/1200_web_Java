package Java_class_18;

import java.util.Iterator;
import java.sql.*;

public class sqlQuery {
	protected Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public sqlQuery(String host, String port, String id, String pw, String database) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://"+host+":"+port+"/"+database+"", id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean cStatus() {
		if (conn != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int insert(String table, String[][] get) throws Exception {
		
		String[] clean = getClean(get);
		
		String col = clean[0];
		String val = clean[1].replaceAll("`", "'");
		
		stmt = conn.createStatement();
		String sql = "INSERT INTO "+table+"("+col+") VALUES("+val+")";
		System.out.println(sql);
		int rows = stmt.executeUpdate(sql);
		return rows;
	}
	
	public int update(String table, String[][] get, int index) throws Exception {
		
		if (get[0].length != get[1].length) throw new Exception("Error! The number of columns does not match the number of values.");
		
		
		String temp = "";
		for(int i=0;i<get[0].length;i++) {
			if (temp == "") {
				temp = get[0][i]+"='"+get[1][i]+"'"; 
			}else {
				temp += ", "+get[0][i]+"='"+get[1][i]+"'";
			}
		}
		
		stmt = conn.createStatement();
		String sql = "UPDATE "+table+" SET "+temp+" WHERE "+get[0][index]+"='"+get[1][index]+"'";
		System.out.println(sql);
		int rows = stmt.executeUpdate(sql);
		return rows;
	}
	
	public int delete(String table, String[] data) throws Exception{
		String sql = "DELETE FROM "+table+" WHERE "+data[0]+"='"+data[1]+"'";
		System.out.println(sql);
		stmt = conn.createStatement();
		int rows = stmt.executeUpdate(sql);
		return rows;
	}
	
	private String[] getClean(String[][] raw) {
		String[] vals = new String[raw.length];
		int i = 0;
		for(String[] raw2:raw) {
			for(String c:raw2) {
				if(vals[i] == null) {
					vals[i] = "`"+c+"`";
				}else {
					vals[i] += ", `"+c+"`";
				}
			}
			i++;
		}
		return vals;
	}
}
