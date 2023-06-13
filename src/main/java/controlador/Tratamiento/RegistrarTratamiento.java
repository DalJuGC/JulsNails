package controlador.Tratamiento;

import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "RegistrarTratamiento", urlPatterns = {"/RegistrarTratamiento"})
public class RegistrarTratamiento extends HttpServlet {

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String nombre = rq.getParameter("nombre");
        Float precio = Float.valueOf(rq.getParameter("precio"));
        int cod_empleado = Integer.parseInt(rq.getParameter("cod_empleado"));

        TratamientoDAO traDAO = new TratamientoDAO();
        Tratamiento trat = new Tratamiento(nombre, precio, cod_empleado);
        traDAO.insertar(trat);

        rs.sendRedirect("/JulsNails/Tratamiento/RegistrarTrat.jsp");
    }
}
