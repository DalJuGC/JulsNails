package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BorrarEmpleado", urlPatterns = {"/BorrarEmpleado"})
public class BorrarEmpleado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        EmpleadoDAO empDAO = new EmpleadoDAO();
        Empleado emp = new Empleado(codigo);
        empDAO.borrar(emp);

        rs.sendRedirect("/JulsNails/Empleado/BuscarEmpleado.jsp");
    }
}
