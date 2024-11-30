<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="com.quanlynspb.models.bean.PhongBan" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2024
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Nhan Vien</title>
</head>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<div class="container mt-5">
    <%
        PhongBan prevData = (PhongBan) request.getAttribute("phongban");
    %>
    <h2>Update data of NhanVien</h2>
    <form action="${pageContext.request.contextPath}/PhongBanServlet/create" method="post">
        <div class="form-group">
            <label for="id">IDPB</label>
            <input type="text" class="form-control" id="id" name="idpb" required>
        </div>
        <div class="form-group">
            <label for="tenpb">NamePB</label>
            <input type="text" class="form-control" id="tenpb" name="tenpb" required>
        </div>
        <div class="form-group">
            <label for="desc">Desc</label>
            <input type="text" class="form-control" id="desc" name="desc" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
