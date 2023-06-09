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
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "SVLPromocion", urlPatterns = {"/SVLPromocion"})
public class SVLPromocion extends  HttpServlet{
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        try{
            Connection connectioon = conexion.getConnection();
            PromocionDAO promDAO = new PromocionDAO();
            List<Promocion> lista = promDAO.listar();
            rq.getSession().setAttribute("lista", lista);
            connectioon.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Promocion/ListaProm.jsp");
    }
}
