package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDAO;

@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		try {
			String job = EmpDAO.getJob(empno);
			if(job != null) {
				System.out.println(job);
				request.setAttribute("job", job);
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}else {
				request.setAttribute("job", "백수임");
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}
		}catch(SQLException e){
			e.printStackTrace();
			response.sendRedirect("failview.jsp");

			
		}
	}

}
