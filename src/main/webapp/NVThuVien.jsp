<%-- 
    Document   : BanDoc
    Created on : Nov 8, 2021, 12:13:37 AM
    Author     : dangt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sidebar 01</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/bandocpage/style.css">
</head>
<body>

<div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar">
        <div class="p-4 pt-5">
            <a href="NVThuVien.jsp" class="img logo rounded-circle mb-5"
               style="background-image: url(./images/bandocpage/logo.jpg);margin-bottom: 16px !important;"></a>
            <span style="text-align: center;display: flex;justify-content: center; margin-bottom: 48px;">${nhanvien.getNguoiDung().getTen()}</span>

            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="MuonTaiLieu.jsp">Mượn tài liệu</a>
                </li>

                <li>
                    <a href="TraTaiLieu.jsp">Trả tài liệu</a>
                </li>

                <li>
                    <a href="TimNCC.jsp">Nhập tài liệu</a>
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
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
        </nav>

        <h2 class="mb-4">Xin chào, ${nhanvien.getNguoiDung().getTen()}</h2>
        <p>Website thư viện trực tuyến, email: thuvienptit@edu.vn</p>
        <p>SĐT: 0875628498</p>
    </div>
</div>

<c:if test="${not empty luuHoaDonsuccess}">
    <script>
        window.addEventListener("load",function(){
            alert("${luuHoaDonsuccess}")
        });
    </script>
</c:if>

<c:if test="${not empty luuPhieuMuonsuccess}">
    <script>
        window.addEventListener("load",function(){
            alert("${luuPhieuMuonsuccess}")
        });
    </script>
</c:if>

<c:if test="${not empty luuPhieuTrasuccess}">
    <script>
        window.addEventListener("load",function(){
            alert("${luuPhieuTrasuccess}")
        });
    </script>
</c:if>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>