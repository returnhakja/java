package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/invalid")
public class InValidView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InValidView() {
        super();
    }

    //여기서의 로직은 SessionFinal에 있는 로그아웃 버튼을 클릭했을 때 -> 현재의 Servlet에서 세션 무효화시킨다
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("lecture"));
		session.invalidate(); //얘가 세션자체를 없애주는 아이임
		session = null;
//		System.out.println(session.getAttribute("lecture"));
		
		response.sendRedirect("login.html");
		
	}

}
