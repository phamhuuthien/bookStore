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
    <meta name="description" content="BookStore nơi mang lại vẻ đẹp cho bạn">
    <meta property="og:image"
        content="https://media.istockphoto.com/id/533833660/vi/anh/qu%E1%BA%A7n-%C3%A1o-tr%C3%AAn-m%C3%B3c-treo-t%E1%BA%A1i-c%E1%BB%ADa-h%C3%A0ng-hi%E1%BB%87n-%C4%91%E1%BA%A1i.jpg?s=612x612&w=0&k=20&c=N_aU_gorDvAGkfEcZPf9iRlk9sCMdWnKR6c1kiioV5U=">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=url%>/assets/css/Global.css">
    <link rel="stylesheet" href="<%=url%>/assets/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <title>footer</title>  
</head>
<body>
<footer>
	<div class="fui-footer-3">
            <div class="footer-category-wrap">
              <div class="footer-category">
                <a href="#" title="Fast UI" class="footer-logo">
                  <img
                    src="https://fastui.vercel.app/assets/images/logo.svg"
                    alt="Fast UI"
                  />
                  Fast UI
                </a>
                <p class="footer-desc">
                  High level experience in web design and development knowledge,
                  producing quality work.
                </p>
                <p class="copy-right">© 2022 FastUI™. All Rights Reserved.</p>
              </div>
              <div class="footer-category">
                <div class="footer-category-item">
                  <h3 class="footer-heading">Follow us</h3>
                  <ul class="social-list">
                    <li class="social-item">
                      <a href="#" title="social" class="social-link">
                        <svg
                          width="24"
                          height="25"
                          viewBox="0 0 24 25"
                          fill="none"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <circle cx="12" cy="12.168" r="12" fill="white" />
                          <path
                            d="M16.7273 4.16797H14.3471C13.295 4.16797 12.286 4.5894 11.5421 5.33954C10.7981 6.08969 10.3802 7.1071 10.3802 8.16797V10.568H8V13.768H10.3802V20.168H13.5537V13.768H15.9339L16.7273 10.568H13.5537V8.16797C13.5537 7.9558 13.6373 7.75231 13.7861 7.60228C13.9349 7.45225 14.1367 7.36797 14.3471 7.36797H16.7273V4.16797Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                        </svg>
                      </a>
                    </li>
                    <li class="social-item">
                      <a href="#" title="social" class="social-link">
                        <svg
                          width="24"
                          height="25"
                          viewBox="0 0 24 25"
                          fill="none"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <circle cx="12" cy="12.168" r="12" fill="white" />
                          <path
                            d="M19 5.16797L10 14.168"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                          <path
                            d="M19 5.16797L13.4 21.168L10.2 13.968L3 10.768L19 5.16797Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                        </svg>
                      </a>
                    </li>
                    <li class="social-item">
                      <a href="#" title="social" class="social-link">
                        <svg
                          width="24"
                          height="25"
                          viewBox="0 0 24 25"
                          fill="none"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <circle cx="12" cy="12.168" r="12" fill="white" />
                          <path
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M8.26748 5.16797C6.4629 5.16797 5 6.63087 5 8.43545V15.9704C5 17.775 6.4629 19.2379 8.26748 19.2379H15.8024C17.607 19.2379 19.0699 17.775 19.0699 15.9704V8.43545C19.0699 6.63087 17.607 5.16797 15.8024 5.16797H8.26748ZM4 8.43545C4 6.07858 5.91062 4.16797 8.26748 4.16797H15.8024C18.1593 4.16797 20.0699 6.07858 20.0699 8.43545V15.9704C20.0699 18.3273 18.1593 20.2379 15.8024 20.2379H8.26748C5.91062 20.2379 4 18.3273 4 15.9704V8.43545ZM12.4364 9.6834C11.9134 9.60583 11.3792 9.69517 10.9098 9.93872C10.4404 10.1823 10.0598 10.5676 9.82209 11.0399C9.58436 11.5123 9.50161 12.0475 9.58562 12.5696C9.66962 13.0916 9.91611 13.5739 10.29 13.9478C10.6639 14.3217 11.1462 14.5682 11.6683 14.6522C12.1903 14.7362 12.7256 14.6535 13.1979 14.4158C13.6703 14.178 14.0556 13.7974 14.2991 13.3281C14.5427 12.8587 14.632 12.3245 14.5545 11.8014C14.4753 11.2679 14.2267 10.7739 13.8453 10.3925C13.4639 10.0111 12.97 9.76251 12.4364 9.6834ZM10.4492 9.05109C11.1053 8.71068 11.852 8.58579 12.5831 8.69421C13.3289 8.8048 14.0193 9.15232 14.5524 9.68542C15.0855 10.2185 15.4331 10.909 15.5436 11.6547C15.6521 12.3859 15.5272 13.1326 15.1868 13.7886C14.8463 14.4447 14.3077 14.9767 13.6475 15.309C12.9873 15.6413 12.2391 15.757 11.5094 15.6395C10.7797 15.5221 10.1055 15.1776 9.58291 14.6549C9.06027 14.1323 8.71574 13.4582 8.59832 12.7285C8.48089 11.9987 8.59656 11.2505 8.92886 10.5903C9.26116 9.93013 9.79317 9.39151 10.4492 9.05109ZM16.1792 7.55871C15.903 7.55871 15.6792 7.78257 15.6792 8.05871C15.6792 8.33485 15.903 8.55871 16.1792 8.55871H16.1878C16.464 8.55871 16.6878 8.33485 16.6878 8.05871C16.6878 7.78257 16.464 7.55871 16.1878 7.55871H16.1792Z"
                            fill="black"
                          />
                        </svg>
                      </a>
                    </li>
                    <li class="social-item">
                      <a href="#" title="social" class="social-link">
                        <svg
                          width="24"
                          height="25"
                          viewBox="0 0 24 25"
                          fill="none"
                          xmlns="http://www.w3.org/2000/svg"
                        >
                          <circle cx="12" cy="12.168" r="12" fill="white" />
                          <path
                            d="M7 6.66797C7 6.00493 7.26339 5.36904 7.73223 4.9002C8.20107 4.43136 8.83696 4.16797 9.5 4.16797H12V9.16797H9.5C8.83696 9.16797 8.20107 8.90458 7.73223 8.43574C7.26339 7.96689 7 7.33101 7 6.66797Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                          <path
                            d="M12 4.16797H14.5C14.8283 4.16797 15.1534 4.23263 15.4567 4.35827C15.76 4.48391 16.0356 4.66806 16.2678 4.9002C16.4999 5.13235 16.6841 5.40795 16.8097 5.71126C16.9353 6.01457 17 6.33966 17 6.66797C17 6.99627 16.9353 7.32136 16.8097 7.62468C16.6841 7.92799 16.4999 8.20359 16.2678 8.43574C16.0356 8.66788 15.76 8.85203 15.4567 8.97767C15.1534 9.1033 14.8283 9.16797 14.5 9.16797H12V4.16797Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                          <path
                            d="M12 11.668C12 11.3397 12.0647 11.0146 12.1903 10.7113C12.3159 10.4079 12.5001 10.1323 12.7322 9.9002C12.9644 9.66806 13.24 9.48391 13.5433 9.35827C13.8466 9.23263 14.1717 9.16797 14.5 9.16797C14.8283 9.16797 15.1534 9.23263 15.4567 9.35827C15.76 9.48391 16.0356 9.66806 16.2678 9.9002C16.4999 10.1323 16.6841 10.4079 16.8097 10.7113C16.9353 11.0146 17 11.3397 17 11.668C17 11.9963 16.9353 12.3214 16.8097 12.6247C16.6841 12.928 16.4999 13.2036 16.2678 13.4357C16.0356 13.6679 15.76 13.852 15.4567 13.9777C15.1534 14.1033 14.8283 14.168 14.5 14.168C14.1717 14.168 13.8466 14.1033 13.5433 13.9777C13.24 13.852 12.9644 13.6679 12.7322 13.4357C12.5001 13.2036 12.3159 12.928 12.1903 12.6247C12.0647 12.3214 12 11.9963 12 11.668V11.668Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                          <path
                            d="M7 16.668C7 16.0049 7.26339 15.369 7.73223 14.9002C8.20107 14.4314 8.83696 14.168 9.5 14.168H12V16.668C12 17.331 11.7366 17.9669 11.2678 18.4357C10.7989 18.9046 10.163 19.168 9.5 19.168C8.83696 19.168 8.20107 18.9046 7.73223 18.4357C7.26339 17.9669 7 17.331 7 16.668Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                          <path
                            d="M7 11.668C7 11.0049 7.26339 10.369 7.73223 9.9002C8.20107 9.43136 8.83696 9.16797 9.5 9.16797H12V14.168H9.5C8.83696 14.168 8.20107 13.9046 7.73223 13.4357C7.26339 12.9669 7 12.331 7 11.668Z"
                            stroke="black"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                          />
                        </svg>
                      </a>
                    </li>
                  </ul>
                </div>
                <div class="footer-category-item">
                  <h3 class="footer-heading">Call us</h3>
                  <a href="tel:+1 800 854-36-80" title="+1 800 854-36-80"
                    >+1 800 854-36-80</a
                  >
                </div>
              </div>
              <div class="footer-category">
                <h3 class="footer-heading">Product</h3>
                <ul class="footer-link-list">
                  <li class="footer-link-item">
                    <a href="#" title="Landing Page" class="footer-link"
                      >Landing Page</a
                    >
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Popup Builder" class="footer-link"
                      >Popup Builder</a
                    >
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Web-design" class="footer-link">Web-design</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Content" class="footer-link">Content</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Integrations" class="footer-link"
                      >Integrations</a
                    >
                  </li>
                </ul>
              </div>
              <div class="footer-category">
                <h3 class="footer-heading">Use Cases</h3>
                <ul class="footer-link-list">
                  <li class="footer-link-item">
                    <a href="#" title="Web-designers" class="footer-link"
                      >Web-designers</a
                    >
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Marketers" class="footer-link">Marketers</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Small Business" class="footer-link"
                      >Small Business</a
                    >
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Website Builder" class="footer-link"
                      >Website Builder</a
                    >
                  </li>
                </ul>
              </div>
              <div class="footer-category">
                <h3 class="footer-heading">Company</h3>
                <ul class="footer-link-list">
                  <li class="footer-link-item">
                    <a href="#" title="About Us" class="footer-link">About Us</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Careers" class="footer-link">Careers</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="FAQs" class="footer-link">FAQs</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Teams" class="footer-link">Teams</a>
                  </li>
                  <li class="footer-link-item">
                    <a href="#" title="Contact Us" class="footer-link">Contact Us</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="footer-bottom">
              <ul class="footer-bottom-list">
                <li class="footer-bottom-item">
                  <a href="#" title="Privacy Policy" class="footer-bottom-link"
                    >Privacy Policy</a
                  >
                </li>
                <li class="footer-bottom-item">
                  <a href="#" title="Terms of Use" class="footer-bottom-link"
                    >Terms of Use</a
                  >
                </li>
                <li class="footer-bottom-item">
                  <a href="#" title="Sales and Refunds" class="footer-bottom-link"
                    >Sales and Refunds</a
                  >
                </li>
                <li class="footer-bottom-item">
                  <a href="#" title="Legal" class="footer-bottom-link">Legal</a>
                </li>
                <li class="footer-bottom-item">
                  <a href="#" title="Site Map" class="footer-bottom-link">Site Map</a>
                </li>
              </ul>
            </div>
          </div>
    </div>
</footer>
</body>
</html>