package Controller.Recursos;

import Modelo.Usuario;
import SQL.Conexion;

import java.sql.*;

public class UsuarioRecurso {
    static Conexion conn = new Conexion();
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Usuario usr = new Usuario();

    public static String crearUsuario(Usuario u) throws SQLException {
        String mensaje = "";
        try {
            sql = "Insert into public.USUARIO (\n\"usrNombre\", \"usrMail\", \"usrPass\")values(?,?,?); ";
            System.out.println(u.toString());
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getMail());
            ps.setString(3, u.getPass());
            ps.executeUpdate();
            mensaje = "Se registro Correctamente";
        } catch (Exception e) {
            System.out.println(e);
            mensaje = e.toString();
        }
        ps.close();
        return mensaje;
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

}
