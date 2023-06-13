<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Clientes</title>
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
        <h1>Clientes</h1>
        <button onclick="location.href='/JulsNails/Cliente/RegistrarCliente.jsp'">Registrar cliente</button>
        <button onclick="location.href='/JulsNails/Cliente/BuscarCliente.jsp'">Buscar cliente</button>
        <button onclick="location.href='/JulsNails/Cliente/ModificarCliente.jsp'">Modificar cliente</button>
        <form method="get" action="/JulsNails/ListaCliente">
            <table>
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                    <th>Domicilio</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Cliente> lista = (List)request.getAttribute("cliente");
                    if (lista != null) {
                        for (Cliente cliente : lista) {
                %>
                <tr>
                    <td><%=cliente.getCodigo() %></td>
                    <td><%=cliente.getNombre() %></td>
                    <td><%=cliente.getTelefono() %></td>
                    <td><%=cliente.getDomicilio() %></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </form>
    </div>
</main>
</body>
</html>
