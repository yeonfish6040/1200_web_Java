package day_002;

import MyUtil.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public sqlResults select(String name) {
		sqlQuery sq = new sqlQuery("lyj.kr", "3306", "java", "java", "java");
		Connection conn = sq.getConn();
		sqlResults result = null;
		try {
			result = sq.query("select * from tbl_member where name = '"+name+"'");
			System.out.println(result.get()[0][0]);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
