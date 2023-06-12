package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ModificarCita", urlPatterns = {"/ModificarCita"})
public class ModificarCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        Date fecha = Date.valueOf(rq.getParameter("fecha"));
        Time horario = Time.valueOf(rq.getParameter("horario"));
        int cod_tratamiento = Integer.parseInt(rq.getParameter("cod_tratamiento"));
        int cod_promocion = Integer.parseInt(rq.getParameter("cod_promocion"));

        try {
            Connection connection = conexion.getConnection();

            CitaDAO citaDAO = new CitaDAO(connection);
            Cita cita = citaDAO.buscar(codigo);

            cita.setFecha(fecha);
            cita.setHorario(horario);
            cita.setCod_tratamiento(cod_tratamiento);
            cita.setCod_promocion(cod_promocion);

        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Cita/ListaCita.jsp");
    }
}
