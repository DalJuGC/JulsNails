package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaEmpleado", urlPatterns = {"/ListaEmpleado"})
public class ListaEmpleado extends HttpServlet{

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        EmpleadoDAO empDAO = new EmpleadoDAO();
        List<Empleado> lista = empDAO.listar();
        rq.setAttribute("datos", lista);

        rq.getRequestDispatcher("ListaEmpleado.jsp").forward(rq, rs);
    }
}
