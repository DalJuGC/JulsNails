package controlador.Cliente;

import datos.ClienteDAO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "ListaCliente", urlPatterns = {"/ListaCliente"})
public class ListaCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try {
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO(connection);
            rq.getSession().setAttribute("datos", cliDAO.listar());

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rq.getRequestDispatcher("ListaCliente.jsp").forward(rq, rs);
    }
}
