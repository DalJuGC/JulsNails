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

@WebServlet(name = "SVRCita", urlPatterns = {"/SVRCita"})
public class SVRCita extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Fecha;
    private String Horario;
    private String Cod_Cliente;
    private String Cod_Tratamiento;
    private String Cod_Promocion;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Fecha = rq.getParameter("Fecha");
        Horario = rq.getParameter("Horario");
        Cod_Cliente = rq.getParameter("Cod_Cliente");
        Cod_Tratamiento = rq.getParameter("Cod_Tratamiento");
        Cod_Promocion = rq.getParameter("Cod_Promocion");

        try{
            Connection connection = conexion.getConnection();
            CitaDAO citDAO = new CitaDAO();
            Cita cit = new Cita(Fecha, Horario, Cod_Cliente, Cod_Tratamiento, Cod_Promocion);
            citDAO.insertar(cit);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cita/RegistrarCita.jsp");
    }
}
