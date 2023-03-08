<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2/24/2023
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
</head>
<body>

<form action="user?page=newUsers" method="POST">
    <input type="text" name="userName" placeholder="Enter userName: "><br>
    <input type="password" name="password" placeholder="Enter password: "><br>
    <input type="text" name="location" placeholder="Enter Location: "><br>

    <input type="submit" value="Register">
    <a href="user?page=index">Already a member ? Back to Login: </a>
</form>

</body>
</html>