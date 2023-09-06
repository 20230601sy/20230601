<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보</h1>
	<table border='1'>
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>부서명</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<% 
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				ps = conn.prepareStatement("select * from 사원 ORDER BY 사원번호");
				rs = ps.executeQuery();
				while(rs.next()) {
					out.print("<tr>");
					out.print("	<td>" + rs.getString(1)+ "</td>");
					out.print("	<td>" + rs.getString(2)+ "</td>");
					out.print("	<td>" + rs.getString(3)+ "</td>");
					out.print("	<td>" + rs.getString(4)+ "</td>");
					out.print("	<td><a href='01_3_empUpdate.jsp?type=삭제&empno=" + rs.getString(1) + "'><button type='button'>삭제</button></a></td>");
					out.print("	<td><a href='01_2_empForm.jsp?type=수정&empno=" + rs.getString(1) + "&name=" + rs.getString(2) + "&birth=" + rs.getString(3) + "&dept=" + rs.getString(4) + "'><button type='button'>수정</button></a></td>");					
					out.print("</tr>");
				}
			} catch(Exception e) {
				e.printStackTrace();
				
			} finally {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}
		%>
	</table>

	<%@ include file="01_4_footer.jsp" %>
</body>
</html>