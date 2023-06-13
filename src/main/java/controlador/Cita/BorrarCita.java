package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BorrarCita", urlPatterns = {"/BorrarCita"})
public class BorrarCita extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        CitaDAO citaDAO = new CitaDAO();
        Cita cita = new Cita(codigo);
        citaDAO.borrar(cita);

        rs.sendRedirect("/JulsNails/Cita/BuscarCita.jsp");
    }
}
