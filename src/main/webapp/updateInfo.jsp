<%@page import="model.Users"%>
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
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/login_register.css">
</head>
<body>
	<%
	Object obj = session.getAttribute("user");
	Users user = null;
	String error = request.getAttribute("error")+"";
	error = error.equals("null")?"" : error;
	if(obj!=null){
		user = (Users)obj;
	}
	if(user == null){%>
	<h1>please login</h1>
	<%}else{ %>
		<%
			String fullName = user.getFullName();
			fullName = fullName==null?"" : fullName ;
			String sex = user.getSex();
			sex = sex==null?"" : sex ;
			String address = user.getAddress();
			address = address==null?"" : address ;
			String deliveryAddress = user.getDeliveryAddress();
			deliveryAddress = deliveryAddress==null?"" : deliveryAddress ;
			String dateOfBirth = user.getDateOfBirth().toString();
			dateOfBirth = dateOfBirth==null?"" : dateOfBirth ;
			String email = user.getEmail();
			email = email==null?"" : email ;
			boolean receiveEmail = user.getReceiveEmail();
		%>
		<div class="bt-form-login-simple-1 my-5">
	        <h1 class="form-heading">
	            updateInfo
	        </h1>
	        <p class="form-desc">
	            Wellcome BookStore 
	        </p>
	        <h1><%=error %></h1>
	        <form method ="post" action="users">
	        	<input type="hidden" name="action" value="updateInfo">
	            <div class="form-group">
	                <label for="fullName" class="form-label">fullName</label>
		    		<input type="text" class="form-control" id="fullName" name ="fullName" value="<%=fullName %>">
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
	            <div class="form-group">
	                <label for="deliveryAddress" class="form-label">deliveryAddress</label>
		    		<input type="text" class="form-control" id="deliveryAddress" name="deliveryAddress" value="<%=deliveryAddress%>">
	            </div>
	
	            <div class="form-group">
	                <label for="dateOfBirth" class="form-label">dateOfBirth</label> 
					<input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" value="<%=dateOfBirth%>">
	            </div>
	            <div class="form-group">
				    <label for="email" class="form-label">email</label>
				    <input type="email" class="form-control" id="email" name="email" value="<%=email%>">
			  	</div>
				  <h3>option</h3>
					<div class="mb-3">
						<label for="receiveEmail" class="form-label">ban co dong y nhan email thong bao tu chung toi </label> 
						<input type="checkbox" id="receiveEmail" class= "form-check-input" name="receiveEmail" <%= (receiveEmail==true)?"checked" :"" %>>
					</div>
	            <button type="submit" class="btn btn-primary form-btn">update</button>
	        </form>
	    </div>
    <%} %>
</body>
</html>