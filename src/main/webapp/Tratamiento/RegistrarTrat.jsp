<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Empleado" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tratamientos</title>
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
            <form method="post" action="/JulsNails/RegistrarTratamiento">
                <p>Tratamiento <input type="text" name="nombre"></p>
                <p>Precio <input type="number" name="precio"></p>
                <p>Empleado <input type="text" name="cod_empleado"></p>
                <p><input type="submit" value="Registrar"></p>
            </form>
        </div>
    </main>
    </body>
</html>
