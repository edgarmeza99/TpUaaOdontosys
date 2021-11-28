import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    private static final String URL = "jdbc:postgresql://localhost:5432/Odontosys";
    private static final String USER = "postgres";
    private static final String PASS = "123456";
    private String driver = "org.postgresql.Driver";

    public Conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public Connection getCon() {
        return con;
    }

    public Connection getDesCon() throws SQLException {

        if (con != null) {
            con.close();
        } else {
            System.out.println("\nNO EXISTE CONEXION");
        }
        return con;
    }
}
