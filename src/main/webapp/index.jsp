<%@page import="java.util.List"%>
<%@page import="database.BookDAO"%>
<%@page import="model.Books"%>
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
    <title>Home</title>   
</head>
<body>
<div id="wrapper">
        
        <jsp:include page="/Common/header.jsp"></jsp:include>
        
        <a href="#" id="btn-to-top"><i class="fa-solid fa-angle-up"></i></a>
        <div id="container">
            <div class="banner">
                <h1>Book store</h1>
            </div>
            <div class="bestseller">
                <h1>Best seller</h1>
                <div class="bestseller-content ">
                    <div class="container">
                        <div class="row">
                        	<% 
                        		BookDAO BookD = new BookDAO();
                        		ArrayList<Books> books = BookD.selectAllBestSeller();
                        		List<Books> listBook = books.subList(0, 4);
                        		for (Books book : listBook) {
                        	%>
                            <div class="col-md-3 col-sm-6 mt-3">
                                <div class="bt-card-hotel-5">
                                    <a href="#" class="card-image" title="easy template">
                                        <img
                                            src="<%=book.getFileName() %>"
                                            alt="easy template"
                                        />
                                    </a>
                                    <div class="card-body">
                                        <div class="card-body-header">
                                            <h3 class="card-title">
                                                <a href="#" class="card-title-link">
                                                    <%=book.getTitle() %>
                                                </a>
                                            </h3>
                                        </div>
                                        <div class="card-vote">
                                            <ul class="vote-list list-unstyled">
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                            </ul>
                                        </div>  
                                        <div class="card-meta">
                                            <div class="card-meta-right">
                                                <h4 class="card-price-current">
                                                    <%=book.getPrice() %>
                                                </h4>
                                            </div>
                                        </div>
                                        <div class="card-desc">
                                            <%=book.getDescription() %>
                                        </div>
                                        <div class="btn-action">
                                        	<div class="row">
		                                        <a class="card-button" href="cart?action=addCart&idBook=<%=book.getIdBook()%>">Add To Cart </a>
		                                        <a class="card-button mt-3" href="order?action=buy&idBook=<%=book.getIdBook()%>">Buy </a>	
									        </div>   
    									</div>
                                    </div>
                                </div>
                            </div>
                        	<%} %>
                        </div>
                      </div>
                </div>
                <a href="products?action=more&status=bestseller" class="more">Xem thêm...</a>
            </div>
            <!-- <div class="sale">
                <h1>Sale <span>60%</span></h1>
                <i class="fa-solid fa-chevron-left prev " data-status="sale"></i>
                <div class="sale-content">

                </div>
                <i class="fa-solid fa-chevron-right next" data-status="sale"></i>
                <a href="./src/more.html?status=sale" class="more">Xem thêm...</a>
            </div> -->
            <div class="favourite">
                <h1> <span>Favourite</span> </h1>
                <div class="favourite-content">
                    <!-- nội dung  -->
                    <div class="container">
                        <div class="row">
                            <% 
                        		ArrayList<Books> booksFavourite = BookD.selectAllFavourite();
                        		List<Books> listBookFavourite = booksFavourite.subList(0, 4);
                        		for (Books book : listBookFavourite) {
                        	%>
                            <div class="col-md-3 col-sm-6 mt-3">
                                <div class="bt-card-hotel-5">
                                    <a href="#" class="card-image" title="easy template">
                                        <img
                                            src="<%=book.getFileName() %>"
                                            alt="easy template"
                                        />
                                    </a>
                                    <div class="card-body">
                                        <div class="card-body-header">
                                            <h3 class="card-title">
                                                <a href="#" class="card-title-link">
                                                    <%=book.getTitle() %>
                                                </a>
                                            </h3>
                                        </div>
                                        <div class="card-vote">
                                            <ul class="vote-list list-unstyled">
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                            </ul>
                                        </div>  
                                        <div class="card-meta">
                                            <div class="card-meta-right">
                                                <h4 class="card-price-current">
                                                    <%=book.getPrice() %>
                                                </h4>
                                            </div>
                                        </div>
                                        <div class="card-desc">
                                            <%=book.getDescription() %>
                                        </div>
                                        <div class="btn-action">
                                        	<div class="row">
		                                        <a class="card-button" href="cart?action=addCart&idBook=<%=book.getIdBook()%>">Add To Cart </a>
		                                        <a class="card-button mt-3" href="order?action=buy&idBook=<%=book.getIdBook()%>">Buy </a>	
									        </div>   
    									</div>
                                    </div>
                                </div>
                            </div>
                        	<%} %>
                        </div>
                    </div>
                    <!-- end nội dung -->
                </div>
                <a href="products?action=more&status=favourite" class="more">Xem thêm...</a>
            </div>
        </div>
        <div class="faq mt-5">
                <div class="faq-header text-center text-white mb-5">
                    <h1>FAQs</h1>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Tenetur fugiat deleniti assumenda esse soluta architecto?</p>
                </div>
                <div class="accordion container" id="accordionExample">
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                          Accordion Item #1
                        </button>
                      </h2>
                      <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                          <strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                          Accordion Item #2
                        </button>
                      </h2>
                      <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                          <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                        </div>
                      </div>
                    </div>
                    <div class="accordion-item">
                      <h2 class="accordion-header" id="headingThree">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                          Accordion Item #3
                        </button>
                      </h2>
                      <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                          <strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
                        </div>
                      </div>
                    </div>
                </div>
        </div>
        <div class="main-loader">
            <div id="loader"></div>
        </div>
         <jsp:include page="/Common/footer.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="<%=url%>/assets/js/Global.js"></script>
</body>
</html>