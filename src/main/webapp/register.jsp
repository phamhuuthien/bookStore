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
	String error = request.getAttribute("error")+"";
	error = error.equals("null")?"" : error;
	String fullName =   request.getAttribute("fullName")+"";
	fullName = fullName.equals("null")?"" : fullName ;
	String userName =   request.getAttribute("userName")+"";
	userName = userName.equals("null")?"" : userName ;
	String sex = 	request.getAttribute("sex")+"";
	sex = sex.equals("null")?"" : sex ;
	String address = 	request.getAttribute("address")+"";
	address = address.equals("null")?"" : address ;
	String deliveryAddress = 	request.getAttribute("deliveryAddress")+"";
	deliveryAddress = deliveryAddress.equals("null")?"" : deliveryAddress ;
	String dateOfBirth = 	request.getAttribute("dateOfBirth")+"";
	dateOfBirth = dateOfBirth.equals("null")?"" : dateOfBirth ;
	String email = 	request.getAttribute("email")+"";
	email = email.equals("null")?"" : email ;
	String receiveEmail = 	request.getAttribute("receiveEmail")+"";
	receiveEmail = receiveEmail.equals("null")?"" : receiveEmail ;
	%>
	<div class="bt-form-login-simple-1 my-5">
        <h1 class="form-heading">
            register
        </h1>
        <p class="form-desc">
            Wellcome BookStore 
        </p>
        <h1><%=error %></h1>
        <form method ="post" action="users">
        	<input type="hidden" name="action" value="register">
            <div class="form-group">
                <label for="fullName" class="form-label">fullName</label>
	    		<input type="text" class="form-control" id="fullName" name ="fullName" value="<%=fullName %>">
            </div>
            <div class="form-group">
                <label for="userName" class="form-label">userName</label>
	    		<input type="text" class="form-control" id="userName" name="userName" value="<%= userName %>">
            </div>
            <div class="form-group">
                <label for="password" class="form-label">password</label>
	    		<input type="password" class="form-control" id="password" name="password">	
            </div>
            <div class="form-group">
                <label for="conPassword" class="form-label">conPassword</label>
	    		<input type="password" class="form-control" id="conPassword" name="conPassword">
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
					<label for="dieuKhoan" class="form-label">ban co dong y voi dieu khoan cua cong ty khong <span class="red">*</span></label> 
					<input type="checkbox" id="dieuKhoan" class= "form-check-input" name="dieuKhoan" required="required" onchange="checkArticle()">
				</div>
				<div class="mb-3">
					<label for="receiveEmail" class="form-label">ban co dong y nhan email thong bao tu chung toi </label> 
					<input type="checkbox" id="receiveEmail" class= "form-check-input" name="receiveEmail" <%= receiveEmail!=null ?"checked" :"" %>)>
				</div>
            <button type="submit" class="btn btn-primary form-btn" disabled="disabled">register</button>
        </form>
    </div>
<script type="text/javascript">
	function checkArticle() {
	    // Assuming you want to target the first button element
	    const btnSubmit = document.getElementsByTagName("button")[0]
	    if (btnSubmit.disabled) {
	        btnSubmit.removeAttribute("disabled");
	    } else {
	        btnSubmit.setAttribute('disabled', true);
	    }
	}
</script>
</body>
</html>