import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VentaRecurso {

    static PreparedStatement psVenta;
    static PreparedStatement psVentDet;
    static Conexion conn = new Conexion();
    static ResultSet rs;
    static Statement st;
    static String sql;
    static Connection con;
    static List<Venta> lstVenta = new ArrayList<>();



    public static void aggVenta(Venta v) throws SQLException {
        conn.getCon().setAutoCommit(false);
        String venta ="INSERT INTO public.venta(venmedicoid, venfecha, venticket, ventotal, venpacientedoc)\n" +
                "\tVALUES (?, ?, ?, ?, ?);";
        String venDet ="INSERT INTO public.vendetalle(venid, vennrolin, venproid, vencantidad, venprecio)VALUES (?, ?, ?, ?, ?);";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try{

            psVenta = conn.getCon().prepareStatement(venta);
            psVenta.setString(1, v.getIdDoctor());
            psVenta.setDate(2,new Date(df.parse(v.getFecha()).getTime()));
            psVenta.setInt(3, v.getNroTicket());
            psVenta.setInt(4, v.getTotalComp());
            psVenta.setString(5, v.getCedula());
            psVenta.executeUpdate();

            psVentDet = conn.getCon().prepareStatement(venDet);
            for (VentaDetalle vd :
                    v.getVentaDetalle()) {
               psVentDet.setInt(1,v.getVentaId());
               psVentDet.setInt(2,vd.getId());
               psVentDet.setLong(3,vd.getProId());
               psVentDet.setInt(4,vd.getCantidad());
               psVentDet.setInt(5,vd.getPrecio());
               psVentDet.executeUpdate();
            }
            conn.getCon().commit();
            psVenta.close();
            psVentDet.close();
        }catch (SQLException | ParseException ex){
            conn.getCon().rollback();
            System.err.println(ex);

        }


    }

    public static Venta verifiarVenta() throws SQLException {
        Venta venta = new Venta();

        sql = "SELECT  max((venid)+1),max((venticket)+1) FROM public.venta;";
        st = conn.getCon().createStatement();
        rs = st.executeQuery(sql);
        if (rs.next()) {
            venta.setVentaId(rs.getInt(1));
            venta.setNroTicket(rs.getInt(2));
        }

        st.close();
        rs.close();
        return venta;
    }

}
