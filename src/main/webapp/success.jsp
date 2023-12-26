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
<title>Order Success</title>
</head>
<style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }

        .container {
         	position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            max-width: 800px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        p {
            text-align: center;
            color: #666;
            font-size: 18px;
        }

        .button {
            display: inline-block;
            padding: 12px 24px;
            background-color: #4caf50;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
<body>
    <div class="container">
        <h1>Order Success!</h1>
        <p>Thank you for your order. Your order has been recorded.</p>
        <p>We will contact you as soon as possible.</p>
        <p><a href="<%=url%>/index.jsp" class="button">go back home</a></p>
    </div>
</body>
</html>