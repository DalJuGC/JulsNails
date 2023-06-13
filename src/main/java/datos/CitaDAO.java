package datos;

import modelo.Cita;
import modelo.Cliente;
import modelo.Tratamiento;
import modelo.Promocion;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CitaDAO {
    public static final String selectSQL = "SELECT * FROM cita ORDER BY codigo";
    public static final String insertSQL = "INSERT INTO cita(cod_cliente, fecha, horario, cod_tratamiento, cod_promocion, cancelar) VALUES (?,?,?,?,?,?)";
    public static final String updateSQL = "UPDATE cita SET fecha = ?, horario = ?, cod_tratamiento = ?, cod_promocion = ? WHERE codigo = ?";
    public static final String deleteSQL = "UPDATE cita SET cancelar = true WHERE codigo = ? ";



    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Cliente cliente;
    private Tratamiento tratamiento;
    private Promocion promocion;
    private  Cita cita;

    //Lista las citas registrados
    public List<Cita> listar() {
        List<Cita> cit =  new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                int cod_cliente = result.getInt("cod_cliente");
                Date fecha = result.getDate("fecha");
                Time horario = result.getTime("horario");
                int cod_tratamiento = result.getInt("cod_tratamiento");
                int cod_promocion = result.getInt("cond_promocion");
                Boolean cancelar = result.getBoolean("cancelar");

                cita = new Cita(codigo, cod_cliente, fecha, horario, cod_tratamiento,cod_promocion,cancelar);
                cit.add(cita);
            }

            Conexion.close(state);
            Conexion.close(state);
            Conexion.close(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cit;
    }

    //Agrega una cita nueva a la tabla
    public void insertar(Cita cita) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setInt(1, cita.getCod_cliente());
            state.setDate(2, cita.getFecha());
            state.setTime(3, cita.getHorario());
            state.setInt(4, cita.getCod_tratamiento());
            state.setInt(5, cita.getCod_promocion());

            if (state.executeUpdate()==1) {
                System.out.println("Cita registrada");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica una cita de la tabla
    public void modificar(Cita cita) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setDate(1, cita.getFecha());
            state.setTime(2, cita.getHorario());
            state.setInt(3, cita.getCod_tratamiento());
            state.setInt(4, cita.getCod_promocion());

            if (state.executeUpdate()==1) {
                System.out.println("Cita actualizada");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de actualizacion");
        }
    }

    //Busca una cita por su codigo
    public Cita buscar(int cod) {
        Cita cita = null;
        String consultSQL = "SELECT * FROM cita WHERE codigo =" + cod;
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                int cod_cliente = result.getInt("cod_cliente");
                Date fecha = result.getDate("fecha");
                Time horario = result.getTime("horario");
                int cod_tratamiento = result.getInt("cod_tratamiento");
                int cod_promocion = result.getInt("cod_promocion");
                Boolean cancelar = result.getBoolean("cancelar");

                cita = new Cita(codigo);
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    //Borra una cita de la tabla
    public void borrar(Cita cita) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);

            state.setInt(1, cita.getCodigo());

            if (state.executeUpdate()==1) {
                System.out.println("Cita eliminada");
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
