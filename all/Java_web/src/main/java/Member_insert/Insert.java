package Member_insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyUtil.sql.*;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/MemberURL")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("This is unsafe. Use the POST method!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		sqlQuery sq = new sqlQuery("localhost", "3307", "root", "root", "java");
		if(sq.cStatus() != true) {
			System.out.println("err!!");
			out.write("Err!!");
		}else {
			System.out.println("DB connect successful");
		}
		
		String mId = request.getParameter("id");
		String mName = request.getParameter("name");
		
		String table = "member";
		String[][] records = 
			{
				{"id", "name"},
				{mId, mName}
			};
		try {
//			int row = sq.insert(table, records);
//			out.write(row+"건이 적용됨<br>");
			
//			String sql = "select * from member where `Id` like '"+mId+"' and `name` like '"+mName+"'";
			String sql = "select * from member";
			sqlResults re = sq.query(sql);
			out.write(re.getTable(true));
			out.write("<style>.sql_table, .sql_td, .sql_tr { border: 1px double black; }</style>");
			
		} catch (Exception e) {
			out.write(e.getLocalizedMessage());
		}
	}

}
