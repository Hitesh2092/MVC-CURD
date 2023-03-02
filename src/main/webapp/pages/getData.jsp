<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <thead>
      <tr>
        <td>User ID</td>
        <td>User NAME</td>
        <td>User UNAME</td>
        <td>User PASSWORD</td>
      <tr>  
  <thead>
  
       <c:forEach items="${list}" var="user">
      <tr> 
         <td>${user.uid}</td>
         <td>${user.name}</td>
         <td>${user.uname}</td>
         <td>${user.password}</td>
        <tr>  
        </c:forEach> 
  <tbody>
  </tbody>
  

</table>


</body>
</html>