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
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/login_register.css">
</head>
<body>
	<%  
	String err = request.getAttribute("error")+" ";
	err = err.equals("null") ? err : "";
	%>
	<div class="bt-form-login-simple-1 mt-5">
        <h1 class="form-heading">
            login
        </h1>
        <p class="form-desc">
            Wellcome BookStore 
        </p>
        
		<h1><%=err %></h1>
        <form class="form" method="post" action ="users">
        	<input type="hidden" name="action" value="login">
            <div class="form-group">
                <label for="exampleInputEmail1" class="form-label">userName</label>
		    	<input type="text" class="form-control" id="exampleInputEmail1" name="userName">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
            </div>
            <div class="form-meta">
                <div class="form-remember">
                    <input
                        type="checkbox"
                        name="remember-account"
                        id="remember-account"
                    />
                    <label for="remember-account">
                        Remember for 30 days
                    </label>
                </div>
                <a href="<%=url%>/mail.jsp" class="form-link">
                    Forgot Password
                </a>
            </div>
            <button type="submit" class="form-btn">
                Login
            </button>
        </form>
        <div class="form-option">
            Dont&#x27;t have am account?
            <a href="#">Sign up for free</a>
        </div>
    </div>
</body>
</html>