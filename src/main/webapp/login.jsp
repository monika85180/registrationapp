<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
      body {
        background-color: #f8f9fa;
      }
      .container {
        max-width: 400px;
        margin-top: 100px;
      }
      .form-group {
        margin-bottom: 20px;
      }
      .form-control:focus {
        box-shadow: none;
      }
      .btn-login {
        background-color: #007bff;
        border-color: #007bff;
        padding: 8px 30px;
        font-size: 16px;
        font-weight: bold;
      }
      .btn-login:hover {
        background-color: #0069d9;
        border-color: #0062cc;
      }
    </style>
  </head>
  <body>
  <div>
  <%
  if(request.getAttribute("error")!=null){
	  out.println(request.getAttribute("error"));
  }
  
  
  %>
  
  </div>
    <div class="container">
      <form action="verifyLogin" method="post">
        <h2 class="text-center mb-4">Login</h2>
        <div class="form-group">
          <label for="email">Email address</label>
          <input type="text" class="form-control" name="email" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" name="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary btn-block btn-login">Login</button>
      </form>
    </div>
  </body>
</html>
