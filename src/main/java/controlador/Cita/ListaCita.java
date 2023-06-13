package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaCita", urlPatterns = {"/ListaCita"})
public class ListaCita extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        CitaDAO citaDAO = new CitaDAO();
        List<Cita> lista = citaDAO.listar();
        rq.setAttribute("cita", lista);

        rq.getRequestDispatcher("/JulsNails/ListaCita.jsp").forward(rq, rs);
    }
}
