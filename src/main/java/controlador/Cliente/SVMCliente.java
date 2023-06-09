package controlador.Cliente;

import modelo.Cliente;
import datos.ClienteDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVMCliente", urlPatterns = {"/SVMCliente"})
public class SVMCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;
    private int Codigo;
    private String Nombre;
    private String Telefono;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Nombre = rq.getParameter("Nombre");
        Telefono = rq.getParameter("Telefono");
        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO(connection);
            Cliente cli = new Cliente();
            rq.getSession().setAttribute("datos", cli);
            if(Nombre != null && Telefono != null){
                cliDAO.modificarNom(Codigo, Nombre);
                cliDAO.modificarTel(Codigo, Telefono);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/ModificarCliente.jsp");
    }
}
