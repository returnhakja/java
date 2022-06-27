<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	직업 조회<button onclick="location.href='emp?empno=7369'">조회</button><br/>
	수정<button onclick="location.href='update?loc=bsan&deptno=10'"> 확인 </button><br/>
	삭제<button onclick="location.href='delete?deptno=10'">확인</button><br/>
	추가<button onclick="location.href='insert?loc=maple&deptno=10&dname=onegi'">확인</button>
	
	<hr/>
	테이블 전체 출력<button onclick="location.href='dept'"> 조회</button><br/>
	
	<!-- 부서번호로 검색 -->
	<form action="search" method="post">
	<input type="text" name="inputdeptno" placeholder="번호로 검색"> 
	<input type="submit" value="검색"> 
	</form>
	
	<!-- 부서번호로 삭제 -->
	<form action="delete" method="post">
	<input type="text" name="inputdeptno" placeholder="부서번호로 삭제"> 
	<input type="submit" value="삭제"> 
	</form>
	
	<!-- loc 수정 -->
	<form action="update" method="post">	
	<input type="text" name="inputloc" placeholder="LOC수정"> 
	<input type="text" name="inputdeptno" placeholder="부서번호 입력"> 
	<input type="submit" value="수정"> 
	</form>
	
	<!-- 추가 -->
	<form action="insert" method="post">	
	<input type="text" name="inputdeptno" placeholder="부서번호 입력">
	<input type="text" name="inputdname" placeholder="이름 입력">	 
	<input type="text" name="inputloc" placeholder="LOC입력"> 
	<input type="submit" value="추가"> 
	</form>
</body>
</html>