<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home Admin</title>
	<%
	    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	%>
    <link href="<%=url %>/Admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=url %>/Admin/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
    <div id="wrapper">
        
        <!-- sideBar -->
        <jsp:include page="/Admin/Common/sidebar.jsp"></jsp:include>
       
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
            
                <!-- header -->
                
                	<jsp:include page="/Admin/Common/header.jsp"></jsp:include>
                	
                <div class="container">
                    <h1>hello admin</h1>
                </div>
            </div>
        </div>
    </div>
     <!-- Bootstrap core JavaScript-->
     <script src="<%=url %>/Admin/vendor/jquery/jquery.min.js"></script>
     <script src="<%=url %>/Admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 
     <!-- Core plugin JavaScript-->
     <script src="<%=url %>/Admin/vendor/jquery-easing/jquery.easing.min.js"></script>
 
     <!-- Custom scripts for all pages-->
     <script src="<%=url %>/Admin/js/sb-admin-2.min.js"></script>
 
     <!-- Page level plugins -->
     <script src="<%=url %>/Admin/vendor/chart.js/Chart.min.js"></script>
 
     <!-- Page level custom scripts -->
     <script src="<%=url %>/Admin/js/demo/chart-area-demo.js"></script>
     <script src="<%=url %>/Admin/js/demo/chart-pie-demo.js"></script>
      <!-- Page level plugins -->
    <script src="<%=url %>/Admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="<%=url %>/Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=url %>/Admin/js/demo/datatables-demo.js"></script>
</body>
</html>