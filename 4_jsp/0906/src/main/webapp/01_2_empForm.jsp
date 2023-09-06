<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String type = request.getParameter("type");
		String empno = request.getParameter("empno");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String dept = request.getParameter("dept");
		
		empno = empno!=null? empno : "";
		name = name!=null? name : "";
		birth = birth!=null? birth : "";
		dept = dept!=null? dept : "";

		String ref = "01_3_empUpdate.jsp?type=" + type; 
	%>
	<h1>사원 <%=type%> 페이지</h1>
	<h1><%=type%>할 정보를 입력해주세요</h1>
	
	<form action="<%=ref%>" method="post">
		<table>
			<tr>
				<td>사원번호</td>
				<td>&nbsp;:&nbsp;</td>
				<td><input name="empno" value="<%=empno%>"></td>
			</tr>
		<% if(!type.equals("삭제")) { %>
			<tr>
				<td>이름</td>
				<td>&nbsp;:&nbsp;</td>
				<td><input name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>&nbsp;:&nbsp;</td>
				<td><input name="birth" value="<%=birth%>"></td>
			</tr>
			<tr>
				<td>부서명</td>
				<td>&nbsp;:&nbsp;</td>
				<td><input name="dept" value="<%=dept%>"></td>
			</tr>
		<% } %>
		</table>
		<br>
		<a href="01_1_empAll.jsp"><button type="button">목록</button></a>
		<input type="reset" value="초기화">
		<input type="submit" value="<%=type%>">
	</form>
</body>
</html>