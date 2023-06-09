package controlador.Cliente;

import modelo.Cliente;
import datos.ClienteDAO;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "SVRCliente", urlPatterns ={"/SVRCliente"})
public class SVRCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private String Nombre;
    private String Telefono;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Nombre = rq.getParameter("Nombre");
        Telefono = rq.getParameter("Telefono");

        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO();
            Cliente cli = new Cliente(Nombre, Telefono);
            cliDAO.insertar(cli);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/RegistrarCliente.jsp");
    }
}
