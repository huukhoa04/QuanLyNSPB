<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2024
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <div class="container mt-5">
      <h2>Create Employee</h2>
      <form action="${pageContext.request.contextPath}/NhanVienServlet/create" method="post">
        <div class="form-group">
          <label for="id">ID</label>
          <input type="text" class="form-control" id="id" name="id" required>
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
          <label for="idpb">IDPB</label>
          <input type="text" class="form-control" id="idpb" name="idpb" required>
        </div>
        <div class="form-group">
          <label for="address">Address</label>
          <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
</body>
</html>
