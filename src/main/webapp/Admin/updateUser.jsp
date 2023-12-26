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
    <title>update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/Admin/css/form.css">
</head>
<body>
	<%
	String error = request.getAttribute("error")+"";
	error = error.equals("null")?"" : error;
	
	Object obj = request.getAttribute("user");
	Users user = null;
	if(obj!=null){
		user =(Users)obj; 
	}
	
	String idUser = user.getUserId();
	String fullName =   user.getFullName();
	fullName = fullName.equals("null")?"" : fullName ;
	String userName =   user.getUserName();
	userName = userName.equals("null")?"" : userName ;
	String sex = 	user.getSex();
	sex = sex.equals("null")?"" : sex ;
	String address = 	user.getAddress();
	address = address.equals("null")?"" : address ;
	Date dateOfBirth = 	user.getDateOfBirth();
	dateOfBirth = dateOfBirth.equals("null")? null : dateOfBirth ;
	%>
	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            Admin Update User 
        </h1>
        <p class="form-desc">
            Wellcome Admin 
        </p>
        <h1><%=error %></h1>
        <form method ="post" action="user">
        	<input type="hidden" name="action" value="updateUser">
        	<input type="hidden" name="idUser" value="<%=idUser%>">
            <div class="form-group">
                <label for="fullName" class="form-label">fullName</label>
	    		<input type="text" class="form-control" id="fullName" name ="fullName" value="<%=fullName %>">
            </div>
            <div class="form-group">
                <label for="userName" class="form-label">userName</label>
	    		<input type="text" class="form-control" id="userName" name="userName" value="<%= userName %>">
            </div>
            <div class="form-group">
                <label for="conPassword" class="form-label">sex</label>
			    <select class="form-select" aria-label="Default select example" name="sex">
				  <option selected>-----------</option>
				  <option value="male" <%= sex.equals("male")?"selected":" " %> >male</option>
				  <option value="female" <%= sex.equals("female")?"selected":" " %>>female</option>
				  <option value="other" <%= sex.equals("other")?"selected":" " %>>other</option>
				</select>
            </div>
            <div class="form-group">
                <label for="address" class="form-label">address</label>
	    		<input type="text" class="form-control" id="address" name="address" value="<%=address%>">
            </div>

            <button type="submit" class="btn btn-primary form-btn">update</button>
        </form>
         <a href="../admin/user?action=allUser" class="btn btn-primary form-btn">back To</a>
    </div>
</body>
</html>