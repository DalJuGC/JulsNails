package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BuscarPromocion", urlPatterns = {"/BuscarPromocion"})
public class BuscarPromocion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        PromocionDAO proDAO = new PromocionDAO();
        Promocion prom = proDAO.buscar(codigo);
        rq.getSession().setAttribute("Promocion", prom);

        rq.getRequestDispatcher("BuscarProm.jsp").forward(rq, rs);
    }
}
