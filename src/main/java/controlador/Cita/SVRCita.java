package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.annotation.Resource;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVRCita", urlPatterns = {"/SVRCita"})
public class SVRCita extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private Cita cita;
    //private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
        
        }
}
