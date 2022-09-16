package Calc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/Calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String input = request.getParameter("input").replaceAll(" ", "");
		
		int count = 0;
		String[] acptdSym = {"+", "-", "*", "/"};
		String[] acptdNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		int oper = 0;
		for(String e:input.split("")) {
			if(Arrays.asList(acptdSym).indexOf(e) != -1) {
				oper = Arrays.asList(acptdSym).indexOf(e);
				count++;
			}
		}
		if (count != 1) {
			out.write("연산자가 너무 많거나 너무 적습니다! 연산자는 1개여야 합니다<br>");
			return;
		}
		
		String isOther = input.replaceAll("["+acptdSym[oper]+"]", "");
		for(String e:acptdNum)
			isOther = isOther.replaceAll(e, "");
		if (isOther.length() != 0) {
			out.write("허용되지 않은 문자, 또는 숫자가 들어가 있습니다!<br>");
			return;
		}
		
		out.write("당신은 정직하군요!<br>");
		
		long returnVal = 0;
		Calc cl = new Calc();
		int[] nums = {Integer.parseInt(input.split("["+acptdSym[oper]+"]")[0]), Integer.parseInt(input.split("["+acptdSym[oper]+"]")[1])}; 
		switch (oper) {
			case 0: 
				returnVal = cl.add(nums[0], nums[1]);
				break;
			case 1: 
				returnVal = cl.sub(nums[0], nums[1]);
				break;
			case 2: 
				returnVal = cl.mul(nums[0], nums[1]);
				break;
			case 3: 
				try {
					returnVal = cl.div(nums[0], nums[1]);
				} catch (ArithmeticException e) {
					out.write("<br>오류가 발생하였습니다! 0으로는 나눌 수 없습니다!");
					return;
				}
				break;
		}
		out.write(input+"의 결과는<br>");
		out.write(returnVal+"입니다");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
