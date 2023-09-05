<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:bundle basename="bundle.01_test"> <%-- basename은 class아래 경로 bundle(폴더명).파일명, 어차피 properties만 읽어오기 때문에 확장자 필요 없음 --%>
		<fmt:message key="name"/>
		<fmt:message key="title" var="msg"/>
		<%-- message 태그는 bundle 태그 내부에 있었어야 함... cf. setBundle --%>
	</fmt:bundle>
	<p>${msg}</p> <%-- 변수로 만들어 둔 거는 tag 외부에서도 사용 가능함 --%>
	
	<%-- 실제이름이 너무 길 경우 prefix 설정... 모든 key 앞에는 prefix를 붙여주세요 같은 느낌 --%>
	<fmt:bundle basename="bundle.01_test" prefix="a_">
		<fmt:message key="name1"></fmt:message>
	</fmt:bundle>
	<hr>
	
	<fmt:setBundle basename="bundle.01_test" var="test"/>
	<fmt:message bundle="${test}" key="title"/> <%-- 여기는 위에 한번만 선언한 다음 어디든 bundle="${test}를 불러와서 쓴다는 개념...영역이 자유로움 --%>
	<hr>
	
	<h1>기본 로케일 <%=response.getLocale() %></h1>
	<fmt:bundle basename="bundle.02_sampleBundle">
		<fmt:message key="id"/>
		<fmt:message key="pw"/>
		<fmt:message key="name"/>
		<fmt:message key="email"/>
	</fmt:bundle>
	
	<h1>영문 로케일</h1>
	<fmt:setLocale value="en"/>
	<fmt:bundle basename="bundle.02_sampleBundle">
		<fmt:message key="id"/>
		<fmt:message key="pw"/>
		<fmt:message key="name"/>
		<fmt:message key="email"/>
	</fmt:bundle>
</body>
</html>