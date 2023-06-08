package controlador.Empleado;

import modelo.Empleado;
import datos.EmpleadoDAO;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SVREmpleado", urlPatterns = {"/SVREmpleado"})
public class SVREmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Nombre;
    private String Cargo;
    private String Telefono;
    private String Domicilio;
    private String Fech_Con;

    @Override
    protected  void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Nombre = rq.getParameter("Nombre");
        Cargo = rq.getParameter("Cargo");
        Telefono = rq.getParameter("Telefono");
        Domicilio = rq.getParameter("Domicilio");
        Fech_Con = rq.getParameter("Fech_Con");

        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO();
            Empleado emp = new Empleado(Nombre, Cargo, Telefono, Domicilio, Fech_Con);
            empDAO.insertar(emp);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/Proyecto/Empleado/RegistrarEmp.jsp");
    }
}
