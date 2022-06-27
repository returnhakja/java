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
      
      //메소드 정의
      
      /* steo01 : 데이터 획득
       * empno 사번 -> ename 사원의 이름을 반환받으려고 함
       * String ename = EmpDAO.getName(empno);
       * 
       * 
       * steo02 : 페이지 이동(forward , redirect)
       * ename 있다고 한다면? -> view.jsp이름값을 전달 (forward)
       * ename 없다 한다면? -> view.jsp 사원의 이름이 없습니다(문자열 전달) (forward)
       * 만약에 SQLException 발생한다면 ? -> failView.jsp로 이동 (redirect)
       *
       * */
      try {
         String ename = EmpDAO.getName(empno);
         if(ename != null) {
            System.out.println(ename);
            request.setAttribute("ename", ename);
            request.getRequestDispatcher("view.jsp").forward(request,  response);
           
         }else {
            System.out.println("이름이 없음");
            request.setAttribute("ename", "사원의 이름이 없습니다");
            request.getRequestDispatcher("view.jsp").forward(request,  response);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
         response.sendRedirect("failview.jsp");
      }
	  
      
      
      
      
      
   }

}

