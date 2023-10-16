<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container mt-3">
   <form method="post" action="/auth/securityLogin">
     <div class="mb-3 mt-3">
       <label for="username" class="form-label">
       		<spring:message code="user.login.form.username" />
	   </label>
       <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
     </div>
     <div class="mb-3">
       <label for="password" class="form-label">
			<spring:message code="user.login.form.password" />
	   </label>
       <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
     </div>
     <button id="btn-login" type="submit" class="btn btn-primary">
     	<spring:message code="user.login.form.login_btn" />
     </button>
     <a href="">
     	<img src="/img/kakao_login_medium_narrow.png">
     </a>
   </form>
</div>

<script src="/js/login.js"></script>
<%@ include file="../layout/footer.jsp" %>