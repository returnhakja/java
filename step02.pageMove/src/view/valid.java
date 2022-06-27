package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid" )
public class valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public valid() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		out.print("아이디: " + request.getParameter("uname") + "<br/>");
//		out.print("비밀번호: " + psw + "<br/>");
		out.close();
	}

}
