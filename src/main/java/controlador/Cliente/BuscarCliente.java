package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "BuscarCliente", urlPatterns = {"/BuscarCliente"})
public class BuscarCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO(connection);
            Cliente cli = cliDAO.buscar(codigo);
            rq.getSession().setAttribute("Cliente", cli);
        } catch (SQLException e){
            e.printStackTrace();
        }
        rq.getRequestDispatcher("BuscarCliente.jsp").forward(rq, rs);
    }
}
