<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import= "java.util.ArrayList, java.util.*,p1.Order,p1.Donut,p1.OrdersList, p1.BuildMenu" %> 
<!DOCTYPE html>
<html>
<head>
<link href="index.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Admin</title>
<style>
p {
  text-align: center;
  color: white;
}
a {
    padding: 3px 3px;
    border-radius: 3px;
    color: buttontext;
    background-color: buttonface;
    text-decoration: none;
    text-align: center;
}

.mod {
		display: inline-flex;
}

</style>
</head>
<body>
<h1> Current Menu: </h1>
<p> Would you like to add to, remove from, or update the menu?</p>
<center><div class="mod">
	     <form action="new_product.jsp"> 
	     <button type = "submit"> ADD </button>
	     </form>
	     <form action="delete_product.jsp"> 
	     <button type = "submit"> REMOVE </button>
	     </form> 
	     <form action="edit_product.jsp"> 
	     <button type = "submit"> UPDATE </button>
	     </form> 
</div></center>

	<%
		BuildMenu ourmenu = new BuildMenu();
		ArrayList<Donut> ourdonuts = ourmenu.getMenu();
		for (Donut d : ourdonuts) {
	%>
	
	<div class="donut-tile">
	     <h2> Donut <%= d.getDonutID() %></h2>
	     <p>Type: <%= d.getType() %></p>
	     <p>Flavor: <%= d.getFlavor() %></p>
	     <p>Price: $<%= d.getPrice() %></p>
	     <p> Quantity Available: <%= d.getAvailableQuantity() %></p>  
	     <p> Description: <%= d.getDescription() %></p>
	     </div>
	<%
	      }
	%>
<%
OrdersList list = new OrdersList();
%>
<!-- generate the orders that are closed given a timestamp -->
	<h1> Sales Reports: </h1>
	<h1> Totals this Week </h1>
		<p> $<%= list.weeklyTotal() %> </p>
	<h1>Totals this Month</h1>
		<p> $<%= list.monthlyTotal()%> </p>
	<h1> Totals this Year</h1>	
		<p> $<%= list.yearlyTotal() %> </p>
	<br/>
	<center><a href="mserv">Back to Menu</a></center>
</body>
</html>