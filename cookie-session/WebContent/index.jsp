<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<%
/* Cookie[] cookies = request.getCookies();
Cookie userCookie = null;
boolean userCookieFound = false;
if(cookies != null && cookies.length != 0) {
 for(Cookie cookie : cookies) {
     if("username".equals(cookie.getName())) {
         userCookie = cookie;
         break;
     }
 }
} */
if(session.getAttribute("username") != null) {
    // welcome
    %>
<p>
    Welcome <%= session.getAttribute("username") %>
</p>
    <%
} else {
    // display the form
    %>
<form action="http://localhost:8080/jsp-example/session" method="post">
    <p>
    <h3>Please enter your credentials here.</h3>
    </p>
    <p>
        Username: <input name="username" type="text">
    </p>
    <p>
        Password: <input name="password" type="password">
    </p>
    <p>
        <input type="submit" value="Click Me!">
    </p>
</form>
    <%
}
%>

</body>
</html>