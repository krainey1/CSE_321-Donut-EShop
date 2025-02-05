<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="index.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Delete Product</title>
<style>
a {
    padding: 3px 3px;
    border-radius: 3px;
    color: buttontext;
    background-color: buttonface;
    text-decoration: none;
    text-align: center;
}
</style>
</head>
<body>
<form action="products" method="post">
<input type="hidden" name="admin_action" value="delete_donut">
Donut ID: <input type="text" name="donutID">
<button type="submit"> Submit </button>
</form>
<center><a href="admin.jsp">Back to Admin Page</a></center>
</body>
</html>