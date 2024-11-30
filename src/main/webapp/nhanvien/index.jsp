<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee Management</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center mb-4">Employee List</h2>
  <table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Department ID</th>
      <th>Address</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
      ArrayList<NhanVien> nhanVienList = (ArrayList<NhanVien>) request.getAttribute("nhanvien");
      if (nhanVienList != null) {
        for (NhanVien nhanVien : nhanVienList) {
    %>
    <tr>
      <td><%= nhanVien.getId() %></td>
      <td><%= nhanVien.getName() %></td>
      <td><%= nhanVien.getIdPb() %></td>
      <td><%= nhanVien.getAddress() %></td>
      <td>
        <form action="${pageContext.request.contextPath}/NhanVienServlet/detail" method="get" class="d-inline">
          <input type="hidden" name="id" value="<%= nhanVien.getId() %>"/>
          <button type="submit" class="btn btn-primary btn-sm">Details</button>
        </form>
        <form action="${pageContext.request.contextPath}/NhanVienServlet/update" method="get" class="d-inline">
          <input type="hidden" name="id" value="<%= nhanVien.getId() %>"/>
          <button type="submit" class="btn btn-warning btn-sm">Update</button>
        </form>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="5" class="text-center">No employees found.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
  <div class="mt-4">
    <a href="${pageContext.request.contextPath}/NhanVienServlet/create" class="btn btn-success">Create New Employee</a>
    <a href="../index.jsp" class="btn btn-secondary">Back to Home</a>
    <a href="${pageContext.request.contextPath}/NhanVienServlet/delete" class="btn btn-danger">Delete</a>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
