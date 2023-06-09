<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Tratamiento"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Citas registradas</title>
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
        <h1>Tratamientos</h1>
        <button onclick="location.href='/ProyectoDAW/Tratamiento/RegistrarTrat.jsp'">Agregar tratamiento</button>
        <button onclick="location.href='/ProyectoDAW/Tratamiento/BuscarTrat.jsp'">Buscar tratamiento</button>
        <button onclick="location.href='/ProyectoDAW/Tratamiento/ModificarTrat.jsp'">Modificar tratamiento</button>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Tratamiento</th>
                <th>Precio</th>
                <th>Empleado</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Tratamiento> seleccionar = (ArrayList)session.getAttribute("datos");
                if(seleccionar != null){
                    for(Tratamiento tra : seleccionar){
            %>
            <tr>
                <td><%out.print(tra.getCodigo()); %></td>
                <td><%out.print(tra.getNombre()); %></td>
                <td><%out.print(tra.getPrecio()); %></td>
                <td><%out.print(tra.getCod_Empleado()); %></td>
            </tr>
            <%
                    }
                }
                else{
                    response.sendRedirect("/ProyectoDAW/SVLTratamiento");
                }
                session.removeAttribute("datos");
            %>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
