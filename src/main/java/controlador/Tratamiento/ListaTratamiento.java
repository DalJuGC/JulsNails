package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaTratamiento", urlPatterns = {"/ListaTratamiento"})
public class ListaTratamiento extends HttpServlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        TratamientoDAO traDAO = new TratamientoDAO();
        List<Tratamiento> lista = traDAO.listar();
        rq.setAttribute("datos", lista);

        rq.getRequestDispatcher("ListaTra.jsp").forward(rq, rs);
    }
}
