package step02.apply;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Views/print")
public class Valueprint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Valueprint() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("get");
    	request.setCharacterEncoding("utf-8");
    	System.out.println(request.getQueryString());
    	System.out.println(URLDecoder.decode(request.getQueryString(), "UTF-8"));
    }
    
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8"); //브라우저마다 기본적으로 문자코드를 해석한 default가 다르기 때문에 씀
		
		ServletInputStream input = request.getInputStream();
		System.out.println(input);
		//org.apache.catalina.connector.CoyoteInputStream@2a4ce45a
		int length = request.getContentLength();
		byte[] data = new byte[length];
		input.readLine(data, 0, length); // data를 읽어오는데 0에서부터 length 길이만큼
		//post방식으로 넘어온 request 객체의 body 정보
		String str = new String(data);
		System.out.println(str);
		System.out.println(URLDecoder.decode(str, "UTF-8"));
		
//		String[] values = request.getParameterValues("like");
//		if(values != null) {
//			for(int i=0; i < values.length; i++) 
//			{
////				System.out.println(values[i]);
//				PrintWriter out = response.getWriter();
//				out.println(values[i]);
//			}
//		}
	}

}
