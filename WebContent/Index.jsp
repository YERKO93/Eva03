<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<body>
    <form action="UsuarioServlet" method="post">
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input id="username" type="text" name="username" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input id="userpass" type="password" name="userpass" required="required" /></td>
                </tr>
                <tr>
                    <td><input id="loginbtn" type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>