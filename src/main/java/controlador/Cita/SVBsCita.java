package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVBsCita", urlPatterns = {"/SVBsCita"})
public class SVBsCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO();
            Cita cita = citaDAO.buscar(Codigo);

            if(cita != null){
                rq.getSession().setAttribute("Codigo", cita.getCodigo());
                rq.getSession().setAttribute("Encontrado", true);
            }else{
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("Encontrado", false);
            }
            rq.getSession().setAttribute("Codigo", null);
            rq.getSession().setAttribute("datos", cita);

            connection.close();
        }catch (SQLException e){
            rq.getSession().setAttribute("Encontrado", false);
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cita/ListaCita.jsp");
    }
}
