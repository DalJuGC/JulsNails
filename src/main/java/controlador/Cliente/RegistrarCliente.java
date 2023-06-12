package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.annotation.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String nombre = rq.getParameter("nombre");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");

        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO(connection);
            Cliente cli = new Cliente(nombre, telefono, domicilio);

            cliDAO.insertar(cli);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Cliente/ListaCliente.jsp");
    }
}
