<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String id = request.getParameter("id");
out.println(id);

String password = request.getParameter("password");
out.println(password);

String gender = request.getParameter("gender");
out.println(gender);

String[] interests = request.getParameterValues("interests_list");
for (int i = 0; i < interests.length; i++){
	out.print(interests[i] + " ");
}

%>

</body>
</html>