<%--
    Document   : TimTaiLieu
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
            <a href="NVThuVien.jsp" class="img logo rounded-circle mb-5"
               style="background-image: url(./images/bandocpage/logo.jpg);margin-bottom: 16px !important;"></a>
            <span style="text-align: center;display: flex;justify-content: center; margin-bottom: 48px;">${quanli.getNguoiDung().getTen()}</span>

            <ul class="list-unstyled components mb-5">
                <li>
                    <a href="TKTaiLieu.jsp">Thống kê tài liệu</a>
                </li>

                <li>
                    <a href="TKBanDoc.jsp">Thống kê bạn đọc</a>
                </li>

                <li>
                    <a href="TKNhaCungCap.jsp">Thống kê nhà cung cấp</a>
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

        <form action="tkBanDoc" method="post" style="display: inline">
            <div class="form-inline float-left">
                <label>Ngày bắt đầu: </label>
                <input type="text" class="form-control ml-2" name="ngaybatdau"
                       pattern='(?:((?:0[1-9]|1[0-9]|2[0-9])\/(?:0[1-9]|1[0-2])|(?:30)\/(?!02)(?:0[1-9]|1[0-2])
                       |31\/(?:0[13578]|1[02]))\/(?:19|20)[0-9]{2})'
                       title="Nhập đúng định dạng dd/MM/yyyy">
                <label>Ngày kết thúc: </label>
                <input type="text" class="form-control ml-2" name="ngayketthuc"
                       pattern='(?:((?:0[1-9]|1[0-9]|2[0-9])\/(?:0[1-9]|1[0-2])|(?:30)\/(?!02)(?:0[1-9]|1[0-2])
                       |31\/(?:0[13578]|1[02]))\/(?:19|20)[0-9]{2})'
                       title="Nhập đúng định dạng dd/MM/yyyy">
                <input type="submit" value="Thống kê" class="btn btn-success">
            </div>
        </form>

        <br><span>${errorDate}</span>
        <c:if test="${tkbandocs.size() > 0}">
            <table class="table table-striped table-inverse">
                <thead class="thead-inverse">
                <tr>
                    <th>Mã thẻ bạn đọc</th>
                    <th>Tên bạn đọc</th>
                    <th>Ngày sinh</th>
                    <th>Số lần mượn</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="tkbandoc" items="${tkbandocs}">
                    <tr>
                        <td>${tkbandoc.theBanDoc.mathe}</td>
                        <td>${tkbandoc.theBanDoc.banDoc.nguoiDung.ten}</td>
                        <td>${tkbandoc.theBanDoc.banDoc.nguoiDung.ngaysinh}</td>
                        <td>${tkbandoc.soluong}</td>
                        <td>
                            <a href="luotMuonTheoBanDoc?value=${tkbandoc.theBanDoc.mathe}" class="btn btn-info"><i class="fas fa-info"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

    </div>
</div>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>