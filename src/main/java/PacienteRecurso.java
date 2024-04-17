import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteRecurso {
    static Conexion conn = new Conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Paciente> lstPaciente = new ArrayList<>();
    static List<Paciente> lstPorPaciente = new ArrayList<>();

    public static void crearPaciente(Paciente p) {
        try{
            sql = "INSERT INTO paciente(\"pacDocumento\", \"pacNombre\", \"pacTelefono\", \"pacDireccion\", \"pacTipPlan\")\n" +
                    "VALUES(?,?,?,?,?);";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getNumeroDoc());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTipoPlan());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }


    }

    public static void modPaciente(Paciente p) {
        try{
            sql = "UPDATE public.paciente SET  \"pacNombre\"=?, \"pacTelefono\"=?, \"pacDireccion\"=?, \"pacTipPlan\"=?" +
                    " WHERE \"pacDocumento\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getDireccion());
            ps.setString(4, p.getTipoPlan());
            ps.setString(5, p.getNumeroDoc());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public static void eliminarPaciente(Paciente p) {
        try{
            sql = "delete from paciente where \"pacDocumento\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getNumeroDoc());

            ps.executeUpdate();
            ps.close();
            System.err.println("eliminado");
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }



    public static List<Paciente> listarPaciente() throws SQLException {
        sql = "select * from paciente order by \"pacNombre\"";
        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Paciente pac = new Paciente();
            pac.setNumeroDoc(rs.getString(1));
            pac.setNombre(rs.getString(2));
            pac.setTelefono(rs.getString(3));
            pac.setDireccion(rs.getString(4));
            pac.setTipoPlan(rs.getString(5));
            lstPaciente.add(pac);
        }
        st.close();
        rs.close();
        return lstPaciente;
    }

    public static List<Paciente> porPaciente(Paciente p) throws SQLException {
        sql = "select * from paciente where \"pacDocumento\"=?";
        con = conn.getCon();
        ps = con.prepareStatement(sql);
        System.out.println(p.getNumeroDoc());
        ps.setString(1, p.getNumeroDoc());
        rs = ps.executeQuery();
        while (rs.next()) {
            Paciente pac = new Paciente();
            pac.setNumeroDoc(rs.getString(1));
            pac.setNombre(rs.getString(2));
            pac.setTelefono(rs.getString(3));
            pac.setDireccion(rs.getString(4));
            pac.setTipoPlan(rs.getString(5));
            lstPorPaciente.add(pac);
        }
        ps.close();
        rs.close();
        return lstPorPaciente;
    }

}
