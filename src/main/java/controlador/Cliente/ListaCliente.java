package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaCliente", urlPatterns = {"/ListaCliente"})
public class ListaCliente extends HttpServlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        ClienteDAO cliDAO = new ClienteDAO();
        List<Cliente> lista = cliDAO.listar();
        rq.setAttribute("datos", lista);

        rs.sendRedirect("/JulsNails/ListaCliente.jsp");
    }
}
