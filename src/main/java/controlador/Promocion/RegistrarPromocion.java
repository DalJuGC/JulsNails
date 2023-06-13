package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(name = "RegistrarPromocion", urlPatterns = {"/RegistrarPromocion"})
public class RegistrarPromocion extends HttpServlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String nombre = rq.getParameter("nombre");
        Float precio = Float.valueOf(rq.getParameter("precio"));
        Boolean vigencia = Boolean.valueOf(rq.getParameter("vigencia"));

        PromocionDAO proDAO = new PromocionDAO();
        Promocion prom = new Promocion(nombre, precio, vigencia);
        proDAO.insertar(prom);

        rs.sendRedirect("/JulsNails/Empleado/RegistrarEmp.jsp");
    }
}
