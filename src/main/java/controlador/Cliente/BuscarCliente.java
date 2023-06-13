package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BuscarCliente", urlPatterns = {"/BuscarCliente"})
public class BuscarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscar(codigo);
        rq.getSession().setAttribute("Cliente", cliente);

        rq.getRequestDispatcher("BuscarCliente.jsp").forward(rq, rs);
    }
}
