<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar Empleado</title>
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
        <form method="post" action="/JulsNails/ModificarEmpleado">
            <p>Nombre <input type="text" name="nombre" value="<%=request.getParameter("nombre") %>"></p>
            <p>Cargo <input type="text" name="cargo" value="<%=request.getParameter("cargo") %>"></p>
            <p>Teléfono <input type="text" name="telefono" value="<%=request.getParameter("telefono") %>"></p>
            <p>Domicilio <input type="text" name="domicilio" value="<%=request.getParameter("domicilio") %>"></p>
            <p>Fecha de contratacion <input type="date" name="fecha_contrato" value="<%=request.getParameter("fecha_contrato") %>"></p>
            <p><input type="submit" value="Registrar"/></p>
            </tr>

        </form>
    </div>
</main>
</body>
</html>
