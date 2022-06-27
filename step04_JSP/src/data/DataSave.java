package data;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class DataSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DataSave() {
    	super();
    }
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cookie 생성 -> jsp02_EL.jsp 전달
		Cookie cookie1 = new Cookie("home1", "data");
		cookie1.setMaxAge(60*60*24);
		response.addCookie(cookie1);
		
		
		response.sendRedirect("jsp02_EL.jsp");
					
		
	}

}
