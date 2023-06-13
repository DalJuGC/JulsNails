<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Promociones</title>
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
            <form method="post" action="/JulsNails/RegistrarPromocion">
                <p>Nombre <input type="text" name="nombre"></p>
                <p>Precio <input type="text" name="precio"></p>
                <p>Vigencia <lebel><input type="checkbox" name="vigencia"></lebel></p>
                <p><input type="submit" value="Registrar"></p>
            </form>
        </div>
    </main>
    </body>
</html>
