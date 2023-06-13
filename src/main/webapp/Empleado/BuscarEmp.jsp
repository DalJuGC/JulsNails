<%@ page import="modelo.Empleado" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar</title>
    <link rel="stylesheet" href="/JulsNails/Estilos/BarraNav.css" type="text/css">
    <link rel="stylesheet" href="/JulsNails/Estilos/Buscador.css" type="text/css">
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
            <input class="search-input" type="number" name="Codigo" placeholder="Buscar"/>
            <input class="search-button" type="submit" value="Buscar"/>
        </fieldset>
    </form>
    <%-- Obtiene cita del atributo de solicitud --%>
    <% Empleado empleado = (Empleado) request.getAttribute("Empleado");%>

    <%-- Verifica si existe la cita --%>
    <% if (empleado != null) {%>
    <table>
        <tr>
            <th>Nombre: </th>
            <td><%= empleado.getNombre() %></td>
        </tr>
        <tr>
            <th>Cargo: </th>
            <td><%= empleado.getCargo() %></td>
        </tr>
        <tr>
            <th>Telefono: </th>
            <td><%= empleado.getTelefono() %></td>
        </tr>
        <tr>
            <th>Domicilio: </th>
            <td><%= empleado.getDomicilio() %></td>
        </tr>
        <tr>
            <th>Fecha de contratación: </th>
            <td><%= empleado.getFecha_contrato() %></td>
        </tr>
    </table>
    <%} else {%>
    <p>No se encontró ningún registro</p>
    <%}%>
</main>
</body>
</html>
