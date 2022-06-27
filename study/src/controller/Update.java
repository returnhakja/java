package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.deptDAO;
import model.dto.DeptDTO;

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter("loc");
		System.out.println(request.getParameter("loc"));
//		String loc = request.getParameter("loc");
//		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
//		int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
//		String loc1 = request.getParameter("inputloc");
//		boolean update = deptDAO.getupdate(loc1, deptno);
		
//		if(update == true ) {
//			System.out.println("ㅅㅈ");
//			response.sendRedirect("update.jsp");	
			
//		}else {
//			System.out.println("ㅅㅁ");
//			response.sendRedirect("failview.jsp");
//		}
		try {
			int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
			String loc1 = request.getParameter("inputloc");
			boolean update = deptDAO.getupdate(loc1, deptno);
			
			ArrayList<DeptDTO> AllDept = deptDAO.getAllDept();
			if(update == true) {
				request.setAttribute("AllDept", AllDept);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failview.jsp");
		}
		
	}

}
