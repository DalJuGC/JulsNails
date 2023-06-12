package controlador.Empleado;

import datos.EmpleadoDAO;
import modelo.Empleado;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ModificarEmpleado", urlPatterns = {"/ModificarEmpleado"})
public class ModificarEmpleado extends HttpServlet{
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        String nombre = rq.getParameter("nombre");
        String cargo = rq.getParameter("cargo");
        String telefono = rq.getParameter("telefono");
        String domicilio = rq.getParameter("domicilio");
        Date fecha_contrato = Date.valueOf(rq.getParameter("fecha_contrato"));

        try {
            Connection connection = conexion.getConnection();

            EmpleadoDAO empDAO = new EmpleadoDAO(connection);
            Empleado emp = empDAO.buscar(codigo);

            emp.setNombre(nombre);
            emp.setCargo(cargo);
            emp.setTelefono(telefono);
            emp.setDomicilio(domicilio);
            emp.setFecha_contrato(fecha_contrato);

        } catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/JulsNails/Empleado/ListaEmpleado.jsp");
    }
}
