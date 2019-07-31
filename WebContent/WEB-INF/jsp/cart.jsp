<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Cart</title>
   </head>
   <body>
      <table>
         <tr>
            <th>Products</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
         <c:forEach var="cartItem" items="${cartItemList}">
         <tr>
         <td>
         <c:out value = "${cartItem.product.name}"/>
         </td>
         <td>
         &#8369; <c:out value = "${cartItem.subTotalPrice}"/>
         </td>
<%--          <td>
         <c:out value = "${cartItem.inventoryEntry.quantity}"/>--%>
         <td> 
         <c:out value = "${cartItem.quantity}"/>
         </td>
         <td>	
         <a href="/example/user/delete-cart-item?cartItemId=${cartItem.id}">Delete</a> 
         <a href="/example/user/edit-quantity?cartItemId=${cartItem.id}">Edit</a> 
         </td>	
         </c:forEach>
         <tfoot>
            <tr>
               <td>Total Price :${totalPrice} </td>
            </tr>
         </tfoot>
      </table>
      <form action="checkout" method = "POST">
         <input type="Submit" value = "Check Out" >
      </form>
      <br>
      <c:out value = "${message}"/>
      <c:set var="message" value="" scope="session"/>
      <br>
      <a href="/example/user/home">Go back shopping</a> 
   </body>
</html>