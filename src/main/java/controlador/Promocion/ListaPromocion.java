package controlador.Promocion;

import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaPromocion", urlPatterns = {"/ListaPromocion"})
public class ListaPromocion extends HttpServlet {

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        PromocionDAO proDAO = new PromocionDAO();
        List<Promocion> lista = proDAO.listar();
        rq.setAttribute("datos", proDAO.listar());

        rq.getRequestDispatcher("ListaProm.jsp").forward(rq, rs);
    }
}
