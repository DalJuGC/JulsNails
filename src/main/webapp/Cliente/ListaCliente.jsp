<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Clientes</title>
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
        <button onclick="location.href='/ProyectoDAW/Cliente/RegistrarCliente.jsp'">Registrar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/BuscarCliente.jsp'">Buscar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/ModificarCliente.jsp'">Modificar cliente</button>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Telefono</th>
            </tr>
            </thead>
            
        </table>
    </div>
</main>
</body>
</html>