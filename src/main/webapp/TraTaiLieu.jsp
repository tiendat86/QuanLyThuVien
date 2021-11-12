<%-- 
    Document   : TimTaiLieu
    Created on : Nov 8, 2021, 12:13:37 AM
    Author     : dangt
--%>

<%@page import="java.time.LocalDate" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.text.SimpleDateFormat" %>
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
        <div class="card-body">

            <div class="row mb-5">
                <div class="col-2"></div>
                <div class="col-8">
                    <div id="accordion">
                        <div class="card">
                            <div class="card-header" id="headingTwo" style="display: flex; justify-content: center;">
                                <h5 class="mb-0">
                                    <button class="btn btn-link collapsed" data-toggle="collapse"
                                            data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"
                                            style="margin-left: 40px;">
                                        <i class="fas fa-arrow-circle-down" style="font-size: 28px;"></i>
                                    </button>

                                    <form action="timTheBanDoc" method="post" style="display: inline">
                                        <div class="form-inline float-left">
                                            <label for="name">Nhập mã thẻ bạn đọc </label>
                                            <input type="text" class="form-control ml-2" name="mathe">
                                            <!--<input type="submit" value="Tìm kiếm" class="btn btn-primary" style="margin-left: 20px;">-->
                                            <button type="submit"
                                                    style="margin-left: 16px; border: none;background-color: #fafafa;font-size: 24px;">
                                                <i class="fas fa-search"></i></button>
                                        </div>
                                    </form>
                                </h5>
                            </div>
                        </div>
                        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                            <div class="card-body" style="font-size: 16px; font-weight: 600; margin-left: 100px">
                                <span>Tên: ${thebandoc.banDoc.nguoiDung.ten} </span><br>
                                <span> SĐT: ${thebandoc.banDoc.nguoiDung.sdt} </span><br>
                                <span>Ngày sinh: ${thebandoc.banDoc.nguoiDung.ngaysinh} </span><br>
                                <span>Địa chỉ: ${thebandoc.banDoc.nguoiDung.diachi} </span><br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <c:choose>
                <c:when test="${thebandoc == null}">
                    <div class="card-body" style="text-align: center; color: red;">
                            ${msg}
                    </div>
                </c:when>

                <c:when test="${thebandoc != null}">
                    <br>
                    <!--Hiển thị tài liệu mượn-->
                    <form action="chonTaiLieuTra" method="post">
                        <table class="table table-striped table-inverse mt-2">
                            <thead class="thead-inverse">
                            <tr>
                                <th col-1></th>
                                <th>Tên tài liệu</th>
                                <th>Tác giả</th>
                                <th>Nhà xuất bản</th>
                                <th col-2>Tình trạng tài liệu</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach var="luotmuon" items="${luotmuons}">
                                <tr>
                                    <td><input type=checkbox name="tratailieus" value="${luotmuon.taiLieu.matl}"></td>
                                    <td>${luotmuon.taiLieu.ten}</td>
                                    <td>${luotmuon.taiLieu.tacgia}</td>
                                    <td>${luotmuon.taiLieu.nxb}</td>
                                    <td><input type="number" name="tinhtrangs" min="0" max="100">%</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <input type="submit" value="Xác nhận" class="btn btn-success mt-2 mb-4 float-right">
                    </form>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>

</body>
</html>
