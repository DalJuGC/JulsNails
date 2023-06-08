<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Clientes</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
            <li><a href="/ProyectoDAW/Cliente/ListaCliente.jsp">Clientes</a></li>
            <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
            <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
            <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
            <li><a href="/ProyectoDAW/Empleado/ListaEmp.jsp">Empleados</a></li>
        </ul>
    </nav>
</header>
<main>
    <div>
        <h1>Citas Registradas</h1>
        <button onclick="location.href='/ProyectoDAW/Cliente/RegistrarCliente.jsp'">Registrar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/BuscarCliente.jsp'">Buscar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/ModificarCliente.jsp'">Modificar cliente</button>
        <form action="ServletCliente" method="get">
            <table>
                <tbody>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                </tr>
                <%
                    HttpSession session1 = request.getSession();
                    ArrayList<Cliente> lista = (ArrayList<Cliente>)session1.getAttribute("cliente");
                    for(Cliente c : lista){
                        out.println("<tr>" +
                                    "<td> "+c.getCodigo()   +"    </td>"+
                                    "<td> "+c.getNombre()   +"    </td>"+
                                    "<td> "+c.getTelefono() +"    </td>"+
                                    "</tr>");
                    }
                %>
                </tbody>
            </table>
        </form>
    </div>
</main>
</body>
</html>