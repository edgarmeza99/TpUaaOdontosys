import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRecurso {

    static Conexion conn = new Conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Consulta> lstConsulta = new ArrayList<>();
    static List<Consulta> lstPorConsulta = new ArrayList<>();

    public static void crearConsulta(Consulta c) {
        try{
            sql = "INSERT INTO consulta(\"consulta_id\", \"pac_nombre\", \"pac_documento\", \"doc_nombre\", \"fecha\", \"hora\")\n" +
                    "VALUES(?,?,?,?,?,?);";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, c.getIdConsulta());
            ps.setString(2, c.getNombrePac());
            ps.setString(3, c.getDocumentoPac());
            ps.setString(4, c.getNombreDoctor());
            ps.setString(5, c.getFecha());
            ps.setString(6, c.getHora());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }


    }

    public static void modConsulta(Consulta c) {
        try{
            sql = "UPDATE consulta SET  \"pac_nombre\"=?, \"pac_documento\"=?, \"doc_nombre\"=?, \"fecha\"=?, \"hora\"=?" +
                    " WHERE \"consulta_id\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, c.getNombrePac());
            ps.setString(2, c.getDocumentoPac());
            ps.setString(3, c.getNombreDoctor());
            ps.setString(4, c.getFecha());
            ps.setString(5, c.getHora());
            ps.setString(6, c.getIdConsulta());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public static void eliminarConsulta(Consulta c) {
        try{
            sql = "delete from consulta where \"consulta_id\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, c.getIdConsulta());
            ps.executeUpdate();
            ps.close();
            System.err.println("eliminado");
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public static List<Consulta> listarConsulta() throws SQLException {
        sql = "select * from consulta;";
        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Consulta cons = new Consulta();
            cons.setIdConsulta(rs.getString(1));
            cons.setNombrePac(rs.getString(2));
            cons.setDocumentoPac(rs.getString(3));
            cons.setNombreDoctor(rs.getString(4));
            cons.setFecha(rs.getString(5));
            cons.setHora(rs.getString(6));
            lstConsulta.add(cons);
        }
        st.close();
        rs.close();
        return lstConsulta;
    }

    public static List<Consulta> porConsulta(Consulta c) throws SQLException {
        sql = "select * from consulta where \"consulta_id\"=?;";
        con = conn.getCon();
        ps = con.prepareStatement(sql);

        ps.setString(1, c.getIdConsulta());
        rs = ps.executeQuery();
        while (rs.next()) {
            Consulta cons = new Consulta();
            cons.setIdConsulta(rs.getString(1));
            cons.setNombrePac(rs.getString(2));
            cons.setDocumentoPac(rs.getString(3));
            cons.setNombreDoctor(rs.getString(4));
            cons.setFecha(rs.getString(5));
            cons.setHora(rs.getString(6));
            lstPorConsulta.add(cons);
        }
        ps.close();
        rs.close();
        return lstPorConsulta;
    }
}
