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

@WebServlet("/dept")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gg");
		try {
			ArrayList<DeptDTO> AllDept = deptDAO.getAllDept();
			for (DeptDTO deptDTO : AllDept) {
				System.out.println(deptDTO);
			}
			if(AllDept != null) {
				request.setAttribute("AllDept", AllDept);
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("failview.jsp");
		}
		
	}

}
