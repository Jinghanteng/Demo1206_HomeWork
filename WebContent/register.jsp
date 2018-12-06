<%@page import="dao.UserDao"%>
<%@page import="java.awt.image.RescaleOp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input name="username"> <br> <input name="password">
		<br> <input type="submit" value="注册">
		<%!UserDao userDao = new UserDao();%>


		<%
			//获取提交的数据
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			if (name != null || password != null) {
				//添加到数据库
				userDao.addUser(name, password);
				response.sendRedirect("login.jsp");
			}
		%>

	</form>
</body>
</html>