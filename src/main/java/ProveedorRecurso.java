import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorRecurso {

    static Conexion conn = new Conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Proveedor> lstProveedor = new ArrayList<>();
    static List<Proveedor> lstPorProveedor = new ArrayList<>();

    public static void crearProveedor(Proveedor p) {
        try{
            sql = "INSERT INTO proveedor(pro_ruc, pro_nombre, pro_direccion, pro_telefono, pro_correo, pro_tipo, pro_estado)\n" +
                    "VALUES(?,?,?,?,?,?,?);";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getPro_ruc());
            ps.setString(2, p.getPro_nombre());
            ps.setString(3, p.getPro_direccion());
            ps.setString(4, p.getPro_telefono());
            ps.setString(5, p.getPro_correo());
            ps.setString(6, p.getPro_tipo());
            ps.setString(7, p.getPro_estado());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public static void modProveedor(Proveedor p) {
        try{
            sql = "UPDATE proveedor SET pro_nombre=?, pro_direccion=?, pro_telefono=?, pro_correo=?, pro_tipo=?, pro_estado=?\n" +
                    " WHERE pro_ruc=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getPro_nombre());
            ps.setString(2, p.getPro_direccion());
            ps.setString(3, p.getPro_telefono());
            ps.setString(4, p.getPro_correo());
            ps.setString(5, p.getPro_tipo());
            ps.setString(6, p.getPro_estado());
            ps.setString(7, p.getPro_ruc());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public static void eliminarProveedor(Proveedor p) {
        try{
            sql = "delete from proveedor where pro_ruc=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getPro_ruc());
            System.err.println(p.getPro_ruc());
            ps.executeUpdate();
            ps.close();
            System.err.println("eliminado");
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public static List<Proveedor> listarProveedor() throws SQLException {
        sql = "select * from proveedor order by pro_nombre";
        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Proveedor pro = new Proveedor();
            pro.setPro_ruc(rs.getString(1));
            pro.setPro_nombre(rs.getString(2));
            pro.setPro_direccion(rs.getString(3));
            pro.setPro_telefono(rs.getString(4));
            pro.setPro_correo(rs.getString(5));
            pro.setPro_tipo(rs.getString(6));
            pro.setPro_estado(rs.getString(7));
            lstProveedor.add(pro);
        }
        st.close();
        rs.close();
        return lstProveedor;
    }

    public static List<Proveedor> porProveedor(Proveedor p) throws SQLException {
        sql = "select * from proveedor where pro_ruc=?";
        con = conn.getCon();
        ps = con.prepareStatement(sql);
        System.out.println(p.getPro_ruc());
        ps.setString(1, p.getPro_ruc());
        rs = ps.executeQuery();
        while (rs.next()) {
            Proveedor pro = new Proveedor();
            pro.setPro_ruc(rs.getString(1));
            pro.setPro_nombre(rs.getString(2));
            pro.setPro_direccion(rs.getString(3));
            pro.setPro_telefono(rs.getString(4));
            pro.setPro_correo(rs.getString(5));
            pro.setPro_tipo(rs.getString(6));
            pro.setPro_estado(rs.getString(7));
            lstPorProveedor.add(pro);
        }
        ps.close();
        rs.close();
        return lstPorProveedor;
    }

}
