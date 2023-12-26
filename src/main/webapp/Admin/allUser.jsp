<%@page import="model.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>All users</title>
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
    <!-- Custom styles for this page -->
    <link href="<%=url %>/Admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body id="page-top">

<%
	Users userRoleAdmin = (Users)session.getAttribute("admin");
   	if(userRoleAdmin==null){
   	%>
   	<h1>not permistion</h1>
   	<%}else{ %>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        	<jsp:include page="/Admin/Common/sidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                	<jsp:include page="/Admin/Common/header.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">All Book</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>index</th>
                                            <th>fullName</th>
                                            <th>userName</th>
                                            <th>sex</th>
                                            <th>date of birth</th>
                                            <th>address</th>
                                            <th>email</th>
                                            <th>receiveEmail</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                        	<th>index</th>
                                            <th>fullName</th>
                                            <th>userName</th>
                                            <th>sex</th>
                                            <th>date of birth</th>
                                            <th>address</th>
                                            <th>email</th>
                                            <th>receiveEmail</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <%
	                                    ArrayList<Users> listUser = (ArrayList<Users>) request.getAttribute("listUser");
                                    	int i=0;
	            	                    for (Users user : listUser) {
	            	                    	i++;
                                    %>
                                        <tr>
                                        	<td><%=i%></td>
                                            <td><%=user.getFullName()%></td>
                                            <td><%=user.getUserName()%></td>
                                            <td><%=user.getSex()%></td>
                                            <td><%=user.getDateOfBirth()%></td>
                                            <td><%=user.getAddress()%></td>
                                            <td><%=user.getEmail()%></td>
                                            <td><%=user.getReceiveEmail()==true ? "yes" : "no" %></td>
                                            <td>
                                            	<a href="user?action=updateOrDelete&idUser=<%=user.getUserId()%>&status=update" class="update-button">Update</a>
												<a href="user?action=updateOrDelete&idUser=<%=user.getUserId()%>&status=delete" class="delete-button">Delete</a>
                                            </td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2023</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <%} %>

    <!-- Bootstrap core JavaScript-->
    <script src="<%=url %>/Admin/vendor/jquery/jquery.min.js"></script>
    <script src="<%=url %>/Admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=url %>/Admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=url %>/Admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="<%=url %>/Admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="<%=url %>/Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=url %>/Admin/js/demo/datatables-demo.js"></script>

</body>
</html>