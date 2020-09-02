<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Acceso Correcto!!!</h3>
    <h4>
        Bienvenido,
        <%=session.getAttribute("name")%></h4>
        
    Nombre: <h1><%=session.getAttribute("name")%></h1>
    </br>
    Apellido: <h1><%=session.getAttribute("lstName")%></h1>
    </br>
    Rut: <h1><%=session.getAttribute("rut")%></h1>
    </br>
    Fecha Ingreso: <h1><%=session.getAttribute("date")%></h1>
    </br>
    Telefono: <h1><%=session.getAttribute("phone")%></h1>
</body>
</html>