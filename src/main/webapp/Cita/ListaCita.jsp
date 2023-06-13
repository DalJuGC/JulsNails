<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cita"%>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Citas registradas</title>
    <link rel="stylesheet" href="/JulsNails/Estilos/BarraNav.css" type="text/css">
    <link rel="stylesheet" href="/JulsNails/Estilos/Button.css" type="text/css">
    <link rel="stylesheet" href="/JulsNails/Estilos/Tabla.css" type="text/css">
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
        <h1>Citas Registradas</h1>
        <button class="button" onclick="location.href='/JulsNails/Cita/RegistrarCita.jsp'">Registrar cita</button>
        <button class="button" onclick="location.href='/JulsNails/Cita/ModificarCita.jsp'">Modificar cita</button>
        <button class="button" onclick="location.href='/JulsNails/Cita/BuscarCita.jsp'">Buscar cita</button>
        <form method="get" action="ListaCita">
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Horario</th>
                <th>Tratamiento</th>
                <th>Promoción</th>
            </tr>
            </thead>
            <tbody>
            <% List<Cita> lista = (List<Cita>) request.getAttribute("cita"); %>
            <% if (lista != null && !lista.isEmpty()) {%>
                <% for (Cita cita : lista) {%>
            <tr>
                <td><%=cita.getCodigo() %></td>
                <td><%=cita.getCod_cliente() %></td>
                <td><%=cita.getFecha() %></td>
                <td><%=cita.getHorario() %></td>
                <td><%=cita.getCod_tratamiento() %></td>
                <td><%=cita.getCod_promocion() %></td>
                <td><% if (cita.getCancelar()) out.print("Cancelada"); else out.print("Activa");%></td>
            </tr>
            </tbody>
            <%
                }
            }
            %>
        </table>
        </form>
    </div>
</main>
</body>

</html>