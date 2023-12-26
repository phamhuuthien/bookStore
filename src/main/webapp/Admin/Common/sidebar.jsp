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
<title>sidebar</title>
</head>
<body>
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-text mx-3">Admin BookStore</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="<%=url%>/Admin/index.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Manage
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#bookManagement"
                    aria-expanded="true" aria-controls="bookManagement">
                    <i class="fas fa-book"></i>
                    <span>Book Management</span>
                </a>
                <div id="bookManagement" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Book Management</h6>
                        <a class="collapse-item" href="<%=url%>/admin/book?action=allBook">update-delete Book</a>
                        <a class="collapse-item" href="<%=url%>/Admin/insertBook.jsp">Add Book</a>
                    </div>
                </div>
            </li>
			
			<li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#authorManagement"
                    aria-expanded="true" aria-controls="authorManagement">
                    <i class="fas fa-at"></i>
                    <span>Author Management</span>
                </a>
                <div id="authorManagement" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Author Management</h6>
                        <a class="collapse-item" href="<%=url%>/admin/author?action=allAuthor">update-delete Author</a>
                        <a class="collapse-item" href="<%=url%>/Admin/insertAuthor.jsp">Add Author</a>
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#categoryManagement"
                    aria-expanded="true" aria-controls="categoryManagement">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Category Management</span>
                </a>
                <div id="categoryManagement" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">category Management</h6>
                        <a class="collapse-item" href="<%=url%>/admin/category?action=allCategory">update-delete Category</a>
                        <a class="collapse-item" href="<%=url%>/Admin/insertCategory.jsp">Add Category</a>
                    </div>
                </div>
            </li>
			
			
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#userManagement"
                    aria-expanded="true" aria-controls="userManagement">
                    <i class="fas fa-user"></i>
                    <span>User Management</span>
                </a>
                <div id="userManagement" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">User Management</h6>
                        <a class="collapse-item" href="<%=url%>/admin/user?action=allUser">All User</a>
                        <a class="collapse-item" href="<%=url%>/admin/user?action=allUser">Update User</a>
                        <a class="collapse-item" href="<%=url%>/admin/user?action=allUser">Delete User</a>
                    </div>
                </div>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Orders
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>orders</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">order</h6>
                        <a class="collapse-item" href="<%=url%>/admin/order?action=orderApproval">Order awaiting approval</a>
                        <a class="collapse-item" href="<%=url%>/admin/order?action=orderDelivery&status=failed">Delivery order failed</a>
                        <a class="collapse-item" href="<%=url%>/admin/order?action=orderDelivery&status=completed">Order has been completed</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#chart"
                    aria-expanded="true" aria-controls="chart">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span>
                </a>
                <div id="chart" class="collapse" aria-labelledby="headingPages" data-parent="#chart">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Charts</h6>
                        <a class="collapse-item" href="<%=url%>/admin/charts?action=area">revenue growth rate</a>
                        <a class="collapse-item" href="<%=url%>/admin/charts?action=donut">number of books sold</a>
                        <a class="collapse-item" href="<%=url%>/admin/charts?action=bar">revenue each month</a>
                    </div>
                </div>
            </li>
            
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="<%=url%>/admin/adminAccount?action=logout">
                    <span>LogOut </span>
            		<i class="fas fa-sign-out-alt"></i>
                </a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
</body>
</html>