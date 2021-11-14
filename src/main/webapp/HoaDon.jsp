<%-- 
    Document   : TimTaiLieu
    Created on : Nov 8, 2021, 12:13:37 AM
    Author     : dangt
--%>

<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.text.DecimalFormat" %>
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
        <div class="row mt-2 mb-2">
            <div class="col">
                <label>Người in: </label>
                <input type="text" class="form-control ml-2" value="${nhanvien.nguoiDung.ten}" disabled>
                <label>Nhà cung cấp: </label>
                <input type="text" class="form-control ml-2" value="${nhacungcap.ten}" disabled>
            </div>
            <div class="col">
                <label>Ngày in </label>
                <input type="text" class="form-control ml-2"
                       value="<%=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%>" disabled>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary mt-4" data-toggle="modal" data-target="#exampleModal">
                    Lưu hóa đơn
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Lưu phiếu mượn</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn có chắc chắn lưu hóa đơn?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy bỏ</button>
                                <a href="luuHoaDon" class="btn btn-primary">Xác nhận</a>
                            </div>
                        </div>
                    </div>
                </div>

<%--                <a href="luuPhieuMuon" class="btn btn-primary">Xác nhận</a>--%>
                <a href="#" class="btn btn-secondary mt-4">In hóa đơn</a>
            </div>
        </div>

        <table class="table table-striped table-inverse">
            <thead class="thead-inverse">
            <tr>
                <th>Tên tài liệu</th>
                <th>Tác giả</th>
                <th>Số lượng</th>
                <th>Tổng giá</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="luotnhap" items="${luotnhaps}">
                <tr>
                    <td>${luotnhap.tailieu.ten}</td>
                    <td>${luotnhap.tailieu.tacgia}</td>
                    <td>${luotnhap.soluong}</td>
                    <td>${luotnhap.gia}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2>Tổng số lượng: ${hoadon.tongsoluong}</h2>
        <br>
        <h2>Tổng tiền: ${tongtien}</h2>
    </div>
</div>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>