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
    <title>changePassword</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/login_register.css">
</head>
<body>
	<%  
		String err = request.getAttribute("error")+" ";
		err = err==null ? "" : err;
	%>
	<div class="bt-form-login-simple-1 mt-5">
        <h1 class="form-heading">
            change password
        </h1>
        <p class="form-desc">
            Wellcome BookStore 
			<h6 style="color:red"><%=err %></h6>
        </p>
        
        <form class="form" method="post" action ="users">
        	<input type="hidden" name="action" value="changePassword">
            <div class="form-group">
                <label for="currentPassword" class="form-label">current password</label>
		    	<input type="text" class="form-control" id="currentPassword" name="currentPassword">
            </div>
            <div class="form-group">
                <label for="newPassword" class="form-label">new password</label>
		    	<input type="password" class="form-control" id="newPassword" name="newPassword">
            </div>
            <div class="form-group">
                <label for="conPassword" class="form-label">con-password</label>
		    <input type="password" class="form-control" id="conPassword" name="conPassword">
            </div>
            <button type="submit" class="form-btn">
                change
            </button>
        </form>
    </div>
</body>
</html>