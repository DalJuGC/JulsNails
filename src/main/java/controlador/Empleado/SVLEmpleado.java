package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "SVLEmpleado", urlPatterns = {"/SVLEmpleado"})
public class SVLEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        try{
            Connection connectioon = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO();
            List<Empleado> lista = empDAO.seleccionar();
            rq.getSession().setAttribute("lista", lista);
            connectioon.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Empleado/ListaEmp.jsp");
    }
}
