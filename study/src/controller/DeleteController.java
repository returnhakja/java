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

@WebServlet("/delete")

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("deptno"));  
//		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
	
//		int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
//		boolean delete = deptDAO.delete(deptno);
//			
//		if(delete == true)
//		{
////			System.out.println("되는건가");
//			response.sendRedirect("delete.jsp");
//		}		
//		else {
//			System.out.println("안되는건가");
//			response.sendRedirect("failview.jsp");
//		}
//	}
		
		try {
			int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
			boolean delete = deptDAO.delete(deptno);
			ArrayList<DeptDTO> AllDept = deptDAO.getAllDept();
			
			if(delete == true) {
				request.setAttribute("AllDept", AllDept);
				request.getRequestDispatcher("delete.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("failview.jsp");
		}
		
		
	}

}
