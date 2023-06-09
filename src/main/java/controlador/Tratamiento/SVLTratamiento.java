package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

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

@WebServlet(name = "SVLTratamiento", urlPatterns = {"/SVLTratamiento"})
public class SVLTratamiento extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        try{
            Connection connectioon = conexion.getConnection();
            TratamientoDAO traDAO = new TratamientoDAO();
            List<Tratamiento> lista = traDAO.seleccionar();
            rq.getSession().setAttribute("lista", lista);
            connectioon.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Tratamiento/ListaTra.jsp");
    }
}
