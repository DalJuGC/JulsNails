package datos;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ClienteDAO {
    public static final String selectSQL = "SELECT * FROM Cliente";
    public static final String insertSQL = "INSERT INTO Cliente(codigo, nombre, telefono, domicilio) VALUES (?,?,?,?)";
    public static final String updateSQL = "UPDATE Cliente SET nombre = ?, telefono = ?, domicilio = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM Cliente WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Cliente cliente;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    //Lista los clientes registrados
    public List<Cliente> listar() {
        List<Cliente> cli = new ArrayList<>();

        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");

                Cliente cliente = new Cliente(codigo, nombre, telefono, domicilio);
                cli.add(cliente);
            }
            state.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cli;
    }

    //Agrega un cliente nuevo a la tabla
    public void insertar(Cliente cliente) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, cliente.getNombre());
            state.setString(2, cliente.getTelefono());
            state.setString(3, cliente.getDomicilio());
            state.executeUpdate();

            //connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica un cliente de la tabla
    public void modificar(Cliente cliente) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, cliente.getNombre());
            state.setString(2, cliente.getTelefono());
            state.setString(3, cliente.getDomicilio());
            state.setInt(4, cliente.getCodigo());
            state.executeUpdate();

            //connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca un cliente por su codigo
    public Cliente buscar(int cod) {
        String consultSQL = "SELECT * FROM Cliente WHERE codigo = ?" + cod;

        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            //state.setInt(1, codigo);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");

                cliente = new Cliente(codigo, nombre, telefono, domicilio);
            }

            state.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    //Borra un cliente de la tabla
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
