import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

public class ProductoServicio {
    static Producto pro = new Producto();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public ProductoServicio() {
    }

    public static ModelAndView pageProducto(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        ProductoRecurso.porProducto(pro).clear();
        ProductoRecurso.listarProducto().clear();
        modelo.put("producto", ProductoRecurso.listarProducto());


        return new ModelAndView(modelo, "View/main/producto.vm");
    }

    public static Object crearProducto(Request req, Response res) throws SQLException {
        pro.setProductoId(req.queryParams("id"));
        pro.setProductoDescripcion(req.queryParams("descripcion"));
        pro.setProductoPrecio(Integer.parseInt(req.queryParams("precio")));
        pro.setProductoTipo(req.queryParams("tipo"));
        ProductoRecurso.crearProducto(pro);
        res.redirect("/main/producto");
        return "";
    }

    public static ModelAndView cargarFormulario(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pro.setProductoId(req.params("id"));

        ProductoRecurso.porProducto(pro).clear();
        ProductoRecurso.listarProducto().clear();

        modelo.put("porProducto", ProductoRecurso.porProducto(pro));
        modelo.put("producto", ProductoRecurso.listarProducto());

        return new ModelAndView(modelo, "View/main/productoMod.vm");
    }
    public static Object modificarProducto(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pro.setProductoId(req.queryParams("id"));
        pro.setProductoDescripcion(req.queryParams("descripcion"));
        pro.setProductoPrecio(Integer.parseInt(req.queryParams("precio")));
        pro.setProductoTipo(req.queryParams("tipo"));
        ProductoRecurso.modProducto(pro);
        res.redirect("/main/producto");
        return "";
    }
    public static ModelAndView eliminarProducto(Request req, Response res) throws SQLException {
        HashMap<String, String> modelo = new HashMap<>();
        pro.setProductoId(req.params("id"));
        ProductoRecurso.eliminarProducto(pro);
        res.redirect("/main/producto");
        return new ModelAndView(modelo, "View/main/producto.vm");
    }
}
