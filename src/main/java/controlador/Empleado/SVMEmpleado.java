package controlador.Empleado;

import modelo.Empleado;
import datos.EmpleadoDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVMEmpleado", urlPatterns = {"/SVMEmpleado"})
public class SVMEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;
    private String Nombre;
    private String Cargo;
    private String Telefono;
    private String Domicilio;
    private String Fech_Con;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Nombre = rq.getParameter("Nombre");
        Cargo = rq.getParameter("Cargo");
        Telefono = rq.getParameter("Telefono");
        Domicilio = rq.getParameter("Domicilio");
        Fech_Con = rq.getParameter("Fech_Con");
        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO(connection);
            Empleado emp = new Empleado();
            rq.getSession().setAttribute("datos", emp);
            if(Nombre != null && Cargo != null && Telefono != null && Domicilio != null && Fech_Con != null){
                empDAO.modificarNom(Codigo, Nombre);
                empDAO.modificarCar(Codigo, Cargo);
                empDAO.modificarTel(Codigo, Telefono);
                empDAO.modificarDom(Codigo, Domicilio);
                empDAO.modificarFech(Codigo, Fech_Con);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Empleado/ModificarEmp.jsp");
    }
}
