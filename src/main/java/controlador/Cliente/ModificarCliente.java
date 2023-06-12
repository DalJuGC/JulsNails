package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ModificarCliente", urlPatterns = {"/ModificarCliente"})
public class ModificarCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");

        try {
            Connection connection = conexion.getConnection();

            ClienteDAO cliDAO = new ClienteDAO(connection);
            Cliente cli = cliDAO.buscar(codigo);

            cli.setNombre(nombre);
            cli.setTelefono(telefono);
            cli.setDomicilio(domicilio);

        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Cliente/ListaCliente.jsp");
    }
}
