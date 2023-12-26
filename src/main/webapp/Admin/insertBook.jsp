<%@page import="database.categoryDAO"%>
<%@page import="database.authorDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Author"%>
<%@page import="model.Books"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Users"%>
<%@page import="org.apache.catalina.User"%>
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
    <title>insertBook</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/Admin/css/form.css">
</head>
<body>
	<%
		authorDAO authorD = new authorDAO();
		ArrayList<Author> listAuthor = authorD.selectAll();
		categoryDAO categoryD = new categoryDAO();
		ArrayList<Category> listCategory = categoryD.selectAll();
	%>

	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            Admin Add Book 
        </h1>
        <p class="form-desc">
            Wellcome Admin 
        </p>
        <form method ="post" action="../admin/book">
			<input type="hidden" name="action" value="insertBook">
			<input type="hidden" name="idBook"">
			  <div class="form-group">
			    <label for="title" class="form-label">title</label>
			    <input type="text" class="form-control" id="title" name="title" ">
			  </div>
			  <div class="form-group">
			    <label for="authorId" class="form-label">author</label>
			    <select class="form-select" aria-label="Default select example" id="authorId" name="authorId">
				  <option selected>-------</option>
				  <% for(Author authorItem : listAuthor){ %>
				  	<option value="<%=authorItem.getAuthorId()%>"><%=authorItem.getAuthorName()%></option>
				  <%}%>
				</select>
			  </div>
			  <div class="form-group">
			    <label for="publicYear" class="form-label">publicYear</label>
			    <input type="text" class="form-control" id="publicYear" name="publicYear" >
			  </div>
			  <div class="form-group">
			    <label for="price" class="form-label">price</label>
			    <input type="text" class="form-control" id="price" name="price">
			  </div>
			  <div class="form-group">
			    <label for="available" class="form-label">available</label>
			    <input type="text" class="form-control" id="available" name="available">
			  </div>
			  <div class="form-group">
			    <label for="description" class="form-label">description</label>
			    <textarea class="form-control" id="description" rows="5" name="description" ></textarea>
			  </div>
			  <div class="form-group">
			    <label for="code" class="form-label">category</label>
			    <select class="form-select" aria-label="Default select example" id="code" name="code">
				  <option selected>-----------</option>
				  <% for(Category categoryItem : listCategory){ %>
				  	<option value="<%=categoryItem.getCode()%>"><%=categoryItem.getTitleCategory()%></option>
				  <%}%>
				</select>
			  </div>
			  <div class="form-group">
				<label for="fileName" class="form-label">fileName</label> 
				<input type="text" class="form-control" id="fileName" name="fileName" >
			  </div>
				<input type="hidden" class="form-control" id="star" name="star">
			  <button type="submit" class="btn btn-primary form-btn" >add</button>
		</form>	
         <a href="../admin/book?action=allBook" class="btn btn-primary form-btn">back To</a>
    </div>
</body>
</html>