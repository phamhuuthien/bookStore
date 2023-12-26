<%@page import="model.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        body {
            background-image: url('https://cdn.pixabay.com/photo/2017/08/06/22/01/books-2596809_1280.jpg');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
        }

        .author-container {
        	position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            max-width: 600px;
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            font-size: 28px;
            margin-bottom: 20px;
            text-transform: uppercase;
            font-family: 'Whisper';
        }

        .author-info {
            font-size: 18px;
            line-height: 1.6;
        }

        .author-info p {
            margin-bottom: 12px;
        }

        .author-info p:first-child {
            margin-top: 0;
        }

        .author-info p:last-child {
            margin-bottom: 0;
        }

        .author-info p:nth-child(odd) {
            color: #444;
        }

        .author-info p:nth-child(even) {
            color: #666;
        }

        .author-info p span {
            font-weight: bold;
            color: #333;
        }

        .author-info p:first-child span {
            font-size: 20px;
        }

        .author-info p:last-child span {
            font-size: 16px;
        }
    </style>
<body>
<%
	Author author = (Author)request.getAttribute("author");
%>
	<jsp:include page="/Common/header.jsp"></jsp:include>
    <div class="author-container">
        <h1><%=author.getAuthorName() %></h1>
        <div class="author-info">
            <p><span><%=author.getAuthorName() %>:</span></p>
            <p><%=author.getAuthorDes() %></p>
            <p><span>Date:</span> <%=author.getAuthorDate() %></p>
        </div>
    </div>

</body>
</html>