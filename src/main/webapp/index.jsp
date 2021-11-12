<%--
    Document   : index
    Created on : Oct 23, 2021, 1:19:57 PM
    Author     : Tien Dat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login V2</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/login/util.css">
    <link rel="stylesheet" type="text/css" href="./css/login/main.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form" action="login" method="post">
					<span class="login100-form-title p-b-26">
						Welcome
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

                <div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
                    <label style="opacity: 0.7">Tên tài khoản</label>
                    <input class="input100" type="text" name="tentaikhoan" >
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <label style="opacity: 0.7">Mật khẩu</label>
                    <input class="input100" type="password" name="matkhau" placeholder="Password">
                </div>
                <div class="container-login100-form-btn">
<%--                    <span style="color: red; font-size: 13px">${nullLogin}</span>--%>
                    <c:if test="${not empty nullLogin}">
                        <script>
                            window.addEventListener("load",function(){
                                alert("${nullLogin}")
                            });
                        </script>
                    </c:if>
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Login
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="dropDownSelect1"></div>

<script src="./js/bootstrap/bootstrap.min.js"></script>
<script src="./js/login/main.js"></script>

</body>
</html>