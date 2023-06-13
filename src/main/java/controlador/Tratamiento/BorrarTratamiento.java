package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BorrarTratamiento", urlPatterns = {"/BorrarTratamiento"})
public class BorrarTratamiento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        TratamientoDAO traDAO = new TratamientoDAO();
        Tratamiento tra = new Tratamiento(codigo);
        traDAO.borrar(tra);

        rs.sendRedirect("/JulsNails/Tratamiento/BuscarTrat.jsp");
    }
}
