<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container mx-auto p-5">
      <form method="post" action="login.do">
        <div class="mb-3">
          <label class="form-label">아이디</label>
          <input type="text" class="form-control" name="id">
        </div>
        <div class="mb-3">
          <label class="form-label">비밀번호</label>
          <input type="password" class="form-control" name="pw">
        </div>
        <button type="submit" class="btn btn-dark">로그인</button>
      </form>
      <c:if test="${!empty msg}">
	      <div class="alert alert-danger mt-4">${msg}</div>
      </c:if>
   </div>
   
</body>
</html>