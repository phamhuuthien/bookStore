<%@page import="model.Order_detail"%>
<%@page import="model.Order"%>
<%@page import="model.Books"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Status Order</title>
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
	
	ArrayList<Order> orderList = (ArrayList<Order>)(request.getAttribute("orderList"));
    int i=0;
%>
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
                                        	<th scope="col">#</th>
								          <th scope="col">info Order</th>
									      <th scope="col">status</th>
									      <th scope="col">receiving address</th>
									      <th scope="col">dilivery Date</th>
									      <th scope="col">total</th>
									      <th scope="col">action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                        <th scope="col">#</th>
								          <th scope="col">info Order</th>
									      <th scope="col">status</th>
									      <th scope="col">receiving address</th>
									      <th scope="col">dilivery Date</th>
									      <th scope="col">total</th>
									      <th scope="col">action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <% for (Order order: orderList){ i++; %>
									    <tr>
									    	<td><%=i %></td>
									      <td>
									      	<% ArrayList<Order_detail> orderListDetail = (ArrayList<Order_detail>)(request.getAttribute("orderDetail"+i)); 
									      		for(Order_detail orderDetail : orderListDetail){
									      	%>
										      	<div class="mb-3 row">
										      		<div class="col-4">
											      		<img alt="" src="<%=orderDetail.getBook().getFileName() %>" style=" width: 200px;
																															height: 200px;
																															object-fit: contain;">
										      		</div>
										      		<div class="col-8">
												      	<p>name product : <%=orderDetail.getBook().getTitle() %></p>
												      	<p>price : <%=orderDetail.getBook().getPrice() %></p>
												      	<p>quantity : <%=orderDetail.getQuality()%></p>			      		
										      		</div>
										      	</div>
									      	<%} %>
									      </td>
									      <td><%=order.getOrderStatus() %></td>
									      <td><%=order.getReceivingAddress() %></td>
									      <td>NUll</td>
									      <td><%=order.getTotal()%></td>
									      <td>
									      	<div class="mb-3">
									      		<a href="order?action=orderApprovalUpdate&idOrder=<%=order.getOrderId()%>" class="btn btn-primary">Approval</a>									      	
									      	</div>
									      	<div>
										      	<a href="order?action=orderFailedUpdate&idOrder=<%=order.getOrderId()%>" class="btn btn-primary">Cancel Order</a>
									      	</div>
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

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
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
    <script src="<%=url %>/Admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="<%=url %>/Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=url %>/Admin/js/demo/datatables-demo.js"></script>

</body>
</html>