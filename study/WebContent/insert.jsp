<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가 페이지</title>
</head>
<body>
<h3>추가 되었습니다</h3> <br/>
<h3>전체 리스트</h3>

<%-- <c:forEach var="alldata" items="${AllDept}">
		${alldata}	<br/>
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


</body>
</html>