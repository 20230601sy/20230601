<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container mt-3">
   <form>
      <input type="hidden" id="id" value="${principal.user.id}">
      
      <div class="mb-3">
         <label for="username">username : </label>
         <input type="text" class="form-control" id="username" value="${principal.user.username}">
      </div>
      <div class="mb-3">
         <label for="password">password : </label>
         <input type="text" class="form-control" id="password">
      </div>
      <div class="mb-3">
         <label for="email">email : </label>
         <input type="text" class="form-control" id="email" value="${principal.user.email}">
      </div>
   </form>

   <button id="btn-update" class="btn btn-secondary">회원정보 수정</button>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>