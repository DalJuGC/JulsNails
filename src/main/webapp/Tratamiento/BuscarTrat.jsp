<%@ page import="modelo.Tratamiento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form method="post" action="/JulsNails/BuscarEmpleado">
        <fieldset>
            <input type="number" name="Codigo" placeholder="Buscar"/>
            <input type="submit" value="Buscar"/>
        </fieldset>
    </form>
    <%-- Obtiene cita del atributo de solicitud --%>
    <% Tratamiento tratamiento = (Tratamiento) request.getAttribute("Promocion");%>

    <%-- Verifica si existe la cita --%>
    <% if (tratamiento != null) {%>
    <table>
        <tr>
            <th>Nombre: </th>
            <td><%= tratamiento.getNombre() %></td>
        </tr>
        <tr>
            <th>Precio: </th>
            <td><%= tratamiento.getPrecio() %></td>
        </tr>
        <tr>
            <th>Empleado: </th>
            <td><%= tratamiento.getCod_empleado() %></td>
        </tr>
    </table>
    <%} else {%>
    <p>No se encontró ningún registro</p>
    <%}%>
</main>
</body>
</html>
