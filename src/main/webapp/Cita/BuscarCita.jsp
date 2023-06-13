<%@ page import="modelo.Cita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar</title>
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
    <form method="get" action="/JulsNails/BuscarCita">
        <fieldset>
            <input type="number" name="Codigo" placeholder="Buscar"/>
            <input type="submit" value="Buscar"/>
        </fieldset>
    </form>
        <%-- Obtiene cita del atributo de solicitud --%>
        <% Cita cita = (Cita) request.getAttribute("Cita");%>

        <%-- Verifica si existe la cita --%>
        <% if (cita != null) {%>
        <table>
            <tr>
                <th>Cliente: </th>
                <td><%= cita.getCod_cliente() %></td>
            </tr>
            <tr>
                <th>Fecha: </th>
                <td><%= cita.getFecha() %></td>
            </tr>
            <tr>
                <th>Horario: </th>
                <td><%= cita.getHorario() %></td>
            </tr>
            <tr>
                <th>Tratamiento: </th>
                <td><%= cita.getCod_tratamiento() %></td>
            </tr>
            <tr>
                <th>Promoción: </th>
                <td><%= cita.getCod_promocion() %></td>
            </tr>
        </table>
    <%} else {%>
    <p>No se encontró ningún registro</p>
    <%}%>
</main>
</body>
</html>