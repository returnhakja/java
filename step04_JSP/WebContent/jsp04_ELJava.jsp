<%@page import="model.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp04_ELJava.jsp</title>
</head>
<body>
	<h3>String 데이터 출력</h3>
	<%
		session.setAttribute("sessionData", "hi");
		request.setAttribute("requestData", "hello");	
	%>
	<!-- 출력을 하려면 sessionScope 사용 -->
	${sessionScope.sessionData} <br/>
	${requestScope.requestData}
	
	<h3>DTO 데이터 출력</h3>
	<%
	
		Student student1 = new Student("이름임", 20);
		Student student2 = new Student("김도헌", 26);
		session.setAttribute("yj", student1);
		session.setAttribute("dh", student2);
	%>
	${sessionScope.yj.name} <br/>
	${sessionScope.dh.name} 
	
	<h3>ArrayList 데이터 출력</h3>
	
	<%
		ArrayList arr = new ArrayList();
		arr.add(student1);
		arr.add(student2);
		
		
		session.setAttribute("arr", arr);
	%>
	${sessionScope.arr[1].age}	
	
 
</body>
</html>