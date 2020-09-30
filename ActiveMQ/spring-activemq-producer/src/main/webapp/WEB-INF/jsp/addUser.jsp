<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user/addUser" method="post">
		ID：<input type="text" name="userid"/><br/>
		姓名：<input type="text" name="username"/><br/>
		年龄：<input type="text" name="userage"/><br/>
		邮箱：<input type="text" name="useremail"/><br/>
		<input type="submit" value="OKOK"/><br/>
	</form>
</body>
</html>