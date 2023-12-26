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
    <title>insert Author</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/Admin/css/form.css">
</head>
<body>

	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            Admin Add Author 
        </h1>
        <p class="form-desc">
            Wellcome Admin 
        </p>
        <form method ="post" action="../admin/author">
			<input type="hidden" name="action" value="insertAuthor">
			<div class="form-group">
			    <label for="authorName" class="form-label">authorName</label>
			    <input type="text" class="form-control" id="authorName" name="authorName">
			  </div>
			  <div class="form-group">
			    <label for="authorDes" class="form-label">authorDes</label>
			    <textarea class="form-control" id="authorDes" rows="5" name="authorDes"></textarea>
			  </div>
			  <div class="form-group">
				<label for="authorDate" class="form-label">authorDate</label> 
				<input type="date" class="form-control" id="authorDate" name="authorDate">
			  </div>
			  <button type="submit" class="btn btn-primary form-btn" >add</button>
		</form>	
         <a href="../admin/author?action=allAuthor" class="btn btn-primary form-btn">back To</a>
    </div>
</body>
</html>