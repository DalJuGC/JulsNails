<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cita"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="datos.CitaDAO"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Citas registradas</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
            <li><a href="/ProyectoDAW/Cliente/ListaCliente.jsp">Clientes</a></li>
            <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
            <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
            <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
            <li><a href="/ProyectoDAW/Empleado/ListaEmp.jsp">Empleados</a></li>
        </ul>
    </nav>
</header>
<main>
    <div>
        <h1>Citas Registradas</h1>
        <button onclick="location.href='/ProyectoDAW/Cita/RegistrarCita.jsp'">Registrar cita</button>
        <button onclick="location.href='/ProyectoDAW/Cita/BuscarCita.jsp'">Buscar cita</button>
        <button onclick="location.href='/ProyectoDAW/Cita/ModificarCita.jsp'">Modificar cita</button>

        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Horario</th>
                <th>Tratamiento</th>
                <th>Promoción</th>
            </tr>
            <c:forEach items="${Cita}" var="c">
                <tr>
                    <td>${c.getCocido}</td>
                    <td>${c.Cod_Cliente}</td>
                    <td>${c.Fecha}</td>
                    <td>${c.Horario}</td>
                    <td>${c.Cod_Tratamiento}</td>
                    <td>${c.Cod_Promocion}</td>
                </tr>
            </c:forEach>
            </thead>
        </table>

    </div>
</main>
</body>

</html>