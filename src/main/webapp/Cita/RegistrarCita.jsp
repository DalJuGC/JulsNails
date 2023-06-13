<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Citas</title>
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
                <form method="post" action="/JulsNails/RegistrarCita">
                    <p>Cliente <input type="text" name="cod_cliente"></p>
                    <p>Fecha <input type="date" name="fecha"></p>
                    <p>Horario <input type="time" name="horario"></p>
                    <p>Tratamiento <input type="text" name="cod_tratamiento"></p>
                    <p>Promoción <input type="text" name="cod_promocion"></p>
                    <p>Cancelar <lebel><input type="checkbox" name="cancelar"></lebel></p>
                    <p><input class="button" type="submit" value="Registrar"></p>
                </form>
            </div>
        </main>
    </body>
</html>