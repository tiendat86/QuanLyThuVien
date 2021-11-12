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
    <title>Web</title>
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

    <!-- Page Content  -->
    <div id="content" class="p-4 p-md-5">
        <div class="row">
            <div class="col-5">
                <h5 class="mb-0">
                    <form action="timTaiLieuNhap" method="post" style="display: inline">
                        <div class="form-inline float-left">
                            <label for="name">Nhập mã tài liệu </label>
                            <input type="text" class="form-control ml-2" name="matailieu">
                            <button type="submit"
                                    style="margin-left: 16px; border: none;background-color: #fafafa;font-size: 24px;">
                                <i class="fas fa-search"></i></button>
                            <a href="ThemTaiLieu.jsp" class="btn btn-outline-info">Thêm tài liệu</a>
                        </div>
                    </form>
                </h5>

                <br>
                <span style="color: red">${msg2}</span>

                <c:if test="${tailieu != null}">
                    <div style="margin-top: 36px;">

                        <table class="table table-striped table-inverse">
                            <thead class="thead-inverse">
                            <tr>
                                <th></th>
                                <th>Tên tài liệu</th>
                                <th>Tác giả</th>
                                <th>Nhà xuất bản</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <a href="<%=request.getContextPath()%>/timTaiLieuNhap" class="">
                                        <i class="fas fa-plus-circle" style="font-size: 24px;"></i></a>
                                </td>
                                <td>${tailieu.ten}</td>
                                <td>${tailieu.tacgia}</td>
                                <td>${tailieu.nxb}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <span style="color: red">${msg3}</span>
                </c:if>
            </div>
            <div class="col-1"></div>
            <div class="col-6">
                <!--<div class="row mt-2 mb-2">-->
                <form action="luuHoaDon" method="post" style="display: inline">
                    <br>

                    <!--</div>-->

                    <table class="table table-striped table-inverse mt-2">
                        <thead class="thead-inverse">
                        <tr>
                            <th class="col-4">Tên tài liệu</th>
                            <th class="col-3">Tác giả</th>
                            <th class="col-3">Nhà xuất bản</th>
                            <th class="col-1">Số lượng</th>
                            <th class="col-1">Đơn giá</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tl" items="${tailieus}">
                            <tr>
                                <td>${tl.ten}</td>
                                <td>${tl.tacgia}</td>
                                <td>${tl.nxb}</td>
                                <td><input type="number" name="soluongs" min="1"
                                                         style="border: none; width: 102px;"></td>
                                <td><input type="number" name="dongias" value="${tl.gia}"
                                                         style="border: none; width: 150px"></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" value="Xác nhận" class="btn btn-success mt-2 mb-4 float-right">
                </form>
            </div>
        </div>
    </div>
</div>

<c:if test="${not empty addTLSuccess}">
    <script>
        window.addEventListener("load",function(){
            alert("${addTLSuccess}")
        });
    </script>
</c:if>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>

</body>
</html>
