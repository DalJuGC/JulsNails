package datos;

import modelo.Cita;
import modelo.Cliente;
import modelo.Tratamiento;
import modelo.Promocion;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CitaDAO {
    public static final String selectSQL = "SELECT Cita.codigo, Cliente.nombre AS cliente, Cita.fecha, Cita.horario, Tratamiento.nombre AS tratamiento, Promocion.nombre AS promocion, Cita.cancelar FROM Cita" +
    "JOIN Tratamiento ON Cita.codigo = Tratamiento.codigo\n" +
    "JOIN Cliente ON Cita.codigo = Cliente.codigo\n" +
    "JOIN Promocion ON Cita.codigo = Promocion.codigo\n" +
    "ORDER BY Cita.fecha, Cita.horario";
    public static final String insertSQL = "INSERT INTO Cita(codigo, cod_cliente, fecha, horario, cod_tratamiento, cod_promocion, cancelar) VALUES (?,?,?,?,?,?,?)";
    public static final String updateSQL = "UPDATE Cita SET fecha = ?, horario = ?, cod_tratamiento = ?, cod_promocion = ? WHERE codigo = ?";
    public static final String deleteSQL = "UPDATE Cita SET cancelar = true WHERE codigo = ? ";



    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Cliente cliente;
    private Tratamiento tratamiento;
    private Promocion promocion;
    private  Cita cita;


    public CitaDAO(Connection connection) {
        this.connection = connection;
    }

    //Lista las citas registrados
    public List<Cita> listar() {
        List<Cita> cit =  new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                cliente = new Cliente(nombre);

                //nombre = result.getString("nombre");
               tratamiento = new Tratamiento(nombre);

                //nombre = result.getString("nombre");
                promocion = new Promocion(nombre);

                Date fecha = result.getDate("fecha");
                Time horario = result.getTime("horario");
                Boolean cancelar = result.getBoolean("cancelar");
                cita = new Cita(codigo, fecha, horario, cancelar);
                cit.add(cita);
            }

            //connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cit;
    }

    //Agrega una cita nueva a la tabla
    public void insertar(Cita cita) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setInt(1, cita.getCod_cliente());
            state.setDate(2, cita.getFecha());
            state.setTime(3, cita.getHorario());
            state.setInt(4, cita.getCod_tratamiento());
            state.setInt(5, cita.getCod_promocion());
            state.executeUpdate();

            //connection.close();
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica una cita de la tabla
    public void modificar(Tratamiento tratamiento) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setDate(1, cita.getFecha());
            state.setTime(2, cita.getHorario());
            state.setInt(3, cita.getCod_tratamiento());
            state.setInt(4, cita.getCod_promocion());
            state.executeUpdate();

            //connection.close();
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca una cita por su codigo
    public Cita buscar(int cod) {
        String consultSQL = "SELECT * FROM Cita WHERE codigo = ?" + cod;
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            //state.setInt(1, codigo);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                int cod_cliente = result.getInt("cod_cliente");
                Date fecha = result.getDate("fecha");
                Time horario = result.getTime("horario");
                int cod_tratamiento = result.getInt("cod_tratamiento");
                int cod_promocion = result.getInt("cod_promocion");
                Boolean cancelar = result.getBoolean("cancelar");

                cita = new Cita(codigo, cod_cliente, fecha, horario, cod_tratamiento, cod_promocion, cancelar);
            }

            //connection.close();
            result.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    //Borra una cita de la tabla
    public void borrar(int codigo) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);
            state.setInt(1, codigo);
            state.executeUpdate();

            //connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
