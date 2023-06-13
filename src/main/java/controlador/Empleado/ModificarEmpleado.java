package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ModificarEmpleado", urlPatterns = {"/ModificarEmpleado"})
public class ModificarEmpleado extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String cargo = rq.getParameter("cargo");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");
        Date fecha_contrato = Date.valueOf(rq.getParameter("fecha_contrato"));

        EmpleadoDAO empDAO = new EmpleadoDAO();
        Empleado emp = new Empleado(codigo, nombre, cargo,telefono, domicilio, fecha_contrato);
        empDAO.modificar(emp);

        rs.sendRedirect("/JulsNails/Empleado/ModificarEmp.jsp");
    }
}
