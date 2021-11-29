import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    private static final String URL = "jdbc:postgresql://ec2-23-23-219-25.compute-1.amazonaws.com:5432/dfdlpunnuqeqro";
    private static final String USER = "szflsvqhblddzz";
    private static final String PASS = "26eceeaee4f49878756859f408aee4f238c8645e5b1b39bd4abea66712e07f27";
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
