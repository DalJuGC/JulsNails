<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Tratamiento"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
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
        <h1>Tratamientos</h1>
        <button class="button" onclick="location.href='/JulsNails/Tratamiento/RegistrarTrat.jsp'">Agregar tratamiento</button>
        <button class="button" onclick="location.href='/JulsNails/Tratamiento/ModificarTrat.jsp'">Modificar tratamiento</button>
        <button class="button" onclick="location.href='/JulsNails/Tratamiento/BuscarTrat.jsp'">Buscar tratamiento</button>
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
                ArrayList<Tratamiento> lista = (ArrayList<Tratamiento>)session.getAttribute("datos");
                if (lista != null && !lista.isEmpty()){
                    for (Tratamiento tratamiento : lista){
            %>
            <tr>
                <td><%out.print(tratamiento.getCodigo()); %></td>
                <td><%out.print(tratamiento.getNombre()); %></td>
                <td><%out.print(tratamiento.getPrecio()); %></td>
                <td><%out.print(tratamiento.getCod_empleado()); %></td>
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
