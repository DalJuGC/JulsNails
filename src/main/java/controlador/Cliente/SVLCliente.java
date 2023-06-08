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
import java.util.List;

@WebServlet(name = "SVLCliente", urlPatterns = {"/SVLCliente"})
public class SVLCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;
    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO();
            List<Cliente> lista = cliDAO.seleccionar();
            rq.getSession().setAttribute("lista", lista);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/ListaCliente.jsp");
    }
}