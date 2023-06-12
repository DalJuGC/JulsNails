package controlador.Cita;

import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "BorrarCita", urlPatterns = {"/BorrarCita"})
public class BorrarCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO(connection);
            citaDAO.borrar(codigo);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Cita/BuscarCita.jsp");
    }
}
