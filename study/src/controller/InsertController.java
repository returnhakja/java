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

@WebServlet("/insert")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("인서트");
		
//		System.out.println(request.getParameter("dname"));
		try {
//			int deptno = Integer.parseInt(request.getParameter("deptno"));
//			String loc = request.getParameter("loc");
//			String dname = request.getParameter("dname");
			
			int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
			String dname = request.getParameter("inputdname");
			String loc = request.getParameter("inputloc");
			
			boolean insert = deptDAO.add(new DeptDTO(deptno, dname, loc)); //객체생성
			ArrayList<DeptDTO> AllDept = deptDAO.getAllDept();
			System.out.println(insert);
			if(insert == true) {
				
				request.setAttribute("AllDept", AllDept);
				request.getRequestDispatcher("insert.jsp").forward(request, response);

			}else {
				response.sendRedirect("insertfail.jsp");
			}
			
		} catch (Exception e) {
			response.sendRedirect("failview.jsp");
		}
		
		
	}

}
