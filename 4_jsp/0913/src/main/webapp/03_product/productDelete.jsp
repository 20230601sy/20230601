<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
<link rel="stylesheet" href="03_style/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 삭제</h1>
		<form method="post" name="frm">
			<table>
				<tr>
					<td>
						<c:if test="${empty product.pictureUrl}">
							<p>이미지가 없습니다</p>
						</c:if>
						<c:if test="${!empty product.pictureUrl}">
							<img src="03_upload/${product.pictureUrl}">
						</c:if>
					</td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상품명</th>
								<td>${product.name}</td>
							</tr>
							<tr>
								<th>가격</th>
								<td>${product.price}원</td>
							</tr>
							<tr>
								<th>사진</th>
								<td>${product.pictureUrl}</td>
							</tr>
							<tr>
								<th>설명</th>
								<td>${product.description}</td>
							</tr>
						</table> <br>
						<input type="submit" value="삭제">
						<input type="button" value="목록" onclick="location.href='productList.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="03_script/product.js"></script>
</body>
</html>