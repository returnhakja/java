package step02.apply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class idCheck
 */
@WebServlet("/check")
public class idCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idCheck() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("hi");
		System.out.println("doGet()");
		process(request, response);
		
		//step 01
//		//Client가 입력한 데이터를 추출
//		System.out.println(request.getParameter("id"));
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		System.out.println("doPost()");
		process(request, response);
		
		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		
	}
	// 공통된 로직으로 구현되는 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8"); //브라우저마다 기본적으로 문자코드를 해석한 default가 다르기 때문에 씀
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PrintWriter out = response.getWriter(); //결과를 돌려줄건이 받을건지 생각
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("하이 ㅋ " + id);
		out.println("</body>");
		out.println("</html>");
		
	}
}
