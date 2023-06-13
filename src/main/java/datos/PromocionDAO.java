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
    public static final String selectSQL = "SELECT * FROM promocion";
    public static final String insertSQL = "INSERT INTO promocion(nombre, precio, vigencia) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE promocion SET nombre = ?, precio = ?, vigencia = ? WHERE codigo = ?";
    public static final String deleteSQL = "DELETE FROM promocion WHERE codigo = ? ";

    private Connection connection;
    private PreparedStatement state;
    private ResultSet result;
    private Promocion promocion;

    //Lista las promociones registradas
    public List<Promocion> listar() {
        List<Promocion> prom = new ArrayList<>();

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(selectSQL);
            result = state.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                Boolean vigencia = result.getBoolean("vigencia");

                promocion = new Promocion(codigo, nombre, precio, vigencia);
                prom.add(promocion);
            }

            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prom;
    }

    //Agrega una promocion nueva a la tabla
    public void insertar(Promocion promocion) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(insertSQL);

            state.setString(1, promocion.getNombre());
            state.setFloat(2, promocion.getPrecio());
            state.setBoolean(3, promocion.getVigencia());

            if (state.executeUpdate()==1) {
                System.out.println(("Promocion registrada"));
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Modifica una promocion de la tabla
    public void modificar(Promocion promocion) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(updateSQL);

            state.setString(1, promocion.getNombre());
            state.setFloat(2, promocion.getPrecio());
            state.setBoolean(3, promocion.getVigencia());
            state.setInt(4, promocion.getCodigo());

            if (state.executeUpdate()==1) {
                System.out.println("Promocion actualizada");
            }

            Conexion.close(connection);
            Conexion.close(state);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de actualizacion");
        }
    }

    //Busca una promocion por su codigo
    public Promocion buscar(int cod) {
        //Promocion promocion = null;
        String consultSQL = "SELECT * FROM promocion WHERE codigo =" + cod;

        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(consultSQL);
            result = state.executeQuery();

            if (result.next()) {
                int codigo = result.getInt("codigo");
                String nombre = result.getString("nombre");
                Float precio = result.getFloat("precio");
                Boolean vigencia = result.getBoolean("vigencia");

                promocion = new Promocion(codigo, nombre, precio, vigencia);
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promocion;
    }

    //Borra una promocion de la tabla
    public void borrar(Promocion promocion) {
        try {
            connection = Conexion.getConnection();
            state = connection.prepareStatement(deleteSQL);

            state.setInt(1, promocion.getCodigo());

            if (state.executeUpdate()==1) {
                System.out.println("Promocion eliminada");
            }

            Conexion.close(connection);
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
