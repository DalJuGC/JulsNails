package controlador.Cliente;

import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "ModificarCliente", urlPatterns = {"/ModificarCliente"})
public class ModificarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");

        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cli = new Cliente(nombre, telefono, domicilio);
        cliDAO.modificar(cli);

        rs.sendRedirect("/JulsNails/Cliente/ModificarCliente.jsp");
    }
}
