package controlador.Cita;

import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "ListaCita", urlPatterns = {"/ListaCita"})
public class ListaCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO(connection);
            rq.getSession().setAttribute("datos", citaDAO.listar());

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rq.getRequestDispatcher("ListaCita.jsp").forward(rq, rs);
    }

}
