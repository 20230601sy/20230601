<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Jsp</h1>
	<%
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		
		out.print(num1 + " + " + num2 + " = " + add); // 이것도 되긴 된다심 ㄷㄷㄷ
		// 일단 jsp는 servlet으로 변환된 다음
		// 변환시킨 거 실제로 구경해보려면...
		// D:\Y\20230601ezen\4_jsp\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\0831\org\apache\jsp
		// 톰캣 안에 재스퍼란 애가 만들어준 _01_005ftest_jsp.java vscode로 열어보면 아래쪽에 익숙한 코드가 보임
		// 컴파일을 해서 _01_005ftest_jsp.class라는 것도 만들음
		// .java에서 out을 만들어두기 때문에 갖다 쓸 수 있는 거라심...
		// 서블릿에 직접 작업하는 게 빠르긴 함. 왜냐면 변환 과정이 생략되니까. 근데 속도 차이는 별로 안남. 서블릿 생명주기랑 똑같이 이닛 외에는 날 일이 없음...
		// 근데 쓰면 복잡하니까 나눠서 쓰는 거임...
	%>
</body>
</html>