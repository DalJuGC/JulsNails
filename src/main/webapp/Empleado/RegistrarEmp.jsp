<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empleados</title>
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
        <form method="post" action="/ProyectoDAW/SVREmpleado">
            <p>Codigo <input type="number" name="Codigo"></p>
            <p>Nombre <input type="text" name="Nombre"></p>
            <p>Telefono <input type="text" name="Telefono"></p>
            <p>Cargo <input type="text" name="CaRGO"></p>
            <p>Domicilio <input type="text" name="Domicilio"></p>
            <p>Fecha de contratación <input type="date" name="Fech_Con"></p>
            <p><input type="submit" value="Registrar"></p>
        </form>
    </div>
</main>
</body>
</html>
