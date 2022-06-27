package study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String x1 = request.getParameter("x");
		String y1 = request.getParameter("y");
		String btn = request.getParameter("button");
		
		int x = 0;
		int y = 0;
		
		if(!x1.equals("")) x = Integer.parseInt(x1);
		if(!y1.equals("")) y = Integer.parseInt(y1);
		
		int result = 0;
		if(btn.equals("더하기"))
		result = x+y;
		else if(btn.equals("빼기"))
		result = x-y;
		else if(btn.equals("곱하기"))
			result = x*y;
		else
			result = x/y;
		response.getWriter().println("result : " + result);
		
	}

}
