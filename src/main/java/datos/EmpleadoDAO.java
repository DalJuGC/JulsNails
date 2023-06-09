package datos;

import modelo.Cliente;
import modelo.Empleado;

import java.util.ArrayList;
import java.sql.*;

public class EmpleadoDAO {
    public static final String selectSQL = "SELECT * FROM Empleado";
    public static final String insertSQL = "INSERT INTO Empleado(Codigo, Nombre, Cargo, Telefono, Domicilio, Fech_Con) VALUES (?,?,?,?,?,?);";
    public static final String updateSQL = "UPDATE Empleado SET Codigo = ?, Nombre = ?, Cargo = ?, Telefono = ?, Domicilio = ?, Fech_Con = ?";
    public static final String deleteSQL = "DELETE FROM Empleado WHERE Codigo = ?";
    public static final String consultSQL = "SELECT * FROM Empleado WHERE Codigo = ?";

    private Connection connection;

    public EmpleadoDAO(Connection connection){this.connection = connection;}
    //Muestra los clientes
    public ArrayList<Empleado> seleccionar() throws SQLException{
        ArrayList<Empleado> lista = new ArrayList<>();
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Empleado emp = null;
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Cargo = result.getString("Cargo");
                String Telefono = result.getString("Telefono");
                String Domicilio = result.getString("Domicilio");
                String Fech_Con = result.getString("Fech_Con");

                emp = new Empleado(Codigo, Nombre, Cargo, Telefono, Domicilio, Fech_Con);
                lista.add(emp);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public void insertar(Empleado empleado) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;

        conn = Conexion.getConnection();
        state = conn.prepareStatement(insertSQL);

        state.setInt(1,empleado.getCodigo());
        state.setString(2, empleado.getNombre());
        state.setString(3, empleado.getCargo());
        state.setString(4, empleado.getTelefono());
        state.setString(5, empleado.getDomicilio());
        state.setString(6, empleado.getFech_Con());
    }

    public void modificarNom(int Codigo, String Nombre) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Nombre);
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

    public void modificarCar(int Codigo, String Cargo) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Cargo);
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

    public void modificarTel(int Codigo, String Telefono) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

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

    public void modificarDom(int Codigo, String Domicilio) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Domicilio);
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

    public void modificarFech(int Codigo, String Fech_Con) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Fech_Con);
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

    public Empleado buscar(int Codigo) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;

        conn = Conexion.getConnection();
        state = conn.prepareStatement(consultSQL);

        Empleado empleado = new Empleado(result.getInt("Codigo"),
                result.getString("Nombre"),
                result.getString("Cargo"),
                result.getString("Telefono"),
                result.getString("Domicilio"),
                result.getString("Fech_Con"));
        Conexion.close(result);
        Conexion.close(state);

        return empleado;
    }

    public void borrar(int Codigo) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
