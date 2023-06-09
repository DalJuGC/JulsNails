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

@WebServlet(name = "SVBsTratamiento", urlPatterns = {"/SVBsTratamiento"})
public class SVBsTratamiento extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            TratamientoDAO traDAO = new TratamientoDAO();
            Tratamiento tra = traDAO.buscar(Codigo);
            if(tra != null){
                rq.getSession().setAttribute("Codigo", tra.getCodigo());
                rq.getSession().setAttribute("Encontrado", true);
            }else{
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("Encontrado", false);
            }
            rq.getSession().setAttribute("Codigo", null);
            rq.getSession().setAttribute("datos", tra);

            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Tratamiento/ListaTra.jsp");
    }

}
