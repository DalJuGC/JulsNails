package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "ModificarTratamiento", urlPatterns = {"/ModificarTratamiento"})
public class ModificarTratamiento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        Float precio = Float.valueOf(rq.getParameter("precio"));
        int cod_empleado = Integer.parseInt(rq.getParameter("cod_empleado"));

        TratamientoDAO traDAO = new TratamientoDAO();
        Tratamiento trat = new Tratamiento(codigo, nombre, precio, cod_empleado);
        traDAO.modificar(trat);

        rs.sendRedirect("/JulsNails/Tratamiento/ModificarTrat.jsp");
    }
}
