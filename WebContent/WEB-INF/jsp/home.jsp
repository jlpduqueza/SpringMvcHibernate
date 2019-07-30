<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
success
</head>
<body>
${login.username} 
<br>
<br>

<table id="example">
         <tr>
            <th>username</th>
            <c:forEach var="user" items="${userList}">
	         <tr>
	         <td><c:out value = "${user.username}"/></td>
	         </tr>
	         </c:forEach>
      </table>

<a href="logout" >Logout</a>  
</body>
</html>