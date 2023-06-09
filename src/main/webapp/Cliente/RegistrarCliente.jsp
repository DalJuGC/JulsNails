<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clientes</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
            <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
            <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
            <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
            </li>
        </ul>
    </nav>
</header>
<main>
    <div>
        <form method="post" action="/ProyectoDAW/SVRCliente">
            <p>Nombre <input type="text" name="Nombre"></p>
            <p>Telefono <input type="text" name="Telefono"></p>
            <p><input type="submit" value="Registrar"></p>
        </form>
    </div>
</main>
</body>
</html>
