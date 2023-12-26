<%@page import="model.Order_detail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Order</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
	
	ArrayList<Order> orderList = (ArrayList<Order>)(request.getAttribute("orderList"));
	int i=0;
%>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">info Order</th>
	      <th scope="col">status</th>
	      <th scope="col">receiving address</th>
	      <th scope="col">dilivery Date</th>
	      <th scope="col">total</th>
	      <th scope="col">action</th>
	    </tr>
	  </thead>
	  <tbody>
	      <% for (Order order: orderList){ i++; %>
		    <tr>
		      <th scope="row"><%=i%></th>
		      <td>
		      	<% ArrayList<Order_detail> orderListDetail = (ArrayList<Order_detail>)(request.getAttribute("orderDetail"+i)); 
		      		for(Order_detail orderDetail : orderListDetail){
		      	%>
			      	<div class="mb-3 row">
			      		<div class="col-4">
				      		<img alt="" src="<%=orderDetail.getBook().getFileName() %>" style=" width: 200px;
																								height: 200px;
																								object-fit: contain;">
			      		</div>
			      		<div class="col-8">
					      	<p>name product : <%=orderDetail.getBook().getTitle() %></p>
					      	<p>price : <%=orderDetail.getBook().getPrice() %></p>
					      	<p>quantity : <%=orderDetail.getQuality()%></p>			      		
			      		</div>
			      	</div>
		      	<%} %>
		      </td>
		      <td><%=order.getOrderStatus() %></td>
		      <td><%=order.getReceivingAddress() %></td>
		      <td>waiting....</td>
		      <td><%=order.getTotal()%></td>
		      <% if(order.getOrderStatus().equals("Pending")){ %>
		      	<td><a href="" class="btn btn-primary">Hủy</a></td>
		      <%}else{ %>
		      	<td><button class="btn btn-primary" disabled >approvaled</button></td>
		      <%} %>
		    </tr>
	      <%} %>
	  </tbody>
	</table>
</body>
</html>