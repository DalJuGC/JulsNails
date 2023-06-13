package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "ModificarPromocion", urlPatterns = {"/ModificarPromocion"})
public class ModificarPromocion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        Float precio = Float.valueOf(rq.getParameter("precio"));
        Boolean vigencia = Boolean.valueOf(rq.getParameter("vigencia"));

        PromocionDAO proDAO = new PromocionDAO();
        Promocion prom = new Promocion(codigo, nombre, precio, vigencia);
        proDAO.modificar(prom);

        rs.sendRedirect("/JulsNails/Promocion/ModificarProm.jsp");
    }
}
