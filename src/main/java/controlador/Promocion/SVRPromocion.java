package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SVRPromocion", urlPatterns = {"/SVRPromocion"})
public class SVRPromocion extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Nombre;
    private String Precio;
    private String Vigencia;

    @Override
    protected  void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        Nombre = rq.getParameter("Nombre");
        Precio = rq.getParameter("Precio");
        Vigencia = rq.getParameter("Vigencia");

        try{
            Connection connection = conexion.getConnection();
            PromocionDAO proDAO = new PromocionDAO();
            Promocion prom = new Promocion(Nombre, Precio, Vigencia);
            proDAO.insertar(prom);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/Proyecto/Promocion/RegistrarProm.jsp");
    }
}
