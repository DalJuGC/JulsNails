<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.Tratamiento" %>
<%@ page import="modelo.Promocion" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <title>Registro de Cita</title>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="/src/main/webapp/index.jsp">Inicio</a></li>
                    <li><a aira-haspopup="true">Citas</a>
                        <ul>
                            <li><a href="/src/main/webapp/RegistrarCita.jsp">Registrar Cita</a></li>
                            <li><a href="/src/main/webapp/Cita/BuscarCita.jsp">Buscar Cita</a></li>
                            <li><a href="/src/main/webapp/Cita/ListaCita.jsp">Citas Registradas</a></li> 
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>

        <main>
            <div>
                <form method="post" action="/src/main/java/controlador/Cita/SVRCita.java">
                    <p>Cliente <input type="text" name="Nombre"></p>
                    <p>Fecha <input type="date" name="Fecha"></p>
                    <p>Horario <input type="time" name="Horario"></p>
                    <p>Tratamiento <input type="text" name="Tratamiento"></p>
                    <p>Promocion <input type="text" name="Promocion"></p>
                    <p><input type="submit" value="Registrar"></p>
                </form>
            </div>
        </main>
    </body>
</html>