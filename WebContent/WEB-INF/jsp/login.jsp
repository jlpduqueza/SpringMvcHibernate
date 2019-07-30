<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Shopping App</title>
   </head>

   <body>
      <h2>Log In</h2>
      <h4>${message}</h4>

            <form:form id="loginForm" modelAttribute="login" action="login" method="post">

				<form:label path="username">Username: </form:label>
				<br>
				<form:input path="username" name="username" id="username" />
				<br>
				<form:label path="password">Password:</form:label>
				<br>
				<form:password path="password" name="password" id="password" />
				<br>
				<form:button id="login" name="login">Login</form:button>
				<br>

            </form:form>
   </body>
   
</html>