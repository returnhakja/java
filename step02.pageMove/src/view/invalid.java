package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/invalid")
public class invalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public invalid() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<div>아이디 또는 비밀번호가 틀립니다</div>");
//		out.close();
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div>아이디 또는 비밀번호가 틀립니다</div>");
		out.close();
	}

}
