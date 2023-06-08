package controlador.Cliente;

import datos.ClienteDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVBrCliente", urlPatterns = {"/SVBrCliente"})
public class SVBrCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO();
            cliDAO.borrar(Codigo);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/ListaCliente,jsp");
    }
}
