<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header text-center bg-primary text-white">
            <h2>Employee Details</h2>
            <h3><%=request.getAttribute("updateMessage") != null? request.getAttribute("updateMessage") :"" %></h3>
        </div>
        <div class="card-body">
            <%
                NhanVien nhanVien = (NhanVien) request.getAttribute("nhanvien");
            %>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th scope="row">ID</th>
                    <td><%= nhanVien.getId() %></td>
                </tr>
                <tr>
                    <th scope="row">Name</th>
                    <td><%= nhanVien.getName() %></td>
                </tr>
                <tr>
                    <th scope="row">Department ID</th>
                    <td><%= nhanVien.getIdPb() %></td>
                </tr>
                <tr>
                    <th scope="row">Address</th>
                    <td><%= nhanVien.getAddress() %></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-center">
            <a href="${pageContext.request.contextPath}/NhanVienServlet/index" class="btn btn-secondary">Back to Home</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional for interactive components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
