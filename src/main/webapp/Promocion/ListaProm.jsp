<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Promocion"%>
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
        <h1>Promociones</h1>
        <button class="button" onclick="location.href='/JulsNails/Promocion/RegistrarProm.jsp'">Agregar promoción</button>
        <button class="button" onclick="location.href='/JulsNails/Promocion/ModificarProm.jsp'">Modificar promoción</button>
        <button class="button" onclick="location.href='/JulsNails/Promocion/BuscarProm.jsp'">Buscar Promoción</button>
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
                ArrayList<Promocion> lista = (ArrayList<Promocion>)session.getAttribute("datos");
                if (lista != null && !lista.isEmpty()){
                    for (Promocion promocion : lista){
            %>
            <tr>
                <td><%out.print(promocion.getCodigo()); %></td>
                <td><%out.print(promocion.getNombre()); %></td>
                <td><%out.print(promocion.getPrecio()); %></td>
                <td><%if (promocion.getVigencia()) out.print("Vigente"); else out.println("Inactiva"); %></td>
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
