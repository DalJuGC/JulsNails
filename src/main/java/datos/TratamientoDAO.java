package datos;

import modelo.Empleado;
import modelo.Tratamiento;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class TratamientoDAO {
    public static final String selectSQL = "SELECT Tratamiento.codigo, Tratamiento.nombre AS Tratamiento, Tratamiento.precio, Empleado.nombre AS Empleado FROM Tratamiento\n" +
            "JOIN Empleado ON Tratamiento.cod_empleado = Empleado.codigo";
    public static final String insertSQL = "INSERT INTO tratamiento(codigo, nombre, precio, cod_empleado) VALUES (?,?,?,?)";
    public static final String updateSQL = "UPDATE tratamiento SET nombre = ?, precio = ?, cod_empleado = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM tratamiento WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Tratamiento tratamiento;
    private Empleado empleado;

    public TratamientoDAO(Connection connection) {
        this.connection = connection;
    }

    //Lista los tratamiento registrados
    public List<Tratamiento> listar() {
        List<Tratamiento> trat =  new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                String nombre = result.getString("Empleado");
                empleado = new Empleado(nombre);

                int codigo = result.getInt("codigo");
                nombre = result.getString("nombre");
                Float precio = result.getFloat("telefono");
                int cod_empleado = result.getInt("cod_empleado");

                Tratamiento tratamiento = new Tratamiento(codigo, nombre, precio, cod_empleado);
                trat.add(tratamiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trat;
    }

    //Agrega un tratamiento nuevo a la tabla
    public void insertar(Tratamiento tratamiento) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, tratamiento.getNombre());
            state.setFloat(2, tratamiento.getPrecio());
            state.setInt(3, tratamiento.getCod_empleado());
            state.executeUpdate();

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica un tratamiento de la tabla
    public void modificar(Tratamiento tratamiento) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, tratamiento.getNombre());
            state.setFloat(2, tratamiento.getPrecio());
            state.setInt(3, tratamiento.getCod_empleado());
            state.setInt(4, tratamiento.getCodigo());
            state.executeUpdate();

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca un tratamiento por su codigo
    public Tratamiento buscar(int cod) {
        String consultSQL = "SELECT * FROM tratamiento WHERE codigo = ?" + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            //state.setInt(1, codigo);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                int cod_empleado = result.getInt("cod_empleado");

                tratamiento = new Tratamiento(codigo, nombre, precio, cod_empleado);
            }

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamiento;
    }

    //Borra un tratamiento de la tabla
    public void borrar(int codigo) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);
            state.setInt(1, codigo);
            state.executeUpdate();

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}