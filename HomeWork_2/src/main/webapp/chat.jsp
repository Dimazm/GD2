<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
 <head>
   <title>In Chat</title>
   <meta charset="utf-8">
 </head>
<body style="border: 1px ;width: 305px;font-size: 14pt;">
<form method="POST" name="Send Message" action="send">
<p>Please set User Name and enter the text</p>
    <tr>
		<td>User Name: </td>
		<td><input type="text" name="userName" style="width: 219px; font-size: 14pt; border: 2px solid #999;background: lightblue;">
		</td>
	</tr>
	<div></div>
<div>
<input type="text" name= "message" style="height: 100px; width: 300px; font-size: 14pt; border: 2px solid #999;background: lightyellow;">
</div>
	 <tr>
	    <td>
		</td>
		<td ALIGN=right<p><input type="submit" value="Send" style="background: lightblue; width: 100px; height: 30px;font-size: 14pt;"></p>
		</td>
	 </tr>
	 <p><a href="hist">Open History</a></p>
	 <p><a href="loginPage">Exit</a></p>
<div>Messenger Version 1.0</div>
</body>
</html>