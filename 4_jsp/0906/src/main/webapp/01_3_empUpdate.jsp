<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	PreparedStatement ps = null;
	String type = "";
	String sql = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		type = request.getParameter("type");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
			
			if(type.equals("등록"))
				sql = "INSERT INTO 사원 VALUES(?,?,?,?)";
			else if(type.equals("삭제"))
				sql = "DELETE FROM 사원 WHERE 사원번호=?";
			else
				sql = "UPDATE 사원 SET 이름=?, 생년월일=?, 부서명=? WHERE 사원번호=?";
			ps = conn.prepareStatement(sql);
			
			if(type.equals("등록")){
				ps.setInt(1, Integer.parseInt(request.getParameter("empno")));
				ps.setString(2, request.getParameter("name"));
				ps.setInt(3, Integer.parseInt(request.getParameter("birth")));
				ps.setString(4, request.getParameter("dept"));
			}
			else if(type.equals("삭제"))
				ps.setInt(1, Integer.parseInt(request.getParameter("empno")));
			else {
				ps.setString(1, request.getParameter("name"));
				ps.setInt(2, Integer.parseInt(request.getParameter("birth")));
				ps.setString(3, request.getParameter("dept"));
				ps.setInt(4, Integer.parseInt(request.getParameter("empno")));
			}
			
			ps.executeUpdate();
			out.print("<h1>" + type + " 완료<h1>");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<h1>" + type + " 실패<h1>");
		} finally {
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		}
	%>
	
	<%@ include file="01_4_footer.jsp" %>
</body>
</html>