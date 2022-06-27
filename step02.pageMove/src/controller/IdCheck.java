package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IdCheck() {
        // TODO Auto-generated constructor stub
    }
    // id값이 busan이라고 한다면 -> /valid 매핑 되어있는 servlet 화면 이동
    // 아니면 다른곳으로 ㅂㅂ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("uname");
		String psw = request.getParameter("psw");
//		out.print("아이디: " + id + "<br/>");
//		out.print("비밀번호: " + psw + "<br/>");
//		out.close();
		
		if("busan".equals(id)) {
			// /valid 매핑 되어 있는 servlet이동
			//첫번째
//			response.sendRedirect("valid"); //valid로 보냄
			request.getRequestDispatcher("valid").forward(request, response);
		}else {
//			request.getRequestDispatcher("invalid").forward(request, response);
			response.sendRedirect("invalid");
		}
//forward 방식은 url변동 X
//redirect 방식은 url변동 O
	}

}
