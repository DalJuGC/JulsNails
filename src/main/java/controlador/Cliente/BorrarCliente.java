package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.io.IOException;

@WebServlet(name = "BorrarCliente", urlPatterns = {"/BorrarCliente"})
public class BorrarCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = new Cliente(codigo);
        cliDAO.borrar(cliente);

        rs.sendRedirect("/JulsNails/Cliente/BuscarCliente.jsp");
    }
}
