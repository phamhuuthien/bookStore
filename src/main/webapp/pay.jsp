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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=url%>/assets/css/pay.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <title>pay</title>
</head>
<body>

<div id="wrapper">
      <jsp:include page="/Common/header.jsp"></jsp:include>
      <a href="#" id="btn-to-top"><i class="fa-solid fa-angle-up"></i></a>
        <div class="main-loader">
            <div id="loader"></div>
       </div>
	<div id="pay">
        <div class="card-left">
            <div class="main-left">
                <h3>Thông tin thanh toán</h3>
                <div class="address-available">
                    <h3>Sử dụng địa chỉ của bạn <span style="font-size: 10px;text-transform: none;">(Bấm để chọn)</span>
                    </h3>
                    <div class="main-address-pay">
                        <p class="name-user">Họ và Tên: </p>
                        <p class="email-user">Email: </p>	
                        <p class="phone-user">SĐT: </p>
                        <p class="address-user">Địa chỉ: </p>
                    </div>
                    <a href="/src/user.html?to=address" class="add-address"><i class="fa-solid fa-circle-plus"></i>Thêm
                        địa chỉ giao hàng</a>
                </div>
                <form>
                    <input type="text" class="name" placeholder="Họ và Tên">
                    <input type="text" class="phone" placeholder="Điện thoại">
                    <input type="text" class="address" placeholder="Địa chỉ">
                </form>
                <div class="control">
                    <a href="<%=url%>/cart.jsp" class="back-cart">
                        <i class="fa-solid fa-chevron-left"></i> Trở lại giỏ hàng</a>
                    <div class="method-payment">
                        <select id="payment">
                            <option>Thanh toán khi nhận hàng</option>
                            <option>Thanh toán qua ngân hàng</option>
                        </select>
                        <button class="btn-pay" type="submit">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-right">
            <div class="wrapper-right">
                <h2>Đơn hàng <span>(0 sản phẩm)</span></h2>
                <div class="main-right">
                    <div class="item-products">
                        <div class="item-img" data-quantity="1">
                            <img src=""
                                alt="">
                        </div>
                        <div class="title-products">
                            <p class="name">Chân váy xòe xếp ly</p>
                            <p class="color-size">Trắng / Size M</p>
                        </div>
                        <p class="price">200.000đ</p>
                    </div> 
                </div>
                <div class="total">
                    <p>Tổng tiền <span>(Lưu ý: Đây chỉ là tổng tiền sản phẩm chưa tính phí vận chuyển)</span></p>
                    <p class="total-payment">0đ</p>
                </div>
            </div>
            <div class="show-product"><i class="fa-solid fa-chevron-down"></i></div>
        </div>
        <div class="notice-success">
            <div class="notice">
                <i class="fa-solid fa-xmark close"></i>
                <h3>Cảm ơn bạn đã mua hàng</h3>
                <p>Chúng tôi sẽ gọi điện cho bạn để xác nhận đơn hàng</p>
            </div>
        </div>
    </div>
    <jsp:include page="/Common/footer.jsp"></jsp:include>
 </div>
 <script src="<%=url%>/assets/js/Global.js"></script>
</body>
</html>