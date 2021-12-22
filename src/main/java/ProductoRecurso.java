import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRecurso {

    static Conexion conn = new Conexion();
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Producto> lstProducto = new ArrayList<>();
    static List<Producto> lstPorProducto = new ArrayList<>();


    public static void crearProducto(Producto p) throws SQLException {


        try{
            sql = "INSERT INTO public.producto(\"proID\", \"proDescripcion\", \"proPrecio\", \"proTipo\", \"proDescripcionUso\", \"proMinimoStock\")\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?);;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getProductoId());
            ps.setString(2, p.getProductoDescripcion());
            ps.setInt(3, p.getProductoPrecio());
            ps.setString(4, p.getProductoTipo());
            ps.setString(5,p.getProductoUsu());
            ps.setInt(6,p.getProductoMinimo());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }


    }

    public static void modProducto(Producto p) {
        try{
            System.out.println(p.toString());

            sql = "UPDATE producto SET \"proID\"=?, \"proDescripcion\"=?, \"proPrecio\"=?, \"proTipo\"=?, \"proDescripcionUso\"=?, \"proMinimoStock\"=? WHERE \"proID\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getProductoId());
            ps.setString(2, p.getProductoDescripcion());
            ps.setInt(3, p.getProductoPrecio());
            ps.setString(4, p.getProductoTipo());
            ps.setString(5,p.getProductoUsu());
            ps.setInt(6,p.getProductoMinimo());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }


    public static void eliminarProducto(Producto p) {
        try{
            sql = "DELETE FROM producto WHERE \"proID\"=?;";
            ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, p.getProductoId());
            ps.executeUpdate();
            ps.close();
            System.err.println("eliminado");
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }



    public static List<Producto> listarProducto() throws SQLException {
        sql = "select * from producto order by \"proID\"";

        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            Producto pro = new Producto();
            pro.setProductoId(rs.getString(1));
            pro.setProductoDescripcion(rs.getString(2));
            pro.setProductoPrecio(rs.getInt(3));
            pro.setProductoTipo(rs.getString(4));
            pro.setProductoUsu(rs.getString(5));
            pro.setProductoMinimo(rs.getInt(6));
            lstProducto.add(pro);
        }
        st.close();
        rs.close();
        return lstProducto;
    }


    public static List<Producto> porProducto(Producto pr) throws SQLException {
        sql = "select * from producto where \"proID\"=?";
        con = conn.getCon();
        ps = con.prepareStatement(sql);
        System.out.println(pr.getProductoId());
        ps.setString(1, pr.getProductoId());
        rs = ps.executeQuery();
        while (rs.next()) {
            Producto pro = new Producto();
            pro.setProductoId(rs.getString(1));
            pro.setProductoDescripcion(rs.getString(2));
            pro.setProductoPrecio(rs.getInt(3));
            pro.setProductoTipo(rs.getString(4));
            pro.setProductoUsu(rs.getString(5));
            pro.setProductoMinimo(rs.getInt(6));
            lstPorProducto.add(pro);
        }
        ps.close();
        rs.close();
        return lstPorProducto;
    }


}
