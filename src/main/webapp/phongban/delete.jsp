<%@ page import="com.quanlynspb.models.bean.NhanVien" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.quanlynspb.models.bean.PhongBan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete</title>
    <!-- Bootstrap CSS for styling (optional) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Employee List</h2>
    <form id="deleteForm" action="${pageContext.request.contextPath}/PhongBanServlet/delete" method="POST">
        <table class="table table-bordered">
            <thead class="thead-light">
            <tr>
                <th>IDPB</th>
                <th>NamePB</th>
                <th>Description</th>
                <th>Selection</th>
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
                    <input type="checkbox" name="selectedIds" value="<%= phongBan.getIdPb() %>" class="checkbox-item" />
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
        <button type="button" class="btn btn-danger" onclick="submitSelected()">Delete Selected</button>
    </form>
</div>

<script>
    // Function to gather all selected checkbox values and submit the form
    function submitSelected() {
        // Get all checkboxes with class 'checkbox-item'
        const checkboxes = document.querySelectorAll('.checkbox-item');
        const selectedValues = [];

        // Loop through checkboxes and gather checked values
        checkboxes.forEach((checkbox) => {
            if (checkbox.checked) {
                selectedValues.push(checkbox.value);
            }
        });

        // Check if any checkboxes are selected
        if (selectedValues.length === 0) {
            alert('Please select at least one employee to delete.');
            return;
        }

        // Create a hidden input field to store selected values
        const form = document.getElementById('deleteForm');
        const hiddenInput = document.createElement('input');
        hiddenInput.type = 'hidden';
        hiddenInput.name = 'selectedIds';
        hiddenInput.value = selectedValues.join(',');
        console.log(hiddenInput.value);
        console.log(selectedValues.join(','));
        // Append the hidden input to the form and submit
        form.appendChild(hiddenInput);
        form.submit();
    }
</script>

<!-- Bootstrap JS (optional for interactive components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
