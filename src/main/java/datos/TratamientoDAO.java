package datos;

import modelo.Empleado;
import modelo.Tratamiento;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class TratamientoDAO {
    public static final String selectSQL = "SELECT * FROM tratamiento";
    public static final String insertSQL = "INSERT INTO Tratamiento(nombre, precio, cod_empleado) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE Tratamiento SET nombre = ?, precio = ?, cod_empleado = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM Tratamiento WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Tratamiento tratamiento;
    private Empleado empleado;

    //Lista los tratamiento registrados
    public List<Tratamiento> listar() {
        List<Tratamiento> trat =  new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("telefono");
                int cod_empleado = result.getInt("cod_empleado");

                tratamiento = new Tratamiento(codigo, nombre, precio, cod_empleado);
                trat.add(tratamiento);
            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(connection);
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

            if (state.executeUpdate()==1) {
                System.out.println("Tratamiento registrado");
            }

            Conexion.close(connection);
            Conexion.close(state);
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

            if (state.executeUpdate()==1) {
                System.out.println("Tratamiento actualizado");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de actualizacion");
        }
    }

    //Busca un tratamiento por su codigo
    public Tratamiento buscar(int cod) {
        String consultSQL = "SELECT * FROM tratamiento WHERE codigo =" + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                int cod_empleado = result.getInt("cod_empleado");

                tratamiento = new Tratamiento(codigo, nombre, precio, cod_empleado);
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamiento;
    }

    //Borra un tratamiento de la tabla
    public void borrar(Tratamiento tratamiento) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);

            state.setInt(1, tratamiento.getCodigo());

            if (state.executeUpdate()==1) {
                System.out.println("Tratamiento eliminado");
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}