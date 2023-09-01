<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 검색 페이지</h1>
	<form action="01_2_result.jsp">
		연령대 :&nbsp;&nbsp;	<input type="text" name="age"><br>
		카테고리 :&nbsp;&nbsp;<select name="category">
								<option value="상의">상의</option>
								<option value="하의">하의</option>
								<option value="악세사리">악세사리</option>
							</select><br>
		선호하는 색상 :&nbsp;&nbsp;<input type="checkbox" name="color" value="빨강">빨강
					 			<input type="checkbox" name="color" value="주황">주황
					 			<input type="checkbox" name="color" value="노랑">노랑
					 			<input type="checkbox" name="color" value="파랑">파랑
					 			<input type="checkbox" name="color" value="검정">검정
		<input type="submit" value="검색">
	</form>
</body>
</html>