package datos;

import modelo.Cliente;
import modelo.Promocion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromocionDAO {
    public static final String selectSQL = "SELECT * FROM Promocion";
    public static final String insertSQL = "INSERT INTO Promocion(codigo, nombre, precio, vogencia) VALUES (?,?,?,?)";
    public static final String updateSQL = "UPDATE Promocion SET nombre = ?, precio = ?, vigencia = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM Promocion WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Promocion promocion;

    public PromocionDAO(Connection connection) {
        this.connection = connection;
    }

    //Lista las promociones registradas
    public List<Promocion> listar() {
        List<Promocion> prom = new ArrayList<>();

        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                Boolean vigencia = result.getBoolean("vigencia");

                Promocion promocion = new Promocion(codigo, nombre, precio, vigencia);
                prom.add(promocion);
            }
            state.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prom;
    }

    //Agrega una promocion nueva a la tabla
    public void insertar(Promocion promocion) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, promocion.getNombre());
            state.setFloat(2, promocion.getPrecio());
            state.setBoolean(3, promocion.getVigencia());
            state.executeUpdate();

            //connection.close();
            //state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica una promocion de la tabla
    public void modificar(Promocion promocion) {
        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, promocion.getNombre());
            state.setFloat(2, promocion.getPrecio());
            state.setBoolean(3, promocion.getVigencia());
            state.setInt(4, promocion.getCodigo());
            state.executeUpdate();

            //connection.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Busca una promocion por su codigo
    public Promocion buscar(int cod) {
        String consultSQL = "SELECT * FROM Promocion WHERE codigo = ?" + cod;

        try {
            //connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            //state.setInt(1, codigo);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                Boolean vigencia = result.getBoolean("vigencia");

                promocion = new Promocion(codigo, nombre, precio, vigencia);
            }

            state.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promocion;
    }

    //Borra una promocion de la tabla
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
