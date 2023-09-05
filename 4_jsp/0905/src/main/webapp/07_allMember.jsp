<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pwd = "tiger";
	String sql = "select * from member";
	
	// statement 안 쓰는 거는 작은 따옴표로 감싸주고 + 연산해서 sql 문 생성해야 하는 불편함과 쿼리인젝션할 때 보안에 취약함(해커가 캐시 충전을 100원하면서 1억원할 수 있게 할 수 있음 ㄷㄷ)
	// 그래서 preparedStatement 사용한다심!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width='800' border='1'>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>암호</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>권한(1:관리자, 0:일반회원)</td>
		</tr>
	
	
	<%
		try { // 이거는 아마 거의 한 세트임...
			// DB연동은 예외처리를 강요함
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버 로드, DriverManager 때문에...
			//conn = DriverManager.getConnection(url, uid, pwd); // DriverManager 클래스 안에 getConnection 메서드가 있어서 DB연결을 시도함
																// Connection은 인터페이스이기 때문에 자체 객체 생성은 못함.
																// 연결 성공을 하면 conn에는 SQL문을 실행시키도록 해주는 객체 생성하는 메서드 createStatement가 있음
																// stmt에 저장됨
			// stmt = conn.createStatement(); // stmt는 나중에 다른 거 쓴다심...
			// stmt에는 sql을 실행하는 메서드가 있음 
			// stmt.executeUpdate(sql); 이건 INSERT, UPDATE, DELETE 같은 실행만 할 때...
			// rs = stmt.executeQuery(sql);
			
			rs = DriverManager.getConnection(url, uid, pwd).createStatement().executeQuery(sql);
			
			while(rs.next()) { // 구조는 이터레이터랑 비슷해서 커서가 시작 전에 있음...
				out.print("<tr>");
				out.print("	<td>" + rs.getString("name")+"</td>");
				out.print("	<td>" + rs.getString("userid")+"</td>");
				out.print("	<td>" + rs.getString("pwd")+"</td>");
				out.print("	<td>" + rs.getString("email")+"</td>");
				out.print("	<td>" + rs.getString("phone")+"</td>");
				out.print("	<td>" + rs.getInt("admin")+"</td>"); // 해당 컬럼의 데이터 타입에 맞게 메서드 선택 필요
				out.print("</tr>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally { // 이건 꼭해줘야 함! 연결된 역순으로 disconnect
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	%>
	
	</table>
</body>
</html>