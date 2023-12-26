<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Author"%>
<%@page import="model.Books"%>
<%@page import="model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
    %>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/login_register.css">
</head>
<body>
	<%
	Users user = (Users)request.getAttribute("user");
	Books book = (Books)request.getAttribute("book");
	String error = request.getAttribute("error")+"";
	error = error.equals("null")?"" : error;
	if(user == null){%>
	<h1>please login</h1>
	<%}else{ %>
		<%
			String idUser = user.getUserId();
			String fullName = user.getFullName();
			String deliveryAddress = user.getDeliveryAddress();
			String idBook = book.getIdBook();
			String fileName = book.getFileName();
			String title = book.getTitle();
			double price = book.getPrice();
		%>
		<div class="bt-form-login-simple-1 my-5">
	        <h1 class="form-heading">
	            order
	        </h1>
	        <p class="form-desc">
	            Wellcome order BookStore 
	        </p>
	        <h1><%=error %></h1>
	        <form method ="post" action="order">
	        	<input type="hidden" name="action" value="order">
	        	<input type="hidden" name="idBook" value="<%=idBook%>">
	            <div class="form-group">
	                <label for="fullName" class="form-label">fullName</label>
		    		<input type="text" class="form-control" id="fullName" name ="fullName" value="<%=fullName %>">
	            </div>
	            <div class="form-group">
	                <label for="deliveryAddress" class="form-label">deliveryAddress</label>
		    		<input type="text" class="form-control" id="deliveryAddress" name ="deliveryAddress" value="<%=deliveryAddress %>">
	            </div>
	            <div class="form-group">
	                <div class="info_product col-8">
	                	<img alt="" src="<%=fileName%>">
	                	<h6><%=title%></h6>
	                	<span class="price"><%=price%></span>
	                </div>
	                <div class="quantity_product col-4">
	                	<label for="quantity">Số lượng:</label>
						<div class="input-group">
						  <button type="button" onclick="decreaseQuantity()">-</button>
						  <input type="number" id="quantity" name="quantity" value="1">
						  <button type="button" onclick="increaseQuantity()">+</button>
						</div>
	                </div>
	            </div>
	            <div class="form-group">
	                <label for="paymentMethod">paymentMethod</label>
					<select class="form-select" id="paymentMethod" name="paymentMethod">
					  <option selected disabled>choose...</option>
					  <option value="1">Payment on delivery</option>
					  <option value="2">Paying through bank</option>
					</select>
	            </div>
	
	            <div class="form-group">
	                <label for="orderDate" class="form-label">orderDate</label> 
	                <input type="date" id="orderDate" name="orderDate" value="<%=LocalDate.now() %>" readonly="readonly">
	            </div>
	            <div class="form-group">
	                <label for="total" class="form-label">total</label> 
	                <input type="number" id="total" name="total" value="0" readonly="readonly">
	            </div>
	            <button type="submit" class="btn btn-primary form-btn">Pay</button>
	        </form>
	    </div>
    <%} %>
</body>
<script>
	var price = document.querySelector(".price").textContent;
	var totalInput = document.getElementById("total");
    var quantityInput = document.getElementById("quantity");
	var currentValue = 1
	var total = 0
  function decreaseQuantity() {
    currentValue = parseInt(quantityInput.value);
    if (currentValue > 1) {
       currentValue -= 1;
      quantityInput.value = currentValue;
      sumTotal();
    }
  }

  function increaseQuantity() {
    currentValue = parseInt(quantityInput.value);
    currentValue += 1;
    quantityInput.value = currentValue;
    sumTotal();
  }
  function sumTotal(){
	  total = price*currentValue
	  totalInput.value = total
  }
  sumTotal();
</script>
</html>