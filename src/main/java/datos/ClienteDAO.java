package datos;

import modelo.Cliente;

import java.util.ArrayList;
import java.sql.*;

public class ClienteDAO{
    public static final String selectSQL = "SELECT * FROM Cliente";
    public static final String insertSQL = "INSERT INTO Cliente(Codigo, Nombre, Telefono) VALUES (?,?,?);";
    public static final  String updateSQL = "UPDATE Cliente SET Codigo = ?, Nombre = ?, Telefono = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cliente WHERE Codigo = ? ";
    public static final String consultSQL = "SELECT * FROM Cliente WHERE Codigo = ?";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Cliente cli;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    //Muestra la lista de clientes registrados
    public ArrayList<Cliente> listar() throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<>();
        connection = Conexion.getConnection();
        state = (PreparedStatement) connection.createStatement();
        result = state.executeQuery(selectSQL);

         while (result.next()){
            int Codigo = result.getInt("codigo");
            String Nombre = result.getString("combre");
            String Telefono = result.getString("telefono");

            cli = new Cliente(Codigo, Nombre, Telefono);
            lista.add(cli);
        }
        Conexion.close(connection);
        Conexion.close(state);
        Conexion.close(result);
        return lista;
    }

    //Agrega un cliente más a la tabla
    public void insertar(Cliente cliente) throws SQLException{

        connection = Conexion.getConnection();
        state = connection.prepareStatement(insertSQL);

        state.setInt(1, cliente.getCodigo());
        state.setString(2, cliente.getNombre());
        state.setString(3, cliente.getTelefono());
        state.executeUpdate();

        Conexion.close(connection);
        Conexion.close(state);
    }

    //Modifica el nombre del cliente
    public void modificarNom(int Codigo, String Nombre) throws SQLException{

        connection = Conexion.getConnection();
        state = connection.prepareStatement(updateSQL);

        state.setString(1, Nombre);
        state.setInt(3, Codigo);
        state.executeUpdate();

        Conexion.close(connection);
        Conexion.close(state);
    }

    //Modifica el numero de telefono del cliente
    public void modificarTel(int Codigo, String Telefono) throws SQLException{

        connection = Conexion.getConnection();
        state = connection.prepareStatement(updateSQL);

        state.setString(1, Telefono);
        state.setInt(3, Codigo);
        state.executeUpdate();

        Conexion.close(connection);
        Conexion.close(state);
    }

    //Busca un cliente por su Codigo
    public Cliente buscar(int Codigo) throws SQLException{

        connection = Conexion.getConnection();
        state = connection.prepareStatement(consultSQL);
        state.setInt(1, Codigo);

        if (result.next()){
            Conexion.close(result);
            Conexion.close(state);
        }

        Cliente cliente = new Cliente(result.getInt("Codigo"),
                result.getString("Nombre"),
                result.getString("Telefono"));
        Conexion.close(result);
        Conexion.close(state);
        return cliente;
    }

    //Borra un cliente
    public void borrar(int Codigo) throws SQLException{

        connection = Conexion.getConnection();
        state = connection.prepareStatement(deleteSQL);

        state.setInt(1,Codigo);
        state.executeUpdate();
        
        Conexion.close(state);
    }
}