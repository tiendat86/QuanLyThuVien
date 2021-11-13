<%--
  Created by IntelliJ IDEA.
  User: dangt
  Date: 11/13/2021
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.format.DateTimeFormatter" %>
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

            <table class="table table-striped table-inverse">
                <thead class="thead-inverse">
                <tr>
                    <th>Tên bạn đọc</th>
                    <th>Ngày sinh</th>
                    <th>Tên tài liệu</th>
                    <th>Tác giả</th>
                    <th>Ngày mượn</th>
                    <th>Ngày phải trả</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="luotmuon" items="${luotmuons}">
                    <tr>
                        <td>${luotmuon.theBanDoc.banDoc.nguoiDung.ten}</td>
                        <td>${luotmuon.theBanDoc.banDoc.nguoiDung.ngaysinh}</td>
                        <td>${luotmuon.taiLieu.ten}</td>
                        <td>${luotmuon.taiLieu.tacgia}</td>
                        <td>${luotmuon.ngaymuon.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}</td>
                        <td>${luotmuon.ngayphaitra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}</td>
                        <td>
                            <a href="phieuMuonTheoLuotMuon?idluotmuon=${luotmuon.id}" class="btn btn-info">
                                <i class="fas fa-info"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <a href="NVQuanLi.jsp" class="btn btn-success mt-4">Quay lại</a>
</div>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>
