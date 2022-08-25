<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String s=(String)session.getAttribute("user");
if(s==null){
	RequestDispatcher req=request.getRequestDispatcher("Login_man.jsp");
	req.forward(request,response);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirect</title>
</head>
<body>
  <form action="./Logout" method="post">
  <input type="submit" value="Click to redirect">
  </form>
</body>
</html>