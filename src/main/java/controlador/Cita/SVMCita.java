package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SVMCita", urlPatterns = {"/SVMCita"})
public class SVMCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;
    private String Fecha;
    private String Horario;
    private String Cod_Cliente;
    private String Cod_Tratamiento;
    private String Cod_Promocion;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Fecha= rq.getParameter("Fecha");
        Horario = rq.getParameter("Horario");
        Cod_Cliente = rq.getParameter("Cod_Cliente");
        Cod_Tratamiento = rq.getParameter("Cod_Tratamiento");
        Cod_Promocion = rq.getParameter("Cod_Promocion");
        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO();
            Cita cita = new Cita();
            rq.getSession().setAttribute("datos", cita);
            if(Fecha != null && Horario != null && Cod_Cliente != null && Cod_Tratamiento != null && Cod_Promocion != null){
                citaDAO.modificarFecha(Codigo, Fecha);
                citaDAO.modificarHorario(Codigo, Horario);
                citaDAO.modificarCod_Cliente(Codigo, Cod_Cliente);
                citaDAO.modificarCod_Tratamiento(Codigo, Cod_Tratamiento);
                citaDAO.modificarCod_Promocion(Codigo, Cod_Promocion);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cita/ModificarCita.jsp");
    }
}
