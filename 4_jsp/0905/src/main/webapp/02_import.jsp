<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- c:import는 jsp:include와 달리 페이지, jsp 파일... 을 변수에 저장해서 변수 출력하는 곳을 원하는 위치에 출력시켜줄 수 있음 --%>
	<%-- url 페이지에 있는 걸 가서 긁어옴 --%>
	<%-- <c:import url="URL" [var="변수이름"] [scope="영역"] [charEncoding="charEncoding"] /> --%>
	<c:import url="http://localhost:8181/0905/01_forTokens.jsp"/>
	<hr><hr>
	
	<%-- 변수 설정하면 바로 출력은 안됨. 변수 출력을 해줘야 출력됨 --%>
	<c:import var="page" url="http://localhost:8181/0905/01_forTokens.jsp"/>
	${page}
	<hr><hr>
	
	<%-- url은 변수 설정하는 거와 유사 --%>
	<c:url var="token" value="http://localhost:8181/0905/01_forTokens.jsp"/>
	<c:import var="page" url="${token}"/>
	${page}
	<hr><hr>
	
	<%-- 아랫줄 주석처리 해제하면 이 페이지 볼 새 없이 forTokens로 이동해버림 케케 --%>
	<%-- <c:redirect url="${token}"/> --%>
	
	<%-- c:catch는 try catch문이랑 유사, 에러발생 코드가 변수에 담김 --%>
	<%-- <%=1/0 %> 이거는 그냥 바로 에러페이지를 발생시킴 --%>
	<c:catch var="errmsg">
		<p>에러 발생 전</p>
		<%=1/0 %>
		<p>에러 발생 후</p>
	</c:catch>
	${errmsg } <%-- 에러 발생 전 java.lang.ArithmeticException: / by zero // 에러 발생 후는 출력되지 않음ㅎ--%>
	<hr>
	
	<%-- JSTL fmt : format 형식 -- 숫자 날짜 형식 / 로케일 지정 / 메세지 처리 --%>
	<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 필요함 --%>
	<%-- 숫자 날짜 형식 지정 관련 태그 formatNumber, formatDate, parseDate, parseNumber, setTimeZone, timeZone --%>
	<p><fmt:formatNumber value="123456.789"/></p> <%-- 123,456.789 --%>
	<p><fmt:formatNumber value="123456.789" groupingUsed="false"/></p> <%-- 123456.789 --%>
	<p><fmt:formatNumber value="0.789" type="percent"/></p> <%-- 79% --%>
	<p><fmt:formatNumber value="123456" type="currency"/></p> <%-- ₩123,456 --%>
	<p><fmt:formatNumber value="123456" type="currency" currencySymbol="$"/></p> <%-- $123,456 --%>
	<p><fmt:formatNumber value="123456.789" pattern="0.0"/></p> <%-- pattern 쓰면 groupingUsed 안 따라옴 123456.8 --%>
	<p><fmt:formatNumber value="123456.789" pattern="0.0000"/></p> <%-- 123456.7890 --%>
	<p><fmt:formatNumber value="123456.789" pattern="#,##0.0000"/></p> <%-- 123,456.7890 --%>
	<p><fmt:formatNumber value="123456.789" pattern="$#,##0.0000"/></p> <%-- $123,456.7890 --%>
	<p><fmt:formatNumber value="123456.789" pattern="$#,##0.0000" var="num"/></p> <%-- 변수에 저장 --%>
	<p>${num}</p> <%-- 따로 기입해줘야 출력됨 --%>
	<hr>
	
	<c:set var="now" value="<%= new Date() %>"/> <%-- <%@page import="java.util.Date"%> --%>
	<p>${now}</p> <%-- Tue Sep 05 10:39:38 KST 2023 --%>
	<p><fmt:formatDate value="${now}" type="date"/></p> <%-- 2023. 9. 5. --%>
	<p><fmt:formatDate value="${now}" type="time"/></p> <%-- 오전 10:40:12 --%>
	<p><fmt:formatDate value="${now}" type="both"/></p> <%-- 2023. 9. 5. 오전 10:40:12 --%>
	<p><fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default"/></p> <%-- 2023. 9. 5. 오전 10:40:12 --%>
	<p><fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/></p> <%-- 23. 9. 5. 오전 10:41 --%>
	<p><fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/></p> <%-- 2023. 9. 5. 오전 10:42:42 --%>
	<p><fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/></p> <%-- 2023년 9월 5일 오전 10시 42분 42초 KST --%>
	<p><fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/></p> <%-- 2023년 9월 5일 오전 10시 42분 42초 KST --%>
	<p><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일 hh시 mm분 ss초"/></p> <%-- 2023년 09월 05일 화요일 10시 44분 39초 --%>
	<p><fmt:formatDate value="${now}" type="date" var="date"/></p> <%-- 변수에 저장 --%>
	<hr>
	
	<fmt:timeZone value="GMT">
		<p><fmt:formatDate value="${now}" type="both"/></p> <%-- 영국 그리니치 표준시 2023. 9. 5. 오전 1:51:00 --%>
	</fmt:timeZone>
	<fmt:timeZone value="EST">
		<p><fmt:formatDate value="${now}" type="both"/></p> <%-- 미동부 2023. 9. 4. 오후 8:53:15 --%>
	</fmt:timeZone>
	<hr>
	
	<%-- 언어코드_국가코드 코드는 검색ㄱㄱ --%>
	<fmt:setLocale value="ja_jp"/>
	<%-- setLocale로 설정한 이후부터는 해당 코드에 맞게 출력됨 --%>
	<fmt:formatNumber value="10000" type="currency"/>
	<fmt:formatDate value="${now}"/> <%-- ￥10,000 2023/09/05 --%>
	<br>
	<fmt:setLocale value="en_us"/>
	<fmt:formatNumber value="10000" type="currency"/>
	<fmt:formatDate value="${now}"/> <%-- $10,000.00 Sep 5, 2023 --%>
</body>
</html>