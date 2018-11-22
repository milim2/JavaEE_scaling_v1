<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 3 - part 1</title>
</head>
<body>
<form action="VolumeCalculator" method="get">
	<h1>Milim Lee 991274533</h1>
	
	<table>		
		<tr><td><font face="verdana" size="2px">Scaling Factor : </font></td>
		<td><input type="text" name="scale"></td></tr>
	</table>
	<p>Enter a Scaling Factor such as 1/2, 1/4, 8, etc.</p>
	<p style="color:red"><strong>  EXCEPT "0"</strong></p>
	<input type="submit" name="submit" value="Submit">

</form>

</body>
</html>