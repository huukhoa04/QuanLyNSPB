<%@ page import="com.quanlynspb.models.bo.PhongBanBo" %>
<%@ page import="com.quanlynspb.models.bean.PhongBan" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2024
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>phongban</title>
</head>
<body>
<table border="1" style="width:100%; text-align:left;">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Desc</th>
    </tr>
    </thead>
    <tbody>
    <%
        PhongBanBo phongBanBo = new PhongBanBo();
        ArrayList<PhongBan> phongBanArrayList = phongBanBo.getAllPhongBan();
        if (phongBanArrayList != null) {
            for (PhongBan phongBan : phongBanArrayList) {
    %>
    <tr>
        <td><%= phongBan.getIdPb() %></td>
        <td><%= phongBan.getTenPb() %></td>
        <td><%= phongBan.getDesc() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>

</table>
<a href="create.jsp">Create new PhongBan</a>
<a href="../index.jsp">Back to Home</a>

</body>
</html>
