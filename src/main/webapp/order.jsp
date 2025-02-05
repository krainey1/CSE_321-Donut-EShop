<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.*,p1.BuildMenu,p1.Donut,p1.DonutMenu" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<link href="index.css" rel="stylesheet" />
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
	
	li {
		text-align: center;
		color: white;
	}
	
	ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
	}
	
	p 
	{
		text-align: center;
		color: white;
	}
	
</style>
</head>
<body>
<h1>Order Details: </h1>
    <%
    	HttpSession sess = request.getSession();
        // Retrieve the cart from the session
        ArrayList<Donut> cart = (ArrayList<Donut>) sess.getAttribute("cart");
    %> <%
    for (Donut d: cart) {
      %>
      <li>Type: <%= d.getType() %> Flavor: <%= d.getFlavor() %> 
      Price Per Donut: <%= d.getPrice() %> Quantity: <%=d.getQuantity()%></li>
      <%
    }
    %>
    <% 
    float total = 0;
    for (Donut d : cart) {
      total += Double.parseDouble(d.getPrice()) * d.getQuantity();
    }
    %>
    <p> Final Total: <%= total %> </p>
    <p> Thanks for shopping with us! </p>
    <% 
    cart.clear();
    %>
    <center><a href="mserv">Home</a></center>
</body>
</html>
