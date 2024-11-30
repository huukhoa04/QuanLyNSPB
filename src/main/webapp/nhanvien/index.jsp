<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.quanlynspb.models.bo.NhanVienBo" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2024
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhan Vien</title>
</head>
<body>
  <table border="1" style="width:100%; text-align:left;">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>IDPB</th>
        <th>Address</th>
      </tr>
    </thead>
    <tbody>
      <%
        NhanVienBo nhanVienBo = new NhanVienBo();
        ArrayList<NhanVien> nhanVienList = nhanVienBo.getAllNhanVien();
        if (nhanVienList != null) {
          for (NhanVien nhanVien : nhanVienList) {
      %>
      <tr>
        <td><%= nhanVien.getId() %></td>
        <td><%= nhanVien.getName() %></td>
        <td><%= nhanVien.getIdPb() %></td>
        <td><%= nhanVien.getAddress() %></td>
      </tr>
      <%
          }
        }
      %>
    </tbody>
  </table>
  <a href="create.jsp">Create</a>
  <a href="../index.jsp">Back to Home</a>
<script type="module">


  console.log((<%= nhanVienList %>).json());

</script>
</body>
</html>
