package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;
    private String URL = //"jdbc:sqlserver://LAPTOP-IOHMRPVT\\SQLEXPRESS:50702;"
            "jdbc:sqlserver://DESKTOP-PDIBPF7\\SQLEXPRESS:61282;"
            + "database=Odontosys;"
            + "user=sa;"
            + "password=1;"
            + "loginTimeout=30;";
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerXADataSource";

    public Conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public Connection getCon() {
        System.out.println("conectado");
        return con;
    }

    public Connection getDesCon() throws SQLException {

        if (con != null) {
            System.out.println("Desconectado!");
            con.close();
        } else {
            System.out.println("\nNO EXISTE CONEXION");
        }
        return con;
    }
}
