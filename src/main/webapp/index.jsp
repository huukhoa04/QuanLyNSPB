<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f8f9fa;">

<!-- Main container -->
<div class="container d-flex justify-content-center align-items-center vh-100">

    <!-- Card for the landing page content -->
    <div class="card shadow-lg p-5 w-50 text-center">
        <h1 class="mb-4 display-4">Welcome to the Management System</h1>
        <p class="lead mb-5">Select a management section to proceed</p>

        <!-- Button links styled using Bootstrap -->
        <div class="d-grid gap-2">
            <a href="${pageContext.request.contextPath}/NhanVienServlet/index" class="btn btn-primary btn-lg">NhanVien Management</a>
            <a href="${pageContext.request.contextPath}/PhongBanServlet/index" class="btn btn-secondary btn-lg">PhongBan Management</a>
        </div>
    </div>

</div>

<!-- Bootstrap JS (optional for interactive components like modals or tooltips) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
