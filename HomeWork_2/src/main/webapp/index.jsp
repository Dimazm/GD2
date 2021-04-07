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
   <title>!DOCTYPE</title>
   <meta charset="utf-8">
 </head>
 <body>
 <p><%= getFormattedDate() %></p>
  <form  method="POST" action="helloP">
    First Name: <input type="text" name="firstName" />
    Last Name: <input type="text" name="lastName" />
    <input  type="submit" value="Submit" />
  </form>
 </body>
</html>