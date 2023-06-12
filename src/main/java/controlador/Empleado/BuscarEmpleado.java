package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

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

@WebServlet(name = "BuscarEmpleado", urlPatterns = {"/BuscarEmpleado"})
public class BuscarEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO(connection);
            Empleado emp = empDAO.buscar(codigo);
            rq.getSession().setAttribute("Empleado", emp);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rq.getRequestDispatcher("BuscarEmpleado.jsp").forward(rq, rs);
    }
}
