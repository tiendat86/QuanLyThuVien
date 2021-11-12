<%-- 
    Document   : DKTheBanDoc
    Created on : Nov 8, 2021, 12:13:37 AM
    Author     : dangt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý thư viện</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
          integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/bandocpage/style.css">
</head>
<body>

<div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar">
        <div class="p-4 pt-5">
            <a href="BanDoc.jsp" class="img logo rounded-circle mb-5"
               style="background-image: url(./images/bandocpage/logo.jpg);margin-bottom: 16px !important;"></a>
            <span style="text-align: center;display: flex;justify-content: center; margin-bottom: 48px;">${bandoc.getNguoiDung().getTen()}</span>

            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="TimTaiLieu.jsp">Tìm tài liệu</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/luuTheBanDoc">Đăng ký thẻ bạn đọc</a>
                </li>
                <li>
                    <a href="index.jsp" class="btn btn-success mt-4">Đăng xuất</a>
                </li>
            </ul>

        </div>
    </nav>

    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-primary">
                    <i class="fa fa-bars"></i>
                    <span class="sr-only">Toggle Menu</span>
                </button>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
        </nav>
        <h2 class="mb-4">${msg}</h2>
        <c:if test="${msg.equals('')}">
            <h2 class="mb-4">Hãy điền thông tin thẻ bạn đọc</h2>

            <div class="card-body">
                <div class="mt-2 mb-2">
                    <form action="luuTheBanDoc" method="post" class="form-horizontal" >
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="lname">Mã Thẻ</label>
                            <div class="col-md-4">
                                <input id="lname" name="mathe" type="text" class="form-control input-md" required="">
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email">Loại thẻ</label>
                            <div class="col-md-4">
                                <input id="email" name="loaithe" type="text" class="form-control input-md" required="">
                            </div>
                        </div>

                        <!-- Button (Double) -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="save"></label>
                            <div class="col-md-8">
                                <input type="submit" value="Lưu" class="btn btn-success">
                                <button id="clear" name="clear" class="btn btn-danger">Reset</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
</div>

<c:if test="${not empty alertDKFail}">
    <script>
        window.addEventListener("load",function(){
            alert("${alertDKFail}")
        });
    </script>
</c:if>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>