package controlador.Empleado;

    import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.annotation.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegistrarEmpleado", urlPatterns = {"/RegistrarEmpleado"})
public class RegistrarEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String nombre = rq.getParameter("nombre");
        String cargo = rq.getParameter("cargo");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");
        Date fecha_contrato = Date.valueOf(rq.getParameter("fecha_contrato"));

        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO(connection);
            Empleado emp = new Empleado(nombre, cargo, telefono, domicilio, fecha_contrato);

            empDAO.insertar(emp);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Empleado/ListaEmpleado.jsp");
    }
}
