<%@page import="model.Category"%>
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
    <title>update category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/Admin/css/form.css">
</head>
<body>
<%
	Object obj = request.getAttribute("category");
	Category category = null;
	if(obj!=null){
		category= (Category)obj;
	}
	String code = category.getCode();
	code = code.equals("null")?"":code;
	String titleCategory = category.getTitleCategory();
	titleCategory = titleCategory.equals("null")?"":titleCategory;
	String description = category.getDescription();
	description = description.equals("null")?"":description;
%>
	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            Admin Update Category 
        </h1>
        <p class="form-desc">
            Wellcome Admin 
        </p>
        <form method ="post" action="../admin/category">
			<input type="hidden" name="action" value="updateCategory">
			<div class="form-group">
			    <label for="code" class="form-label">code</label>
			    <input type="text" class="form-control" id="code" name="code" value="<%=code%>" readonly>
			  </div>
			  <div class="form-group">
				<label for="titleCategory" class="form-label">titleCategory</label> 
				<input type="text" class="form-control" id="titleCategory" name="titleCategory" value="<%=titleCategory%>">
			  </div>
			  <div class="form-group">
			    <label for="description" class="form-label">description</label>
			    <textarea class="form-control" id="description" rows="5" name="description"><%=description%></textarea>
			  </div>
			  <button type="submit" class="btn btn-primary form-btn" >update</button>
		</form>	
        <a href="../admin/category?action=allCategory" class="btn btn-primary form-btn">back To</a>
    </div>
</body>
</html>