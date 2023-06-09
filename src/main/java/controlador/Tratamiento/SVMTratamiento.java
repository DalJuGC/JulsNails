package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVMTratamiento", urlPatterns = {"/SVMTratamiento"})
public class SVMTratamiento extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;
    private String Nombre;
    private String Precio;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Nombre = rq.getParameter("Nombre");
        Precio = rq.getParameter("Precio");
        try{
            Connection connection = conexion.getConnection();
            TratamientoDAO traDAO = new TratamientoDAO();
            Tratamiento tra = new Tratamiento();
            rq.getSession().setAttribute("datos", tra);
            if(Nombre != null && Precio != null ){
                traDAO.modificarNombre(Codigo, Nombre);
                traDAO.modificarPrecio(Codigo, Precio);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Empleado/ModificarEmp.jsp");
    }
}
