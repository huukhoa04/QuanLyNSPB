<%@ page import="com.quanlynspb.models.bean.NhanVien" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2024
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhan Vien detail</title>
</head>
<body>
    <%
        NhanVien nhanVien = (NhanVien) request.getAttribute("nhanvien");
    %>
    <span>
        <%=nhanVien.getId()%>
        <%=nhanVien.getName()%>
        <%=nhanVien.getIdPb()%>
        <%=nhanVien.getAddress()%>
    </span>
</body>
</html>
