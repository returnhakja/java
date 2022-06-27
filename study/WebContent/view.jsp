<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 전체 검색</title>
</head>
<body>
	<%-- ${requestScope.job} --%>
	
	<%-- <c:forEach var="dept" items="${AllDept}">
		${dept}	<br/>
	</c:forEach> --%>


<table id = "arrayList" border="1">
<tr><th>index</th><th>deptno</th><th>dname</th><th>loc</th></tr>
	<c:forEach var="deptList" items="${requestScope.AllDept}" varStatus="LoopStatus" >
		<tr>
		<td>${LoopStatus.count} </td>
		<td>${deptList.deptno}</td>
		<td>${deptList.dname}</td>
		<td>${deptList.loc}</td>
		</tr>
	</c:forEach>
</table>

	<%-- ${requestScope.AllDept} --%>
</body>
</html>