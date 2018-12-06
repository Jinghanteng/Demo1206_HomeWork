<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这里是第二个界面</h1>
	<%
		String name = (String) session.getAttribute("name");
		String password = (String) session.getAttribute("password");
		//session.setAttribute("msg", "密码错误");
		if (name == null) {
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>