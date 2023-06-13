package datos;

import modelo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmpleadoDAO {
    public static final String selectSQL = "SELECT * FROM empleado";
    public static final String insertSQL = "INSERT INTO empleado(nombre, cargo, telefono, domicilio, fecha_contrato) VALUES (?,?,?,?,?)";
    public static final String updateSQL = "UPDATE empleado SET nombre = ?, cargo = ?, telefono = ?, domicilio = ?, fecha_contrato = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM empleado WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Empleado empleado;

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

                empleado = new Empleado(codigo, nombre, cargo, telefono, domicilio, fecha_contrato);
                emp.add(empleado);
            }

            Conexion.close(state);
            Conexion.close(result);
            Conexion.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    //Agrega un empleado nuevo a la tabla
    public void insertar(Empleado empleado) {
        try {
            connection = Conexion.getConnection();
            //state.setInt(1, empleado.getCodigo());
            state = connection.prepareStatement(insertSQL);

            state.setString(1, empleado.getNombre());
            state.setString(2, empleado.getCargo());
            state.setString(3, empleado.getTelefono());
            state.setString(4, empleado.getDomicilio());
            state.setDate(5, empleado.getFecha_contrato());

            if (state.executeUpdate()==1) {
                System.out.println("Empleado registrado");
            }

            Conexion.close(connection);
            Conexion.close(state);
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

            if (state.executeUpdate()==1) {
                System.out.println("Empleado actualizado");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actializar");
        }
    }

    //Busca un empleado por su codigo
    public Empleado buscar(int cod) {
        Empleado empleado = null;
        String consultSQL = "SELECT * FROM empleado WHERE codigo =" + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
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

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }

    //Borra un empleado de la tabla
    public void borrar(Empleado empleado) {

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);

            state.setInt(1, empleado.getCodigo());

            if (state.executeUpdate()==1) {
                System.out.println("Empleado elimidado");
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
