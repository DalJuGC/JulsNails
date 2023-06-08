package controlador.Empleado;

import modelo.Empleado;
import datos.EmpleadoDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVBsEmpleado", urlPatterns = {"/SVBsEmpleado"})
public class SVBsEmpleado extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            EmpleadoDAO empDAO = new EmpleadoDAO();
            Empleado emp = empDAO.buscar(Codigo);
            List<Empleado> empleado =empDAO.listar(Codigo);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
