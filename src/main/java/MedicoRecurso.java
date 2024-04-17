
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoRecurso {

    static Conexion conn = new Conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Medico> lstMedico = new ArrayList<>();
    static List<Medico> lstPorMedico = new ArrayList<>();

    public static void crearMedico(Medico m) {
        try{
            sql = "INSERT INTO medico (med_registro,med_nombre,med_direccion,med_telefono,med_correo, med_estado)\n" +
                    "VALUES(?,?,?,?,?,?);";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, m.getMed_registro());
            ps.setString(2, m.getMed_nombre());
            ps.setString(3, m.getMed_direccion());
            ps.setString(4, m.getMed_telefono());
            ps.setString(5, m.getMed_correo());
            ps.setString(6, m.getMed_estado());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void modMedico(Medico m) {
        try{
            sql = "UPDATE medico SET med_nombre = ?, med_direccion = ?, med_telefono = ?, med_correo = ?,  med_estado = ?\n" +
                    " WHERE med_registro=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, m.getMed_nombre());
            ps.setString(2, m.getMed_direccion());
            ps.setString(3, m.getMed_telefono());
            ps.setString(4, m.getMed_correo());
            ps.setString(5, m.getMed_estado());
            ps.setString(6, m.getMed_registro());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    public static void eliminarMedico(Medico m) {
        try{
            sql = "delete from medico where med_registro=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, m.getMed_registro());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static List<Medico> listarMedico() throws SQLException {
        sql = "select * from medico order by med_nombre";
        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Medico med = new Medico();
            med.setMed_registro(rs.getString(1));
            med.setMed_nombre(rs.getString(2));
            med.setMed_direccion(rs.getString(3));
            med.setMed_telefono(rs.getString(4));
            med.setMed_correo(rs.getString(5));
            med.setMed_estado(rs.getString(6));
            lstMedico.add(med);
        }
        st.close();
        rs.close();
        return lstMedico;
    }

    public static List<Medico> porMedico(Medico m) throws SQLException {
        sql = "select * from medico where med_registro=?";
        con = conn.getCon();
        ps = con.prepareStatement(sql);
        ps.setString(1, m.getMed_registro());
        rs = ps.executeQuery();
        while (rs.next()) {
            Medico med = new Medico();
            med.setMed_registro(rs.getString(1));
            med.setMed_nombre(rs.getString(2));
            med.setMed_direccion(rs.getString(3));
            med.setMed_telefono(rs.getString(4));
            med.setMed_correo(rs.getString(5));
            med.setMed_estado(rs.getString(6));
            lstPorMedico.add(med);
        }
        ps.close();
        rs.close();
        return lstPorMedico;
    }

}
