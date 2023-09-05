<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		rs = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger")
			.prepareStatement("SELECT * FROM EMPLOYEE").executeQuery();
		
		while(rs.next()){
			out.print("<tr>");
			out.print("	<td>" + rs.getString("name")+ "</td>");
			out.print("	<td>" + rs.getString("address")+ "</td>");
			out.print("	<td>" + rs.getString("ssn")+ "</td>");
			out.print("</tr>");
		}
	%>
	</table>
</body>
</html>