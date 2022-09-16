package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.lang.StringBuffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyUtil.sql.sqlQuery;
import MyUtil.sql.sqlResults;

/**
 * Servlet implementation class mapUtil
 */
@WebServlet("/MapUtil")
public class MapUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapUtil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.write("ERR_WRONG_METHOD");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		sqlQuery sq = new sqlQuery("localhost", "3307", "java", "java", "java");
		
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		
		String sql = "";
		switch (type) {
			case "getLocation":
				sql = "SELECT * FROM location limit 1000";
				break;
			case "login":
				sql = "SELECT * FROM users where id like '"+request.getParameter("id")+"' and pw like '"+request.getParameter("pw")+"'";
		}
		sqlResults result;
		try {
			result = sq.query(sql);
			String[][] raw = result.get();
			StringBuffer resultStr = new StringBuffer();
			resultStr.append("{");
			for(int i=1;i<result.getRowCount();i++) {
				for(int j=0;j<result.getColCount();j++) {
					resultStr.append("\""+raw[0][j]+"\": "+raw[i][j]+",");
				}
			}
			resultStr.append("}");
			out.print(resultStr.toString());
		} catch (Exception e) {
			out.print(e.getLocalizedMessage());
		}
	}
	

}
