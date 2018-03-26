<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Books Management</h1>
<h2><a href="#">Add New Book</a>
 &nbsp;&nbsp;&nbsp;
 <a href="/javaWeb/list">List All Books</a>
</h2>
</center>
<div align="center">
<table border="2" >
<h2>List of Books</h2>
<tr>
<th>ID</th>
<th>Title</th>
<th>Author</th>
<th>Price</th>
<th>Action</th>
</tr>

<c:forEach var="book" items="${book}">
<tr>
<td><c:out value="${book.id }"/></td>
<td><c:out value="${book.title }"/></td>
<td><c:out value="${book.author }"/></td>
<td><c:out value="${book.price }"/></td>
<td><a href="/edi?id=<c:out value="${book.id }"/>">Edit</a>
 &nbsp;&nbsp;
 <a href="/delete?id=<c:out value="${book.id }"/>">Delete</a>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>