<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar Empleado</title>
    <link rel="stylesheet" href="/JulsNails/Estilos/BarraNav.css" type="text/css">
    <link rel="stylesheet" href="/JulsNails/Estilos/Formularios.css" type="text/css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/JulsNails/index.jsp">Inicio</a></li>
            <li><a href="/JulsNails/Cliente/ListaCliente.jsp">Clientes</a></li>
            <li><a href="/JulsNails/Cita/ListaCita.jsp">Citas</a></li>
            <li><a href="/JulsNails/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
            <li><a href="/JulsNails/Promocion/ListaProm.jsp">Promociones</a></li>
            <li><a href="/JulsNails/Empleado/ListaEmp.jsp">Empleados</a></li>
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
            <p><input class="button" type="submit" value="Registrar"/></p>
            </tr>

        </form>
    </div>
</main>
</body>
</html>
