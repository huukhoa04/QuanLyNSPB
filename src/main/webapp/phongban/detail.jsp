<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="com.quanlynspb.models.bean.PhongBan" %>
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
                PhongBan phongBan = (PhongBan) request.getAttribute("phongban");
            %>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th scope="row">IDPB</th>
                    <td><%= phongBan.getIdPb() %></td>
                </tr>
                <tr>
                    <th scope="row">NamePB</th>
                    <td><%= phongBan.getTenPb() %></td>
                </tr>
                <tr>
                    <th scope="row">Description</th>
                    <td><%= phongBan.getDesc() %></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer text-center">
            <a href="${pageContext.request.contextPath}/PhongBanServlet/index" class="btn btn-secondary">Back to Home</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional for interactive components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
