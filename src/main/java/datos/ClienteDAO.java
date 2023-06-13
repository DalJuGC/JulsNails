package datos;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ClienteDAO {
    public static final String selectSQL = "SELECT * FROM cliente";
    public static final String insertSQL = "INSERT INTO cliente(nombre, telefono, domicilio) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE cliente SET nombre = ?, telefono = ?, domicilio = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM cliente WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Cliente cliente;

    //Lista los clientes registrados
    public List<Cliente> listar() {
        List<Cliente> cli = new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");

                cliente = new Cliente(codigo, nombre, telefono, domicilio);
                cli.add(cliente);
            }
            Conexion.close(state);
            Conexion.close(result);
            Conexion.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cli;
    }

    //Agrega un cliente nuevo a la tabla
    public int insertar(Cliente cliente) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, cliente.getNombre());
            state.setString(2, cliente.getTelefono());
            state.setString(3, cliente.getDomicilio());

            if (state.executeUpdate()==1) {
                System.out.println("Cliente registado correctamente");
                return 1;
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Modifica un cliente de la tabla
    public void modificar(Cliente cliente) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, cliente.getNombre());
            state.setString(2, cliente.getTelefono());
            state.setString(3, cliente.getDomicilio());
            state.setInt(4, cliente.getCodigo());

            if(state.executeUpdate()==1){
                System.out.println("Registro actualizado correctamente");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    //Busca un cliente por su codigo
    public Cliente buscar(int cod) {
        Cliente cliente = null;
        String consultSQL = "SELECT * FROM cliente WHERE codigo = " + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                String telefono = result.getString("telefono");
                String domicilio = result.getString("domicilio");

                cliente = new Cliente(codigo, nombre, telefono, domicilio);
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    //Borra un cliente de la tabla
    public void borrar(Cliente cliente) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);

            state.setInt(1, cliente.getCodigo());

            if (state.executeUpdate()==1){
                System.out.println("Cliente elimidado correctamente");
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
