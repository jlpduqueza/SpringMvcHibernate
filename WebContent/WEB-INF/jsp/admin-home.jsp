<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:out value = "hello! ${user.username}"/>
<br>
<br>
	<a href="cart">CART</a>
      <table id="example">
         <tr>
            <th>Products</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
         <c:forEach var="inventoryItem" items="${inventoryList}">
         <tr>
         <td><c:out value = "${inventoryItem.product.name}"/></td>
         <td>&#8369;<c:out value = "${inventoryItem.product.price}"/></td>
         <td><c:out value = "${inventoryItem.quantity}"/></td>
         <td>	
         <a href="add-to-cart-view?productId=${inventoryItem.product.id}">Add To Cart</a>
         </td>	
         </tr>
         </c:forEach>
         <c:out value = "${message}"/>
         <c:set var="message" value="" scope="session"/>
      </table>

<a href="logout">Logout</a>  
</body>
</html>