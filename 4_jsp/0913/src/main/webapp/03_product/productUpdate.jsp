<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" href="03_style/shopping.css">
</head>
<body>
<%--
	이미지 경로는 upload/파일명 // 만든 폴더명/파일명 // eg. <img src="upload/파일명">
	
	List 페이지에서 수정 버튼을 누르면 update 페이지로 넘어가야 함
	
	1. list 페이지 수정 버튼에 링크 설정
	2. 요청 받을 서블릿 구현
	   -. 해당 상품에 정보를 DB에서 뽑아와야 함 (dao에서 구현)
	   -. 정보를 다 뽑아 온 후 update 페이지로 넘겨줘야 함
	   -. update 페이지로 이동
	3. update 페이지에서 받아온 정보를 화면에 출력
	
	수정 페이지에서 수정할 거 수정한 다음 수정버튼을 누르면 목록 페이지로 이동
	
	수정 요청을 받는 서블릿 구현
	-. 수정할 데이터를 받아서 DB에 접속해서 수정 처리
	-. 완료되면 목록페이지로 이동
	
	단, 이미지는 수정 안하면 기존 이미지가 유지되어야 함.
--%>
	<div id="wrap" align="center">
		<h1>상품 수정</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
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
								<td><input type="text" name="name" value="${product.name}"></td>
							</tr>
							<tr>
								<th>가격</th>
								<td><input type="text" name="price" value="${product.price}"></td>
							</tr>
							<tr>
								<th>사진</th>
									<td>
										<input type="file" name="pictureUrl">
										<input type="hidden" name="originPictureUrl" value="${product.pictureUrl}">
										<!-- 이렇게 하면 처음에는 보이는데 바뀐 게 업데이트는 안됨... 에효...
											<input type="file" name="pictureUrl" id="files" style="display:none;"/>
											<label for="files">
												<span style="border:1px solid; background:rgb(240, 240, 240); padding:3px 6px; border-radius: 2px;">파일 선택</span> ${product.pictureUrl}
											</label>
										 -->
									</td>
							</tr>
							<tr>
								<th>설명</th>
								<td><textarea cols=80 rows=10 name="description">${product.description}</textarea>
								</td>
							</tr>
						</table> <br>
						<input type="submit" value="수정" onclick="return productCheck()">
						<input type="reset" value="다시작성">
						<input type="button" value="목록" onclick="location.href='productList.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="03_script/product.js"></script>
</body>
</html>