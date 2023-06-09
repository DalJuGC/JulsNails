<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente"%>
<%@ page import="java.util.ArrayList" %>
<head>
    <title>Clientes</title>
    <link rel="stylesheet" type="text/css" href="/ProyectoDAW/Estilos/Tabla.css">
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
        <h1>Cliente</h1>
        <button onclick="location.href='/ProyectoDAW/Cliente/RegistrarCliente.jsp'">Registrar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/BuscarCliente.jsp'">Buscar cliente</button>
        <button onclick="location.href='/ProyectoDAW/Cliente/ModificarCliente.jsp'">Modificar cliente</button>
        <form action="ServletCliente" method="get">
            <table>
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Telefono</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Cliente> seleccionar = (ArrayList)session.getAttribute("datos");
                    if(seleccionar != null){
                      for(Cliente cli : seleccionar){
                %>
                <tr>
                    <td><%out.print(cli.getCodigo()); %></td>
                    <td><%out.print(cli.getNombre()); %></td>
                    <td><%out.print(cli.getTelefono()); %></td>
                </tr>
                <%
                      }
                    }
                    else{
                        response.sendRedirect("/ProyectoDAW/SVLCliente");
                    }
                    session.removeAttribute("datos");
                %>
                </tbody>
            </table>
        </form>
    </div>
</main>
</body>
</html>
