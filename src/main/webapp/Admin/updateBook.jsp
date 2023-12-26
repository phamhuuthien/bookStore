<%@page import="model.Category"%>
<%@page import="model.Author"%>
<%@page import="java.util.ArrayList"%>
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
    <title>update Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/Admin/css/form.css">
</head>
<body>
	<%
	ArrayList<Author> listAuthor = (ArrayList<Author>)request.getAttribute("listAuthor");
	ArrayList<Category> listCategory = (ArrayList<Category>)request.getAttribute("listCategory");
	String error = request.getAttribute("error")+"";
	error = error.equals("null")?"" : error;
	Object obj = request.getAttribute("book");
	Books book = null;
	book = (Books)obj;
	String title = book.getTitle();
	title = title.equals("null")?"" : title ;
	String author = book.getAuthor().getAuthorName();
	author = author.equals("null")?"" : author ;
	String publicYear = book.getPublicYear();
	publicYear = publicYear.equals("null")?"" : publicYear ;
	double price =  book.getPrice();
	price = (price==0)?0 : price ;
	int available = book.getAvailable();
	available = available==0?0 : available ;
	String description = book.getDescription();
	description = description.equals("null")?"" : description ;
	String category = book.getCategory().getTitleCategory();
	category = category.equals("null")?"" : category ;
	String fileName = book.getFileName();
	fileName = fileName.equals("null")?"" : fileName ;
	double star = book.getStar();
	star = star==0?0 : star ;
%>
	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            Admin Update Book 
        </h1>
        <p class="form-desc">
            Wellcome Admin 
        </p>
        <h1><%=error %></h1>
        <form method ="post" action="book">
			<input type="hidden" name="action" value="updateBook">
			<input type="hidden" name="idBook" value="<%=book.getIdBook()%>">
			  <div class="form-group">
			    <label for="title" class="form-label">title</label>
			    <input type="text" class="form-control" id="title" name="title" value="<%=title%>">
			  </div>
			  <div class="form-group">
			    <label for="authorId" class="form-label">author</label>
			    <select class="form-select" aria-label="Default select example" id="authorId" name="authorId">
				  <option selected><%=author%></option>
				  <% for(Author authorItem : listAuthor){ %>
				  	<option value="<%=authorItem.getAuthorName()%>"><%=authorItem.getAuthorName()%></option>
				  <%}%>
				</select>
			  </div>
			  <div class="form-group">
			    <label for="publicYear" class="form-label">publicYear</label>
			    <input type="text" class="form-control" id="publicYear" name="publicYear" value="<%=publicYear%>">
			  </div>
			  <div class="form-group">
			    <label for="price" class="form-label">price</label>
			    <input type="text" class="form-control" id="price" name="price" value="<%=price%>">
			  </div>
			  <div class="form-group">
			    <label for="available" class="form-label">available</label>
			    <input type="text" class="form-control" id="available" name="available" value="<%=available%>">
			  </div>
			  <div class="form-group">
			    <label for="description" class="form-label">description</label>
			    <textarea class="form-control" id="description" rows="5" name="description" ><%=description%></textarea>
			  </div>
			  <div class="form-group">
			    <label for="code" class="form-label">category</label>
			    <select class="form-select" aria-label="Default select example" id="code" name="code">
				  <option selected><%=category%></option>
				  <% for(Category categoryItem : listCategory){ %>
				  	<option value="<%=categoryItem.getTitleCategory()%>"><%=categoryItem.getTitleCategory()%></option>
				  <%}%>
				</select>
			  </div>
			  <div class="form-group">
				<label for="fileName" class="form-label">fileName</label> 
				<input type="text" class="form-control" id="fileName" name="fileName" value="<%=fileName%>">
			  </div>
				<input type="hidden" class="form-control" id="star" name="star" value="<%=star%>">
			  <button type="submit" class="btn btn-primary form-btn" >Update</button>
		</form>	
         <a href="../admin/book?action=allBook" class="btn btn-primary form-btn">back To</a>
    </div>
</body>
</html>