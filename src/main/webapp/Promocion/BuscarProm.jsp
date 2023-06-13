<%@ page import="modelo.Promocion" %><%--
  Created by IntelliJ IDEA.
  User: Julit
  Date: 04/06/2023
  Time: 07:19 p. m.
  To change this template use File | Settings | File Templates.
--%>
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
    <form method="post" action="/JulsNails/BuscarPromocion">
        <fieldset>
            <input type="number" name="Codigo" placeholder="Buscar"/>
            <input type="submit" value="Buscar"/>
        </fieldset>
    </form>
    <%-- Obtiene cita del atributo de solicitud --%>
    <% Promocion promocion = (Promocion) request.getAttribute("Promocion");%>

    <%-- Verifica si existe la cita --%>
    <% if (promocion != null) {%>
    <table>
        <tr>
            <th>Nombre: </th>
            <td><%= promocion.getNombre() %></td>
        </tr>
        <tr>
            <th>Precio: </th>
            <td><%= promocion.getPrecio() %></td>
        </tr>
        <tr>
            <th>Vigencia: </th>
            <td><%= promocion.getVigencia() %></td>
        </tr>
    </table>
    <%} else {%>
    <p>No se encontró ningún registro</p>
    <%}%>
</main>
</body>
</html>
