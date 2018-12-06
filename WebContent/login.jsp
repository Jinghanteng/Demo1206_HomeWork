
<%@page import="model.User"%>
<%@page import="dao.UserDao"%>
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
		<br> <input type="submit" value="登录"> <a
			href="register.jsp">注册</a>

		<%!UserDao userDao = new UserDao();%>

		<%
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			session.setMaxInactiveInterval(5);
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			User user = userDao.getInfoByName(name);

			if (name != null || password != null) {

				if (user != null) {
					String password1 = user.getPassword();
					//登录密码判断
					if (password1.equals(password)) {
						response.sendRedirect("home.jsp");
					} else {
						response.sendRedirect("login.jsp");
						session.setAttribute("msg", "密码错误");
					}
				} else {

					response.sendRedirect("login.jsp");
					session.setAttribute("msg", "用户名错误");

				}

			}
		%>

		${msg }
	</form>
</body>
</html>