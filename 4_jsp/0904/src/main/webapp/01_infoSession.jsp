<%@page import="java.util.Enumeration"%>
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
		// 244p 메서드 목록들...
		String id_str = session.getId();
		long createtime = session.getCreationTime();	
		long lasttime = session.getLastAccessedTime();
		long used_time = (lasttime - createtime) / 60 / 1000;
		int inactive = session.getMaxInactiveInterval() / 60;
		boolean b_new = session.isNew();	
	%>
	String id_str 	세션ID : <%=id_str %><br>
	long createtime 	세션 생성된 시간 : <%=createtime %>(ms 단위)<br>
	long lasttime	세션 마지막 방문 시간 : <%=lasttime %>(ms 단위)<br>
	long used_time	세션 생성 후 머문 시간 : <%=used_time %>(분)<br>
	int inactive		세션 유효 기간 : <%=inactive %>(분)<br>
	boolean b_new	새로 생성된 세션? : <%=b_new %><br>
	<hr>
	<%
		// 일단 쿠키랑은 달리 세션은 걍 지우면 지워짐
		// 쿠키는 여러 개 생성이 가능한데, 세션은 브라우저당 단 하나만 만들어짐
		// removeAttribute
		session.setAttribute("name1", "첫번째 값");
		session.setAttribute("name2", "두번째 값");
		session.setAttribute("name3", "세번째 값");
		
		out.print("세션 삭제 전  =====================<br>");
		
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = session.getAttribute(name).toString();
			out.print(name + " : " + value + "<br>");
		}
		// 출력은 name3, name2, name1 순으로 되넹ㅎ
		session.removeAttribute("name2");
		
		out.print("name2 삭제 후	====================<br>");
		
		names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = session.getAttribute(name).toString();
			out.print(name + " : " + value + "<br>");
		}
	%>
	<hr>
	<%
		// 세션 제거, 로그아웃 버튼에 들어가면 된다심...
		// 세션이 제거된다고 세션의 존재가 소멸되는 개념이 아니라 세션이 새로 바뀌는 개념이라심
		// 모든 웹사이트는 세션이 존재, 항상 존재, 라이브러리들이 많아서 숨겨놓긴 한다심...
		// invalidate한다음 제거된 상태로 유지되지 않음. session id가 교체됨
		session.invalidate();
		out.print("세션 삭제 후, ");
		if(request.isRequestedSessionIdValid()==true)
			out.print("세션 아이디가 유효합니다.");
		else
			out.print("세션 아이디가 유효하지 않습니다.");
	%>
</body>
</html>