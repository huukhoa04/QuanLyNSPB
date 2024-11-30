<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.quanlynspb.models.bean.PhongBan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PhongBan Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Employee List</h2>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>IDPB</th>
            <th>NamePB</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<PhongBan> phongBanList = (ArrayList<PhongBan>) request.getAttribute("phongban");
            if (phongBanList != null) {
                for (PhongBan phongBan : phongBanList) {
        %>
        <tr>
            <td><%= phongBan.getIdPb() %></td>
            <td><%= phongBan.getTenPb() %></td>
            <td><%= phongBan.getDesc() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/PhongBanServlet/detail" method="get" class="d-inline">
                    <input type="hidden" name="idpb" value="<%= phongBan.getIdPb() %>"/>
                    <button type="submit" class="btn btn-primary btn-sm">Details</button>
                </form>
                <form action="${pageContext.request.contextPath}/PhongBanServlet/update" method="get" class="d-inline">
                    <input type="hidden" name="idpb" value="<%= phongBan.getIdPb() %>"/>
                    <button type="submit" class="btn btn-warning btn-sm">Update</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" class="text-center">No PhongBan found.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/PhongBanServlet/create" class="btn btn-success">Create New PhongBan</a>
        <a href="../index.jsp" class="btn btn-secondary">Back to Home</a>
        <a href="${pageContext.request.contextPath}/PhongBanServlet/delete" class="btn btn-danger">Delete</a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
