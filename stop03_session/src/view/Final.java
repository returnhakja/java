package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Final() {
        super();
    }

    // Client에 있는 Cookie 정보 획득 - 해당 서비스에서 발생시킨 쿠키 정보에 한해서만 획득
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// myId, myAge, myName 으로 지정되어 있는 모든 쿠키 출력
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		Cookie[] cookies =  request.getCookies();
		
		PrintWriter out = response.getWriter();

		
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				out.println(cookies[i].getName());
				  out.println(cookies[i].getValue() + "<br>");
//				  out.close();
			}
		
		}
		
		//myName만 삭제?
		Cookie Delectookie = new Cookie("myName", "0"); 
		Delectookie.setMaxAge(0);
		response.addCookie(Delectookie);
		out.println("정상 삭제");
		
	}

}
