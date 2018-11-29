<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<title>Assignment 3 - part 1</title>
</head>
<body>
<% String strWidth = getServletContext().getInitParameter("width"); %>
<% String strHeight = getServletContext().getInitParameter("height"); %>
<% String strDepth = getServletContext().getInitParameter("depth"); %>

<form action="VolumeCalculator" method="get">
	<h3>Milim Lee 991274533</h3>
	
	<table class="table table-striped">		
		<tr><td><font face="verdana" size="2px">Width  </font></td>
		<td><%=strWidth %></td></tr>
		<tr><td><font face="verdana" size="2px">Height </font></td>
		<td><%=strHeight %></td></tr>
		<tr><td><font face="verdana" size="2px">Depth </font></td>
		<td><%=strDepth %></td></tr>
		
		<tr><td><font face="verdana" size="2px">Scaling Factor : </font></td>
		<td><input type="text" name="scale" class="form-control"></td></tr>
	</table>
	<p class="text-primary">Enter a Scaling Factor such as 1/2, 1/4, 8, etc.</p>
	<p style="color:red"><strong>  EXCEPT "0"</strong></p>
	<input type="submit" name="submit" value="Submit" class="btn btn-default">

</form>
<footer>
<div class="footer-copyright text-center py-3">
	<my:pi /><br>
	<my:e /><br>
</div>
</footer>
</body>
</html>