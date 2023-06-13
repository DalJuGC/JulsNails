package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BuscarCita", urlPatterns = {"/BuscarCita"})
public class BuscarCita extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        CitaDAO citaDAO = new CitaDAO();
        Cita cita = citaDAO.buscar(codigo);
        rq.getSession().setAttribute("Cita", cita);

        rq.getRequestDispatcher("BuscarCita.jsp").forward(rq, rs);
    }
}
