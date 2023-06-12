package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "BuscarCita", urlPatterns = {"/BuscarCita"})
public class BuscarCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO(connection);
            Cita cita = citaDAO.buscar(codigo);
            rq.getSession().setAttribute("Cita", cita);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rq.getRequestDispatcher("BuscarCita.jsp").forward(rq, rs);
    }
}
