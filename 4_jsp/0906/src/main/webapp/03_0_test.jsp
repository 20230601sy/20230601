<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="p03_com.study.dao.MemberDAO" %>
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
		MemberDAO memberDAO = MemberDAO.getInstance();
		Connection conn = memberDAO.getConnection();
		// out.print("연결 성공");
		PreparedStatement ps = conn.prepareStatement("select * from member");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			out.println(rs.getString(1));
		}
	%>
</body>
</html>