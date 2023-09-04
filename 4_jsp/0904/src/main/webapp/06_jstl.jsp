<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- uri 주소는 자동 완성되기 때문에 외울 필요 없음, ctrl+space로 고르기
	 접두어를 왜 쓰냐믄 이 uri를 축약해서 c로 쓰겠다는 고런 의미로 씀 c는 core의 첫글자 
	 core는 자바의 기본 기능을 구현할 수 있게 해주나봄 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="Hello JSTL" />
	<hr>
	<%--
		<c:set var="변수이름" value="저장할 값" [scope="{page|request|session|application}"]/>
		혹은
		<c:set var="변수이름" [scope="{page|request|session|application}"]> 저장할 값 </c:set>
		
		편의상 변수라고 써있긴 하지만 정확하게는 내장객체의 속성을 설정하는 것임...
		
		자바 빈의 경우
		<c:set target="${member}" property="프로퍼티 이름" value="저장할 값"/> 여긴 var가 아니라 target
		<c:set var="member" value="<%= new com.mission.javabeans.MemberBean()%>"/> 여긴 생성자 쓰는 건데 클래스명만 쓰는 게 아니라 패키지명까지 써줘야 한다는 점 유의할 것
		얘는 속성값이 아니라 객체임...
	--%>
	<c:set var="msg" value="hello"/>
	<h1>${msg}</h1>
	
	<c:set var="age">
		30
	</c:set>
	<h1>${age}</h1>
	
	<c:set var="member" value="<%= new p03_sample.javabeans.C03_1_MemberBean()%>"/>
	<c:set target="${member}" property="name" value="홍길동"/>
	<h1>${member.name}</h1>
	
	<%-- <c:remove var="변수이름" [scope="{page|request|session|application}"]/> scope는 생성할 때와 동일해야 함! 명시를 하지 않으면 다 지워지나봄 원래는 page만 지워지거나 뭐 이런 식이라신데... --%>
	<c:remove var="msg"/>
</body>
</html>