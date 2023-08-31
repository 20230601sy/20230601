<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>악세사리</h1>
	<p>관심항목을 선택하세요</p>
	<form method="get" action="CheckboxServlet">
		<input type="checkbox" name="item" id="shoe" value="신발">
		<label for="shoe">신발</label>
		<input type="checkbox" name="item" id="bag" value="가방">
		<label for="bag">가방</label>
		<input type="checkbox" name="item" id="belt" value="벨트">
		<label for="belt">벨트</label> <br>
		<input type="checkbox" name="item" id="cap" value="모자">
		<label for="cap">모자</label>
		<input type="checkbox" name="item" id="watch" value="시계">
		<label for="watch">시계</label>
		<input type="checkbox" name="item" id="jewelry" value="쥬얼리">
		<label for="jewelry">쥬얼리</label> <br>
		
		<select name="job">
			<option value="학생">학생</option>
			<option value="군인">군인</option>
			<option value="공무원">공무원</option>
		</select>
		
		<input type="submit" value="전송">
	</form>
</body>
</html>