package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.deptDAO;
import model.dto.DeptDTO;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
//		String deptno = request.getParameter("inputDeptno");
//		System.out.println(deptno);
//		System.out.println(request.getParameter("inputdeptno"));
		
		try {
			DeptDTO deptname = deptDAO.searchAllList(deptno); 
			if(deptname != null) {
				request.setAttribute("dept", deptname);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}else {
//				System.out.println("�옒紐삳맂 遺��꽌 寃��깋");
				request.getRequestDispatcher("failview.jsp").forward(request, response);
			}
		
		}catch (SQLException e) {
	         e.printStackTrace();
	         response.sendRedirect("failview.jsp");
	      }
	}
}
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int deptno = Integer.parseInt(request.getParameter("inputdeptno"));
//		
//		System.out.println(request.getParameter("inputdeptno"));
//		
//		
//		try {
//			DeptDTO deptname = deptDAO.searchAllList(deptno); 
//			if(deptname != null) {
//				request.setAttribute("dept", deptname);
//				request.getRequestDispatcher("search.jsp").forward(request, response);
//			}else {
//				System.out.println("�옒紐삳맂 遺��꽌 寃��깋");
//				request.getRequestDispatcher("failview.jsp").forward(request, response);
//			}
//		
//		}catch (SQLException e) {
//	         e.printStackTrace();
//	         response.sendRedirect("failview.jsp");
//	      }
//	}
//   }
	
//}


