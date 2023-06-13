package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "RegistrarCliente", urlPatterns = {"/RegistrarCliente"})
public class RegistrarCliente extends HttpServlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String nombre = rq.getParameter("nombre");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cli = new Cliente(nombre, telefono, domicilio);
        cliDAO.insertar(cli);

        rs.sendRedirect("/JulsNails/Cliente/RegistrarCliente.jsp");
    }
}
