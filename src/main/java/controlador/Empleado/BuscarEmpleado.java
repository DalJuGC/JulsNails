package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "BuscarEmpleado", urlPatterns = {"/BuscarEmpleado"})
public class BuscarEmpleado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));

        EmpleadoDAO empDAO = new EmpleadoDAO();
        Empleado emp = empDAO.buscar(codigo);
        rq.getSession().setAttribute("Empleado", emp);

        rq.getRequestDispatcher("BuscarEmpleado.jsp").forward(rq, rs);
    }
}
