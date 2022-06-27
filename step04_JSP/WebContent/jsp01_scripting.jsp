<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp01</title>
</head>
<body>
	<!--  HTML주석  -->
	<%-- JSP주석 --%>
	<h2>step01 - scripting</h2>
	<%! String name = "busan"; %>
	<%= name %>
	<% out.println(name); %> <br/>
	
	<% int age = 14; %>
	<%= age %>
	
	
	<%--EL태그 --%>
	<h2>step02 - EL</h2>
	<table border="1">
		<tr>
		<td>2+3</td>
		<td>${2+3}</td>
		</tr>
		
		<tr>
		<td>2>3</td>
		<td>${2>3}</td>
		</tr>
		
		<tr>
		<td>'a' == 'a'</td>
		<td>${'a' == 'a' }</td>
		</tr>
		
		<tr>
		<td>'a'!= 'a'</td>
		<td>${ 'a'!='a'}</td>
		</tr>
	</table>
	
	<% // jsp에서 사용 가능한 데이터 저장
	request.setAttribute("reqData", "요청 객체 데이터");
	
	%>
	${requestScope.reqData} 
	
</body>
</html>