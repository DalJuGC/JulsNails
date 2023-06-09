package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDAO{
    public static final String selectSQL = "SELECT * FROM Cliente";
    public static final String insertSQL = "INSERT INTO Cliente(Nombre, Telefono) VALUES (?,?)";
    public static final  String updateSQL = "UPDATE Cliente SET Nombre = ?, Telefono = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cliente WHERE Codigo = ? ";
    public static final String consultSQL = "SELECT * FROM Cliente WHERE Codigo = ?";
    
    //Muestra los clientes
    public List<Cliente> seleccionar() throws SQLException{
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Cliente Cli = null;

        List<Cliente> Cliente = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Telefono = result.getString("Telefono");

                Cli = new Cliente(Codigo, Nombre, Telefono);
                Cliente.add(Cli);
            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

            for(Cliente cliente: Cliente){
                System.out.println("Código: " + cliente.getCodigo());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Telefono: " + cliente.getTelefono());
                System.out.println(" \n ");
            }
        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Cliente;
    }

    public void insertar(Cliente cliente) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,cliente.getNombre());
            state.setString(2,cliente.getTelefono());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
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