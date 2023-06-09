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

@WebServlet(name = "SVRTratamiento", urlPatterns = {"/SVRTratamiento"})
public class SVRTratamiento extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Nombre;
    private String Precio;

    @Override
    protected  void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Nombre = rq.getParameter("Nombre");
        Precio = rq.getParameter("Precio");

        try{
            Connection connection = conexion.getConnection();
            TratamientoDAO traDAO = new TratamientoDAO();
            Tratamiento tra = new Tratamiento(Nombre, Precio);
            traDAO.insertar(tra);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/Proyecto/Tratamiento/RegistrarTra.jsp");
    }
}
