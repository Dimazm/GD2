<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%!
    String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");
        return sdf.format(new Date());
}
%>
<html>
 <head>
   <title>Authorization Page</title>
   <meta charset="utf-8">
 </head>
 <body>
  <form method="GET" name="authorization" action="login">
 <TABLE   WIDTH=100 ALIGN=left BORDER=2 BGCOLOR=lightgrey CELLPADDING=10 CELLSPACING=2>
 <p><a href="addUser">Add new user</a></p>
     <tr>
		<td>Login:</td>
		<td><input type="text" name="login"></td>
	</tr>
      <tr>
	    <td> Password:</td>
	    <td><input type="password" name="password"></td>
	  </tr >
	 <tr>
	    <td></td>
		<td ALIGN=right
		<p>
		<input type="submit" value="Enter" style="background: lightblue; width: 100px; height: 30px;">
		</p>
		</td>
	</tr>
  </form>
</html>
 </body>