<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Promocion"%>
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
        <h1>Promociones</h1>
        <button onclick="location.href='/ProyectoDAW/Promocion/RegistrarProm.jsp'">Agregar promoción</button>
        <button onclick="location.href='/ProyectoDAW/Promocion/BuscarProm.jsp'">Buscar Promoción</button>
        <button onclick="location.href='/ProyectoDAW/Promocion/ModificarProm.jsp'">Modificar promoción</button>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Promoción</th>
                <th>Precio</th>
                <th>Vigencia</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Promocion> seleccionar = (ArrayList)session.getAttribute("datos");
                if(seleccionar != null){
                    for(Promocion prom : seleccionar){
            %>
            <tr>
                <td><%out.print(prom.getCodigo()); %></td>
                <td><%out.print(prom.getNombre()); %></td>
                <td><%out.print(prom.getPrecio()); %></td>
                <td><%out.print(prom.getVigencia()); %></td>
            </tr>
            <%
                    }
                }
                else{
                    response.sendRedirect("/ProyectoDAW/SVLPromocion");
                }
                session.removeAttribute("datos");
            %>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
