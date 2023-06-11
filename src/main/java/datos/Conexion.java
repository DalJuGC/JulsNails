package datos;

import java.sql.*;
public class Conexion {
    private static String user = "postgres";
    private static String pswd = "password";
    private static String bd = "JulsNails";
    private static String server = "jdbc:postgresql://localhost:5432/" + bd;
    private static String driver = "org.postgresql.Driver";

    public static Connection getConnection() {
        try{
            Class.forName(driver);
            return DriverManager.getConnection(server, user, pswd);
        } catch (SQLException e) {
            System.out.println("Error al intentar conectarse a la BD" + server);
        } catch (ClassNotFoundException e) {
            System.out.println("Error");

        }
        return null;
    }

    public static void close(ResultSet result){
        try{
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement state){
        try{
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try{
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
