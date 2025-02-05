<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, p1.OrdersList, p1.Order, p1.Donut, p1.BuildMenu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
<link href="index.css" rel="stylesheet"/>
<style>
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
<h1>Modify Inventory</h1>
<%-- first we need to get the inventory again --%>
<div class="donut-container">
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
	     <div class="mod">
	     <form action="modserv" method = "POST"> 
	     <input type="hidden" name = modAction value="inc"/>
	     <input type="hidden" name = donutID value="<%= d.getDonutID() %>"/>
	     <button type = "submit"> + </button>
	     </form>
	     <form action="modserv" method = "POST"> 
	     <input type="hidden" name = modAction value="dec"/>
	     <input type="hidden" name = donutID value="<%= d.getDonutID() %>"/>
	     <button type = "submit"> - </button>
	     </form> 
	     </div>
	     </div>
	<%
	      }
	%>
<h1> Current Orders </h1>
<%
	OrdersList ordersList = new OrdersList();
	for (Order o : ordersList.list) {
%><% if (o.isOpen()) { %>	
	<div class="donut-tile">			
			<p> OrderID: <%=o.getOrderID()%> </p>
			<p> Customer Name: <%=o.getName()%> </p>
			<p> Time Ordered: <%=o.getTimeStamp() %> </p>
			<p> Card Number: <%=o.getCardNumber()%> </p>
			<p> Total: $<%=o.getTotal() %> </p>
			 <% ArrayList<String> log = o.getLog(); 
          	 for( String entry : log) {
          		 %> <p> <%=entry %> </p> <%
          	 }
          %>
		    <form action="eserv" method="POST">
                 <input type="hidden" name="OrderID" value="<%= o.getOrderID() %>" />
                    <input type="hidden" name="name" value="<%= o.getName() %>" />
                    <input type="hidden" name="timeStamp" value="<%= o.getTimeStamp() %>" />
                    <input type="hidden" name="cardNumber" value="<%= o.getCardNumber() %>" />
                    <input type="hidden" name="total" value="<%= o.getTotal() %>" />
            	<button type="submit"> Close </button>
          </form>

	</div>
   <% }%>
<%} %>
<br/>
<center><a href="mserv">Back to Menu</a></center>
</body>
</html>
