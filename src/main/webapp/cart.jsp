<%@page import="model.Cart_detail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../assets/images/icon.png">
    <link rel="stylesheet" href="<%=url%>/assets/css/cart.css">
    <link rel="stylesheet" href="<%=url%>/assets/css/Global.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <title>Cart</title>
</head>
<body>
<%
	double total = 0;
	ArrayList<Cart_detail> cart_list = (ArrayList<Cart_detail>) session.getAttribute("cart-list");
	session.setAttribute("cart_list", cart_list);	
%>
	<div id="wrapper">
        <jsp:include page="/Common/header.jsp"></jsp:include>
        <a href="#" id="btn-to-top"><i class="fa-solid fa-angle-up"></i></a>
        <div class="container">
        	<%if(cart_list==null){%>
        	<h1>No products</h1>
        	<%}else{%>
            <h1>shopping cart<span>(<%=cart_list.size() %> sản phẩm)</span></h1>
            <div class="cart-products">
                <table class="main-cart">
                    <thead class="infor-cart">
                        <tr>
                            <th style="width: 70px;">select</th>
                            <th>product</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th style="width: 70px;">delete</th>
                        </tr>
                    </thead>
                    <%
							    for (Cart_detail cart : cart_list) {
							    	total += cart.getQuantity()*cart.getBooks().getPrice();
					%>
	                    <tr class="item-cart">
	                        <td class="choose-products">
	                            <input type="checkbox">
	                        </td>
	                        <td class="images_title_cart">
	                            <div class="images-cart-product">
	                                <img src="<%=cart.getBooks().getFileName()%>"
	                                    alt="">
	                            </div>
	                            <div class="title-cart">
	                                <p class="name-products"><%=cart.getBooks().getTitle()%></p>
	                                <p class="color"><%=cart.getBooks().getAuthor().getAuthorName()%></p>
	                                <p class="size"><%=cart.getBooks().getCategory().getTitleCategory()%></p>
	                            </div>
	                        </td>
	                        <td class="price-cart"><%=cart.getBooks().getPrice()%></td>
	                        <td class="quantity-cart">
	                        	<a class="btn btn-decre m-0" href="cart?action=quatityCart&cartDetailId=<%=cart.getCartDetailId()%>&quatity=desc">
	                            	<input type="button" value="-" class="btn_decrenment-cart">
	                            </a>
	                            <input type="number" class="btn_quantity_input_cart" min="1" max="100" value="<%=cart.getQuantity()%>">
	                            <a class="btn btn-incre m-0" href="cart?action=quatityCart&cartDetailId=<%=cart.getCartDetailId()%>&quatity=inc">
	                            	<input type="button" value="+" class="btn_increment-cart">
	                            </a>
	                        </td>
	                        <td class="remove-products">
	                            <a href="cart?action=removeCart&idBook=<%=cart.getBooks().getIdBook()%>"><i class="fa-regular fa-trash-can btn_remove"></i></a>
	                        </td>
	                    </tr>
	                  <%}%>
	                 <%} %>
                </table>
                <div class="buy-cart-products">
                    <div class="total-amount">Total : <span style="color: #e74c3c;font-weight: 600;"><%=total%></span>
                    </div>
                    <a href="order?action=orderCart" class="btn-buy">Pay</a>
                </div>
            </div>
        </div>
     <jsp:include page="/Common/footer.jsp"></jsp:include>
    </div>
    <!--<script src="<%=url%>/assets/js/Global.js"></script>!-->
</body>
</html>