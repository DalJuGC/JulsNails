package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BuscarTratamiento", urlPatterns = {"/BuscarTratamiento"})
public class BuscarTratamiento extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        TratamientoDAO traDAO = new TratamientoDAO();
        Tratamiento trat = traDAO.buscar(codigo);
        rq.getSession().setAttribute("Tratamiento", trat);

        rq.getRequestDispatcher("BuscarTrat.jsp").forward(rq, rs);
    }
}
