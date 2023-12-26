<%@page import="database.categoryDAO"%>
<%@page import="model.Category"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>more</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/more.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
</head>
<body>
<%
	ArrayList<Books> books = (ArrayList<Books>)request.getAttribute("more");
	String status = request.getAttribute("nameStatus")+"";
	categoryDAO categoryD = new categoryDAO();
	Category categorySearch = new Category();
	categorySearch.setTitleCategory(status);
	Category category = categoryD.selectByTitleCategory(categorySearch);
%>
	<div id="wrapper">
        <jsp:include page="/Common/header.jsp"></jsp:include>
        <div class="container" style="margin-top:7rem;">
            <div class="header_top">
                <h1><%=status%></h1>
                <p class="description"></p>
            </div>
            <div class="main-content">
                <div class="row">
                <% for(Books book : books){ %>
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
            <div aria-label="Page navigation example" class="mt-5">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=3">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=1">1</a></li>
                  <li class="page-item"><a class="page-link" href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=2">2</a></li>
                  <li class="page-item"><a class="page-link" href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=3">3</a></li>
                  <li class="page-item"><a class="page-link" href="products?action=more&status=category&categoryName=<%=category.getTitleCategory()%>&code=<%=category.getCode()%>&page=1">Next</a></li>
                </ul>
            </div>
        </div>
        <jsp:include page="/Common/footer.jsp"></jsp:include>
    </div>
</body>
</html>