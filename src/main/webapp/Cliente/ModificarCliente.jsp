<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            <form method="post" action="/ProyectoDAW/SVMCliente">
                <%
                Cliente cli = (Cliente)session.getAttribute("datos");
                if (cli != null){
                %>
                <tr>
                    <p>Codigo <input type="number" name="Codigo" value="<%out.print(cli.getCodigo());%>"></p>
                    <p>Nombre <input type="text" name="Nombre" value="<%out.print(cli.getNombre()); %>"></p>
                    <p>Telefono <input type="text" name="Telefono" value="<%out.print(cli.getTelefono()); %>"></p>
                    <p><input type="submit" value="Registrar"></p>
                </tr>
                <%
                }
                session.removeAttribute("datos");
                %>
                <p><input type="submit" value="Guardar"/></p>
            </form>
        </div>
    </main>
</body>
</html>
