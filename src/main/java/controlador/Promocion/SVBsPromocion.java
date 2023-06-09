package controlador.Promocion;

import datos.EmpleadoDAO;
import modelo.Empleado;
import modelo.Promocion;
import datos.PromocionDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVBsPromocion", urlPatterns = {"/SVBsPromocion"})
public class SVBsPromocion extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            PromocionDAO promDAO = new PromocionDAO();
            Promocion prom = promDAO.buscar(Codigo);
            if(prom != null){
                rq.getSession().setAttribute("Codigo", prom.getCodigo());
                rq.getSession().setAttribute("Encontrado", true);
            }else{
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("Encontrado", false);
            }
            rq.getSession().setAttribute("Codigo", null);
            rq.getSession().setAttribute("datos", prom);

            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Promocion/ListaProm.jsp");
    }
}
