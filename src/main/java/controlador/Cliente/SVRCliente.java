package controlador.Cliente;

import modelo.Cliente;
import datos.ClienteDAO;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SVRCliente", urlPatterns ={"/SVRCliente"})
public class SVRCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Nombre;
    private String Telefono;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Nombre = rq.getParameter("Nombre");
        Telefono = rq.getParameter("Telefono");

        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO();
            Cliente cli = new Cliente(Nombre, Telefono);
            cliDAO.insertar(cli);
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/RegistrarCliente.jsp");
    }
}
