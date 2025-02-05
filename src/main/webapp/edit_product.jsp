<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="index.css" rel="stylesheet" />
<title>Edit Product</title>
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
<input type="hidden" name="admin_action" value="edit_donut">
Donut ID: <input type="text" name="donutID">
<br> (1) Type <br> (2) Flavor <br> (3) Price <br>(4) Description <br> (5) Available Quantity <br> <input type="number" min = "1" max = "5" name="to_edit">
New info: <input type="text" name="updateInfo"><br>
<button type="submit"> Submit </button>
</form>
<center><a href="admin.jsp">Back to Admin Page</a></center>
</body>
</html>