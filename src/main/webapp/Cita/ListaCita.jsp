<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cita"%>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Citas registradas</title>
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
        <button onclick="location.href='/JulsNails/Cita/RegistrarCita.jsp'">Registrar cita</button>
        <button onclick="location.href='/JulsNails/Cita/BuscarCita.jsp'">Buscar cita</button>
        <button onclick="location.href='/JulsNails/Cita/ModificarCita.jsp'">Modificar cita</button>

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
            <%
                ArrayList<Cita> lista = (ArrayList<Cita>)session.getAttribute("datos");
                if (lista != null && !lista.isEmpty()){
                    for (Cita cita : lista){
            %>
            <tr>
                <td><%out.print(cita.getCodigo()); %></td>
                <td><%out.print(cita.getCod_cliente()); %></td>
                <td><%out.print(cita.getFecha()); %></td>
                <td><%out.print(cita.getHorario()); %></td>
                <td><%out.print(cita.getCod_tratamiento()); %></td>
                <td><%out.print(cita.getCod_promocion()); %></td>
                <td><%if (cita.getCancelar()) out.print("Cancelada"); else out.print("Activa");%></td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</main>
</body>

</html>