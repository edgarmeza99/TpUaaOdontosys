package Controller.Servicios;


import Controller.Recursos.ProveedorRecurso;
import Modelo.Proveedor;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

public class ProveedorServicio {

    static Proveedor pro = new Proveedor();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public ProveedorServicio() {

    }

    public static ModelAndView pageProveedor(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        ProveedorRecurso.porProveedor(pro).clear();
        ProveedorRecurso.listarProveedor().clear();
        modelo.put("proveedor", ProveedorRecurso.listarProveedor());


        return new ModelAndView(modelo, "View/main/proveedor.vm");
    }

    public static Object crearProveedor(Request req, Response res) throws SQLException {
        pro.setPro_ruc(req.queryParams("documento"));
        pro.setPro_nombre(req.queryParams("nombre"));
        pro.setPro_direccion(req.queryParams("direccion"));
        pro.setPro_telefono(req.queryParams("telefono"));
        pro.setPro_correo(req.queryParams("correo"));
        pro.setPro_tipo(req.queryParams("tipo"));
        pro.setPro_estado(req.queryParams("estado"));

        ProveedorRecurso.crearProveedor(pro);

        res.redirect("/main/proveedor");

        return "";
    }

    public static ModelAndView cargarFormulario(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pro.setPro_ruc(req.params("id"));

        ProveedorRecurso.porProveedor(pro).clear();
        ProveedorRecurso.listarProveedor().clear();

        modelo.put("porProveedor", ProveedorRecurso.porProveedor(pro));
        modelo.put("proveedor", ProveedorRecurso.listarProveedor());

        return new ModelAndView(modelo, "View/main/proveedorMod.vm");
    }
    public static Object modificarProveedor(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pro.setPro_ruc(req.queryParams("documento"));
        pro.setPro_nombre(req.queryParams("nombre"));
        pro.setPro_direccion(req.queryParams("direccion"));
        pro.setPro_telefono(req.queryParams("telefono"));
        pro.setPro_correo(req.queryParams("correo"));
        pro.setPro_tipo(req.queryParams("tipo"));
        pro.setPro_estado(req.queryParams("estado"));

        ProveedorRecurso.modProveedor(pro);

        res.redirect("/main/proveedor");

        return "";
    }
    public static ModelAndView eliminarProveedor(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pro.setPro_ruc(req.params("id"));
        ProveedorRecurso.eliminarProveedor(pro);
        res.redirect("/main/proveedor");
        return new ModelAndView(modelo, "View/main/proveedor.vm");
    }
}