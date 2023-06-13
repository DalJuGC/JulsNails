<%@ page import="modelo.Cliente" %>
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
    <form method="post" action="/JulsNails/BuscarCliente">
        <fieldset>
            <input class="search-input" type="number" name="Codigo" placeholder="Buscar"/>
            <input class="search-button" type="submit" value="Buscar"/>
        </fieldset>
    </form>
    <%-- Obtiene cita del atributo de solicitud --%>
    <% Cliente cliente = (Cliente) request.getAttribute("Cliente");%>

    <%-- Verifica si existe la cita --%>
    <% if (cliente != null) {%>
    <table>
        <tr>
            <th>Cliente: </th>
            <td><%= cliente.getNombre() %></td>
        </tr>
        <tr>
            <th>Teléfono: </th>
            <td><%= cliente.getTelefono() %></td>
        </tr>
        <tr>
            <th>Domicilio: </th>
            <td><%= cliente.getDomicilio() %></td>
        </tr>
    </table>
    <%} else {%>
    <p>No se encontró ningún registro</p>
    <%}%>
</main>
</body>
</html>
