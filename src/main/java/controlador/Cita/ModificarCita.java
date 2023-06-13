package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ModificarCita", urlPatterns = {"/ModificarCita"})
public class ModificarCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int codigo = Integer.parseInt(rq.getParameter("codigo"));
        Date fecha = Date.valueOf(rq.getParameter("fecha"));
        Time horario = Time.valueOf(rq.getParameter("horario"));
        int cod_tratamiento = Integer.parseInt(rq.getParameter("cod_tratamiento"));
        int cod_promocion = Integer.parseInt(rq.getParameter("cod_promocion"));
        Boolean cancelar = Boolean.valueOf("cancelara");

        CitaDAO citaDAO = new CitaDAO();
        Cita cita = new Cita(codigo, fecha, horario, cod_tratamiento, cod_promocion, cancelar);
        citaDAO.modificar(cita);

        rs.sendRedirect("/JulsNails/Cita/ModificarCita.jsp");
    }
}
