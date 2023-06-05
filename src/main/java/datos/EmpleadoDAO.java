package datos;

import modelo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class EmpleadoDAO {
    public static final String selectSQL = "SELECT * FROM Empleado";
    public static final String insertSQL = "INSERT INTO Empleado(Nombre, Cargo, Telefono) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE Empleado SET Nombre = ?, Cargo = ?, Telefono = ?";
    public static final String deleteSQL = "DELETE FROM Empleado WHERE Codigo = ?";

    //Muestra los clientes

    public List<Empleado> seleccionar() throws SQLException{
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Empleado emp = null;

        List<Empleado> Empleado = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Cargo = result.getString("Cargo");
                String Telefono = result.getString("Telefono");

                emp = new Empleado(Codigo, Nombre, Cargo, Telefono);
                Empleado.add(emp);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Empleado;
    }
}
