<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Tratamiento" %>
<%@ page import="modelo.Promocion" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Modificar Cita</title>
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
        <form method="post" action="/JulsNails/ModificarCliente">
            <tr>
                <p>Fecha <input type="text" name="nombre" value="<%=request.getParameter("nombre") %>"></p>
                <p>Horario <input type="text" name="telefono" value="<%=request.getParameter("telefono") %> %>"></p>
                <p>Domicilio <input type="text" name="domicilio" value="<%=request.getParameter("domicilio") %>"></p>
                <p>Tratamiento <select>
                    <%
                        ArrayList<Tratamiento> listaTra = (ArrayList)session.getAttribute("tratamiento");
                        if (listaTra != null){
                            for (Tratamiento tratamiento : listaTra){
                    %>
                    <option value="<%=tratamiento.getCodigo()%>"><%=tratamiento.getNombre()%></option>
                    <%
                            }
                        }
                    %>
                </select></p>
                <p>Promoción <select>
                    <%
                        ArrayList<Promocion> listaProm= (ArrayList)session.getAttribute("promocion");
                        if (listaProm!= null){
                            for (Promocion promocion : listaProm){
                    %>
                    <option value="<%=promocion.getCodigo()%>"><%=promocion.getNombre()%></option>
                    <%
                            }
                        }
                    %>
                </select></p>
            </tr>
            <p><input type="submit" value="Modificar" /></p>
        </form>
    </div>
</main>
</body>
</html>
