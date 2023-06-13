package controlador.Cita;

import modelo.Cita;
import datos.CitaDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegistrarCita", urlPatterns = {"/RegistrarCita"})
public class RegistrarCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException,IOException {
        int cod_cliente = Integer.parseInt(rq.getParameter("cod_cliente"));
        Date fecha = Date.valueOf(rq.getParameter("fecha"));
        Time horario = Time.valueOf(rq.getParameter("horario"));
        int cod_tratamiento = Integer.parseInt(rq.getParameter("cod_tratamiento"));
        int cod_promocion = Integer.parseInt(rq.getParameter("cod_promocion"));

        CitaDAO citaDAO = new CitaDAO();
        Cita cita = new Cita(cod_cliente, fecha, horario, cod_tratamiento, cod_promocion);
        citaDAO.insertar(cita);

        rs.sendRedirect("/JulsNails/Cita/RegistrarCita.jsp");
    }
}
