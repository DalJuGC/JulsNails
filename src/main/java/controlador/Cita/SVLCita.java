package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.annotation.Resource;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaCitas", urlPatterns ={"/SVLCita"})
public class SVLCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO();
            List<Cita> lista = citaDAO.seleccionar();
            rq.getSession().setAttribute("lista", lista);
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cita/SVLCita.jsp");
    }

}
