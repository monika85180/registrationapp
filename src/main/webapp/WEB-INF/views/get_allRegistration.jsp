<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Responsive Table Template</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body>

  
    <div class="table-responsive">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>Name</th>
            <th>City</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
            <%
			ResultSet result = (ResultSet) request.getAttribute("res");
			while (result.next()) {
			%>
			<tr>
				<td><%=result.getString(1)%></td>
				<td><%=result.getString(2)%></td>
				<td><%=result.getString(3)%></td>
				<td><%=result.getString(4)%></td>
				<td><a href="update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">Update
				</a></td>
				<td><a href="delete?email=<%=result.getString(3)%>">Delete</a></td>
			</tr>



			<%
			}
			%>
  
        </tbody>
      </table>
    </div>
  </div>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
