package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegistrarCita", urlPatterns = {"/RegistrarCita"})
public class RegistrarCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int cod_cliente = Integer.parseInt(rq.getParameter("cod_cliente"));
        Date fecha = Date.valueOf(rq.getParameter("fecha"));
        Time horario = Time.valueOf(rq.getParameter("horario"));
        int cod_tratamiento = Integer.parseInt(rq.getParameter("cod_tratamiento"));
        int cod_promocion = Integer.parseInt(rq.getParameter("cod_promocion"));

        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO(connection);
            Cita cita = new Cita(cod_cliente, fecha, horario, cod_tratamiento, cod_promocion);

            citaDAO.insertar(cita);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Cita/ListaCita.jsp");
    }
}
