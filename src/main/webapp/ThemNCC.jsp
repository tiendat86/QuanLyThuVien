<%-- 
    Document   : TimTaiLieu
    Created on : Nov 8, 2021, 12:13:37 AM
    Author     : dangt
--%>

<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.LocalDate" %>
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

<section class="row">
    <div class="col-2"></div>
    <div class="col-8 offset-3 mt-4">
        <div class="card">

            <div class="card-header">
                <h2>Thêm nhà cung cấp</h2>
            </div>

            <div class="card-body">
                <form action="themNhaCungCap" method="POST">
                    <div class="form-group">
                        <label>Tên</label>
                        <input type="text" class="form-control ml-2" name="ten">
                        <label>Địa chỉ</label>
                        <input type="text" class="form-control ml-2" name="diachi">
                        <label>SĐT</label>
                        <input type="text" class="form-control ml-2" name="sdt">
                        <button type="submit" class="btn btn-success mt-4">Thêm</button>
                        <a href="TimNCC.jsp" class="btn btn-danger mt-4 ml-4">Quay lại</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</section>

<footer class="row"></footer>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>