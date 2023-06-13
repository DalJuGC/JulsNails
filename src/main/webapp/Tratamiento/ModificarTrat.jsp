<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Empleado" %>
<html>
<head>
    <title>Modificar Tratamiento</title>
    <link rel="stylesheet" href="/JulsNails/Estilos/BarraNav.css" type="text/css">
    <link rel="stylesheet" href="/JulsNails/Estilos/Formularios.css" type="text/css">
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
        <form method="post" action="/JulsNails/ModificarTratamiento">
            <tr>
                <p>Nombre <input type="text" name="nombre" value="<%=request.getParameter("nombre") %>"></p>
                <p>Precio <input type="number" name="precio" value="<%=request.getParameter("precio") %> %>"></p>
                <p>Empleado <select>
                    <%
                        ArrayList<Empleado> listaEmp = (ArrayList)session.getAttribute("empleado");
                        if (listaEmp != null){
                            for (Empleado empleado : listaEmp){
                    %>
                    <option value="<%=empleado.getCodigo()%>"><%=empleado.getNombre()%></option>
                    <%
                            }
                        }
                    %>

                </select></p>
            </tr>
            <p><input class="button" type="submit" value="Modificar" /></p>
        </form>
    </div>
</main>
</body>
</html>
