package datos;

import java.sql.*;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteDAO{
    public static final String selectSQL = "SELECT * FROM Cliente";
    public static final String insertSQL = "INSERT INTO Cliente(Nombre, Telefono) VALUES (?,?);";
    public static final  String updateSQL = "UPDATE Cliente SET Nombre = ?, Telefono = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cliente WHERE Codigo = ? ";
    public static final String consultSQL = "SELECT * FROM Cliente WHERE Codigo = ?";
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    //Muestra los clientes
    public ArrayList<Cliente> seleccionar() throws SQLException{
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Cliente Cli = null;
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while (result.next()){
                int Codigo = result.getInt("codigo");
                String Nombre = result.getString("combre");
                String Telefono = result.getString("telefono");

                Cli = new Cliente(Codigo, Nombre, Telefono);
                lista.add(Cli);
            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lista;
    }

    public void insertar(Cliente cliente) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        //int registros=0;

        //try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1, cliente.getNombre());
            state.setString(2, cliente.getTelefono());
            state.executeUpdate();

           // registros = state.executeUpdate();

            //if(registros>0)
              //  System.out.println("Registro agregado correctamente");

            //Conexion.close(state);
            //Conexion.close(conn);

            //Cliente cliNew = new Cliente();

       // }catch (Exception e) {
           // e.printStackTrace();
        //}
       // return registros;
    }

    public void modificarNom(int Codigo, String Nombre) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Nombre);
            state.setInt(3, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarTel(int Codigo, String Telefono) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Telefono);
            state.setInt(2, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscar(int Codigo) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        Cliente Cliente = null;
        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(consultSQL);

            Cliente cliente = new Cliente(result.getInt("Codigo"),
                    result.getString("Nombre"),
                    result.getString("Telefono"));
            Conexion.close(result);
            Conexion.close(state);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Cliente;
    }

    public void borrar(int Codigo) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,Codigo);
            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");


            Conexion.close(state);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}