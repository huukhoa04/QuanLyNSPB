<%@ page import="com.quanlynspb.models.bean.NhanVien" %><%--
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
        NhanVien prevData = (NhanVien) request.getAttribute("nhanVien");
    %>
    <h2>Update data of NhanVien</h2>
    <form action="${pageContext.request.contextPath}/NhanVienServlet/update" method="post">
        <div class="form-group">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="<%=prevData.getId()%>" required readonly>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="<%=prevData.getName()%>" required>
        </div>
        <div class="form-group">
            <label for="idpb">IDPB</label>
            <input type="text" class="form-control" id="idpb" name="idpb" value="<%=prevData.getIdPb()%>" required>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="<%=prevData.getAddress()%>" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
