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
import java.util.ArrayList;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVBsCliente", urlPatterns = {"/SVBsCliente"})
public class SVBsCliente extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException{
        Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        try{
            Connection connection = conexion.getConnection();
            ClienteDAO cliDAO = new ClienteDAO(connection);
            Cliente cli = cliDAO.buscar(Codigo);

            if(cli != null){
                rq.getSession().setAttribute("Codigo", cli.getCodigo());
                rq.getSession().setAttribute("Encontrado", true);
            }else{
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("Encontrado", false);
            }
            rq.getSession().setAttribute("Codigo", null);
            rq.getSession().setAttribute("datos", cli);

            connection.close();
        }catch (SQLException e){
            rq.getSession().setAttribute("Encontrado", false);
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cliente/ListaCliente.jsp");
    }
}