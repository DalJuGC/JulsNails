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

@WebServlet (name = "SVMPromocion", urlPatterns = {"/SVMPromocion"})
public class SVMPromocion extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;
    private String Nombre;
    private String Precio;
    private String Vigencia;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Nombre = rq.getParameter("Nombre");
        Precio = rq.getParameter("Precio");
        Vigencia = rq.getParameter("Vigencia");
        try{
            Connection connection = conexion.getConnection();
            PromocionDAO promDAO = new PromocionDAO();
            Promocion prom = new Promocion();
            rq.getSession().setAttribute("datos", prom);
            if(Nombre != null && Precio != null && Vigencia != null){
                promDAO.modificarNombre(Codigo, Nombre);
                promDAO.modificarPrecio(Codigo, Precio);
                promDAO.modificarVig(Codigo, Vigencia);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Promocion/ModificarProm.jsp");
    }
}
