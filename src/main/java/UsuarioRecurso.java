import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRecurso {
    static Conexion conn = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static List<Usuario> lstUsuario = new ArrayList<>();
    static Usuario usr = new Usuario();

    public static String crearUsuario(Usuario u) throws SQLException {
        String mensaje = "";
        try {
            sql = "INSERT INTO public.usuario(\"usrNombre\", \"usrMail\", \"usrPass\", \"usrTelefono\", \"usrRol\")\n" +
                    "\tVALUES (?, ?, ?, ?, ?); ";
            System.out.println(u.toString());
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getMail());
            ps.setString(3, u.getPass());
            ps.setString(4,u.getTelefono());
            ps.setString(5,u.getRol());
            ps.executeUpdate();
            mensaje = "Se registro Correctamente";
        } catch (Exception e) {
            System.out.println(e);
            mensaje = e.toString();
        }
        ps.close();
        return mensaje;
    }


    public static void modUsuario(Usuario u) {
        try{

            sql = "UPDATE public.usuario SET  \"usrNombre\"=?, \"usrMail\"=?, \"usrPass\"=?, \"usrTelefono\"=?, \"usrRol\"=?\n" +
                    "\tWHERE \"usrID\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getMail());
            ps.setString(3, u.getPass());
            ps.setString(4,u.getTelefono());
            ps.setString(5,u.getRol());
            ps.setInt(6,u.getUsuId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public static void eliminarUsuario(Usuario u) {
        try{
            sql = "DELETE FROM usuario WHERE \"usrID\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setInt(1, u.getUsuId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }


    //verificamos que el correo no se duplique
    public static boolean verificarMail(Usuario u) throws SQLException {
        if (u.getMail() != null) {
            sql = "select * from public.USUARIO where \"usrMail\"=?";
            con = conn.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getMail());
            rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador++;
            }
            rs.close();
            if (contador == 1) {
                return true;
            }
        }
        return false;

    }

    //    verificamos si el usuario existe para realziar el login
    public static boolean verificarUsuario(Usuario u) throws SQLException {
        if (!u.getMail().equals("") && !u.getPass().equals("") && u.getMail() != null && u.getPass() != null) {
            sql = "select * from public.USUARIO where \"usrMail\"=? and \"usrPass\"=?";
            con = conn.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getMail());
            ps.setString(2, u.getPass());
            rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador++;
            }
            rs.close();
            if (contador == 1) {
                return true;
            }
        }
        return false;
    }

    public static List<Usuario> listarUsuario() throws SQLException {
        sql = "SELECT \"usrID\", \"usrNombre\", \"usrMail\", \"usrTelefono\", \"usrRol\"\n" +
                "\tFROM public.usuario;";

        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Usuario usr = new Usuario();
            usr.setUsuId(rs.getInt(1));
            usr.setNombre(rs.getString(2));
            usr.setMail(rs.getString(3));
            usr.setTelefono(rs.getString(4));
            usr.setRol(rs.getString(5));
            lstUsuario.add(usr);
        }
        st.close();
        rs.close();
        return lstUsuario;
    }


    public static Usuario usuario(Usuario usr) throws SQLException {
        sql = "SELECT \"usrID\", \"usrNombre\", \"usrMail\", \"usrPass\", \"usrTelefono\", \"usrRol\"\n" +
                "\tFROM public.usuario where \"usrID\"=?";
        con = conn.getCon();
        ps = con.prepareStatement(sql);
        ps.setInt(1, usr.getUsuId());

        rs = ps.executeQuery();
        if (rs.next()) {

            usr.setUsuId(rs.getInt(1));
            usr.setNombre(rs.getString(2));
            usr.setMail(rs.getString(3));
            usr.setPass(rs.getString(4));
            usr.setTelefono(rs.getString(5));
            usr.setRol(rs.getString(6));
            ps.close();
            rs.close();
            return usr;
        }
        ps.close();
        rs.close();
        return null;
    }


}
