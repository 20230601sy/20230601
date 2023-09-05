<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pw = "tiger";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			String name = request.getParameter("name");
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int admin = Integer.parseInt(request.getParameter("admin"));
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pw);
			pstmt = conn.prepareStatement("insert into member values(?, ?, ?, ?, ?, ?)");
			// pstmt = conn.prepareStatement("insert into member values(sysdate, 0, '1234', ?, ?, ?)"); 변동되지 않을 값은 걍 집어 넣으면 됨
			// 비어있는 물음표에는 바인딩 시켜줘야 함. 이거는 1부터 시작하나봄. 흐음.
			pstmt.setString(1, name);
			pstmt.setString(2, userid);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, admin);
			
			pstmt.executeUpdate(); // 걍 execute만 때려도 된다심...
			out.print("<h1>DB 저장 성공<h1>");
		} catch(Exception e) {
			out.print("<h1>DB 저장 실패<h1>");
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	%>
	<a href="07_allMember.jsp">전체 목록 보기</a>
</body>
</html>