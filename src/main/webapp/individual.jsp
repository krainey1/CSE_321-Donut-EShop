<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import= "java.util.ArrayList, java.util.*,p1.BuildMenu,p1.Donut,p1.DonutMenu" %>
<html>
<head>
<meta charset="UTF-8">
<title> Some Donut</title>
<link href="index.css" rel="stylesheet">  
<style>
img {
   max-width: 150px;
   max-height: 150px;
}
</style>
</head>

<body>
<%
		ArrayList<Donut> cart = (ArrayList<Donut>) session.getAttribute("cart");
%>
<div class="topnav" id="menu-topnav">
		<a class="active" href="mserv">Menu</a>
		<a href="eserv">Employee</a>
		<a href = "aserv"> Admin</a>
		<a href="cserv">Cart</a> <div class="circle"><%= Donut.getTotal(cart) %></div>
	</div>
<%
BuildMenu ourmenu = new BuildMenu();
	
	String p = request.getParameter("donutid");
	Integer id = Integer.parseInt(p);
	Donut d = ourmenu.getDbyId(id);
%>

<center> <div class = "donut-tile"> 
<img src="<%= p1.images.getImagePath(d.getDonutID()) %>" class="donut-image" />
<h2> Donut <%= d.getDonutID() %> </h2>
<p>Type: <%= d.getType() %></p>
<p> Flavor: <%= d.getFlavor() %></p>
<p> Price: <%= d.getPrice() %></p>
<p> <%= d.getDescription() %></p>
<p> Quantity Available: <%= d.getAvailableQuantity() %></p>
<form action="serv" method="post">
	<input type="hidden" name="donutID" value="<%= d.getDonutID() %>" />
        <input type="hidden" name="donutType" value="<%= d.getType() %>" />
        <input type="hidden" name="donutFlavor" value="<%= d.getFlavor() %>" />
        <input type="hidden" name="donutPrice" value="<%= d.getPrice() %>" />
        <input type="hidden" name="donutDesc" value="<%= d.getDescription() %>" />
        <input type="hidden" name="availableQuantity" value="<%= d.getAvailableQuantity() %>" />
        <button type="submit"> + </button>
</form>
</div> </center>

</body>
</html>
