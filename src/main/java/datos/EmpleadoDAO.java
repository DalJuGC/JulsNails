package datos;

import modelo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmpleadoDAO {
    public static final String selectSQL = "SELECT * FROM empleado";
    public static final String insertSQL = "INSERT INTO empleado(codigo, nombre, cargo, telefono, domicilio, fecha_contrato) VALUES (?,?,?,?,?,?)";
    public static final String updateSQL = "UPDATE empleado SET nombre = ?, cargo = ?, telefono = ?, domicilio = ? fecha_contrato = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM empleado WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Empleado empleado;

    public EmpleadoDAO(Connection connection) {
        this.connection = connection;
    }

    //Lista los empleado registrados
    public List<Empleado> listar() {
        List<Empleado> emp = new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String cargo = result.getString("cargo");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");
                Date fecha_contrato = result.getDate("fecha_contrato");

                Empleado empleado = new Empleado(codigo, nombre, cargo, telefono, domicilio, fecha_contrato);
                emp.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    //Agrega un empleado nuevo a la tabla
    public void insertar(Empleado empleado) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, empleado.getNombre());
            state.setString(2, empleado.getCargo());
            state.setString(3, empleado.getTelefono());
            state.setString(4, empleado.getDomicilio());
            state.setDate(5, empleado.getFecha_contrato());
            state.executeUpdate();

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica un empleado de la tabla
    public void modificar(Empleado empleado) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, empleado.getNombre());
            state.setString(2, empleado.getCargo());
            state.setString(3, empleado.getTelefono());
            state.setString(4, empleado.getDomicilio());
            state.setDate(5, empleado.getFecha_contrato());
            state.setInt(6, empleado.getCodigo());
            state.executeUpdate();

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca un empleado por su codigo
    public Empleado buscar(int cod) {
        String consultSQL = "SELECT * FROM empleado WHERE codigo = ?" + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            //state.setInt(1, codigo);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String cargo = result.getString("cargo");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");
                Date fecha_contrato = result.getDate("fecha_contrato");

                empleado = new Empleado(codigo, nombre, cargo, telefono, domicilio, fecha_contrato);
            }

            connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }

    //Borra un empleado de la tabla
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
