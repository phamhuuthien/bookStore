<%@page import="model.Cart"%>
<%@page import="model.Users"%>
<%@page import="model.Author"%>
<%@page import="database.authorDAO"%>
<%@page import="database.categoryDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
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
    <meta name="description" content="BookStore nơi mang lại vẻ đẹp cho bạn">
    <meta property="og:image"
        content="https://media.istockphoto.com/id/533833660/vi/anh/qu%E1%BA%A7n-%C3%A1o-tr%C3%AAn-m%C3%B3c-treo-t%E1%BA%A1i-c%E1%BB%ADa-h%C3%A0ng-hi%E1%BB%87n-%C4%91%E1%BA%A1i.jpg?s=612x612&w=0&k=20&c=N_aU_gorDvAGkfEcZPf9iRlk9sCMdWnKR6c1kiioV5U=">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/Global.css">
    <link rel="stylesheet" href="<%=url%>/assets/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <title>header</title>  
</head>
<body>
	<header>
            <div class="main-header">
                <div class="menu-icon"><i class="fa-solid fa-bars menu"></i></div>
                <nav>
                    <i class="fa-solid fa-x close-menu"></i>
                    <li id="active"><a href="./index.jsp">Home</a></li>
                    <li class="menClothes">
                        <a href="#">Category</a>
                        <i class="fa-solid fa-angle-down"></i>
                        <ul class="menClothes-child">
                        	<%	
                        		categoryDAO categoryD = new categoryDAO();
                        		ArrayList<Category> categoryList = categoryD.selectAll();
                        		for(Category category : categoryList){
                        	%>
                            	<li><a href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=1"><%=category.getTitleCategory()%></a></li>
                            <%} %>
                        </ul>
                    </li>
                    <li class="womenClothes">
                        <a href="#">Author</a>
                        <i class="fa-solid fa-angle-down"></i>
                        <ul class="womenClothes-child">
                        	<% 
                        		authorDAO authorD = new authorDAO();
	                        	ArrayList<Author> authorList = authorD.selectAll();
	                    		for(Author author : authorList){
                        	%>
                            	<li> <a href="author?action=author&authorId=<%=author.getAuthorId()%>"><%=author.getAuthorName()%></a></li>
                            <%} %>
                        </ul>
                    </li>
                    <!-- <li class="accessory">
                        <a href="#"></a>
                        <i class="fa-solid fa-angle-down"></i>
                        <ul class="accessory-child">
                            <li> <a href="/src/clothes.html">Phụ kiện Nam</a> </li>
                            <li> <a href="/src/clothes.html">Phụ kiện Nữ</a> </li>
                        </ul>
                    </li> -->
                </nav>
                <div class="logo"></div>
                <div class="header-main-right">
                    <form action="products">
        				<input type="hidden" name="action" value="search">
	                    <div class="search">
		                        <input type="text" class="search-input" placeholder="search" name="search" autocomplete="off"> 
		                        <i class="fa-solid fa-magnifying-glass btn-search"></i>
		                        <div class="suggest">
		                            <h6>Most searched products</h6>
		                            <ul>
		                                <li><a href="">Religion</a></li>
		                                <li><a href="">Romance</a></li>
		                                <li><a href="">Jane Austen</a></li>
		                                <li><a href="">Childrens</a></li>
		                                <li><a href="">Virginia</a></li>
		                            </ul>
		                        </div>
	                    </div>
                    </form>
                    <div class="card-controls">
                        <div class="notice">
                            <img src="./assets/icon/addcart.png" alt="">
                            <span>added to cart</span>
                        </div>
                        <div class="profile">
                            <img src="./assets/icon/user.png" alt="">
                            <%
                            	Object obj = session.getAttribute("user");
                            	Users user = null;
                            	if(obj!=null){
                            		user = (Users)obj;
                            	}
                            	if(user!=null){ %>
                            		<ul class="profile-child">
	                                    <li> <a href="<%=url%>/updateInfo.jsp">changeInfo</a> </li>
	                                    <li> <a href="<%=url%>/changePassword.jsp">changePassword</a> </li>
	                                    <li> <a href="users?action=myOrder">My order</a> </li>
	                                    <li> <a href="users?action=logout">logOut</a> </li>
                                	</ul>
                            	<%}else{ %>
	                            <ul class="profile-child">
	                                <li> <a href="<%=url%>/login.jsp">Login</a> </li>
	                                <li> <a href="<%=url%>/register.jsp">Register</a> </li>
	                            </ul>
	                            <%} %>
                        </div>
                        <%	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); 
                        	int total = 0;
                        	if(cart_list==null){
                        		total=0;
                        	}else {
                        		total = cart_list.size();
                        	}
                        %>
                        <a href="<%=url%>/cart.jsp" class="cart" data-count="<%=total%>"><img src="<%=url%>/assets/icon/cart.png" alt=""></a>
                    </div>
                </div>
            </div>
        </header>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="<%=url%>/assets/js/Global.js"></script>
</body>
</html>