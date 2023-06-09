package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SVLEmpleado", urlPatterns = {"/SVLEmpleado"})
public class SVLEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO(connection);
            rq.getSession().setAttribute("datos", empDAO.seleccionar());
            connection.close();
        }catch (SQLException e){
            rq.getSession().setAttribute("datos", new ArrayList<Empleado>());
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Empleado/ListaEmp.jsp");
    }
}
