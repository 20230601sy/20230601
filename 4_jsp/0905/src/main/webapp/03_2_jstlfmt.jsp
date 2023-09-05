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
	<%-- request.setCharacterEncoding("utf-8")과 동일한 fmt:requestEncoding --%>
	<fmt:requestEncoding value="utf-8"/>
	<h1>${param.name}</h1>
</body>
</html>