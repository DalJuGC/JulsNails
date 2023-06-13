package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BorrarPromocion", urlPatterns = {"/BorrarPromocion"})
public class BorrarPromocion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        PromocionDAO proDAO = new PromocionDAO();
        Promocion prom = new Promocion(codigo);
        proDAO.borrar(prom);

        rs.sendRedirect("/JulsNails/Promocion/BuscarProm.jsp");
    }
}
