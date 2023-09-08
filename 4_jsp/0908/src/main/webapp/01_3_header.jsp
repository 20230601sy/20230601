<%@page import="p01_vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		text-decoration: none;
		color : black;
	}
	table {
		margin : auto;
	}
	td {
		width : 250px;
		border : 1px solid black;
		text-align : center;
	}
	p {
		line-height: 10px;
		height: 10px;
	}
	a {
		text-decoration: none;
	}
	.header-table{
		border-spacing: 5px;
	}
</style>
</head>
<body>
	<%
		EmpVO vo = (EmpVO)session.getAttribute("vo");
		String tdtxt1 = "";
		String tdtxt2 = "";
		String tdtxt3 = "<p>로그인</p>";
		String tdtxt4 = "<p>사원 등록</p><p style='color: lightgrey; font-size: 0.5rem;'>(관리자로 로그인 후 사용 가능)</p>";
		String tdtxt5 = "<p>마이페이지</p>";
		String url4="";
		String url5="";
		
		if(vo != null) {
			tdtxt1 = "<p>" + vo.getName() + "님 반갑습니다.</p>";
			tdtxt2 = "<p>레벨 : " + vo.getLev() + "</p>";
			tdtxt3 = "<p>로그아웃</p>";
			if(vo.getLev().equals("A")){
				tdtxt4 = "<p>사원 등록</p>";
				url4 = "custom.do";
			}
			url5 = "mypage.do";
		} else {
			tdtxt5 += "<p style='color: lightgrey; font-size: 0.5rem;'>(로그인 후 사용 가능)</p>";
		}
		/* 
		 * 강사님은 <c:if test="${!empty loginUser"> ${loginUser.name}님 반갑습니다.로 구현하심...
		*/
	%>
	<table class="header-table">
		<tr>
			<td><%=tdtxt1 %></td>
			<td><%=tdtxt2 %></td>
			<td><a href="logout.do" ><%=tdtxt3 %></a></td>
			<td><a href=<%=url4 %> ><%=tdtxt4 %></a></td>
			<td><a href=<%=url5 %> ><%=tdtxt5 %></a></td>
		</tr>
	</table>
</body>
</html>