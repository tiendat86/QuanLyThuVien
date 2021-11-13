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
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
        </nav>

        <h2 class="mb-4">Tìm tài liệu</h2>
        <div class="card-body">
            <div class="row mt-2 mb-2">
                <div class="col">
                    <form action="timTaiLieu" method="get" style="display: inline">
                        <div class="form-inline float-left">
                            <label>Tên tài liệu: </label>
                            <input type="text" class="form-control ml-2" name="tentailieu">
                            <input type="submit" value="Tìm tài liệu" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
            <br><span style="color: red; font-size: 13px">${nullTaiLieu}</span>
            <c:if test="${listTaiLieu.size()>0}">
                <table class="table table-striped table-inverse">
                    <thead class="thead-inverse">
                    <tr>
                        <th>Tên tài liệu</th>
                        <th>Tác giả</th>
                        <th>Nhà xuất bản</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="tailieu" items="${listTaiLieu}">
                        <tr>
                            <td>${tailieu.ten}</td>
                            <td>${tailieu.tacgia}</td>
                            <td>${tailieu.nxb}</td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#${tailieu.matl}">
                                    <i class="fas fa-info"></i>
                                </button>

                                <div class="modal fade" id="${tailieu.matl}" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">${tailieu.ten}</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times</span>
                                                </button>
                                            </div>
                                            <div class="modal-body" style="font-size: 18px;">
                                                <span>Mã: ${tailieu.matl}</span>
                                                <span>Tác giả: ${tailieu.tacgia}</span><br>
                                                <span class="float-right">Tên: ${tailieu.ten}</span>
                                                <span class="float-right">NXB: ${tailieu.nxb}</span><br>
                                                <span>Giá: ${tailieu.gia}</span>
                                                <span class="float-right">Số lượng: ${tailieu.soluong}</span><br>
                                                <span style="display: flex; justify-content: center;">
                                                    <img src="${tailieu.anh}" width="200" height="333" />
                                                </span>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Quay lại
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%-- End Modal--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

<script src="./js/bandocpage/jquery.min.js"></script>
<script src="./js/bandocpage/popper.js"></script>
<script src="./js/bandocpage/bootstrap.min.js"></script>
<script src="./js/bandocpage/main.js"></script>
</body>
</html>