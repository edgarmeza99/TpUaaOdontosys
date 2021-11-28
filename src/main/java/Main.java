import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public static void main(String[] args) {
        staticFiles.location("/assets");
        UsuarioServicio.llamargets();




        post("/newAccount", UsuarioServicio::createUsr);
        post("/main", UsuarioServicio::verificarLogin);
        post("/main/paciente", PacienteServicio::crearPaciente);
        post("/main/pacienteMod", PacienteServicio::modificarPaciente);
        // metodos post para proveedores
        post("/main/proveedor", ProveedorServicio::crearProveedor);
        post("/main/proveedorMod", ProveedorServicio::modificarProveedor);
        // metodos post para producto
        post("/main/producto", ProductoServicio::crearProducto);
        post("/main/pacienteMod", PacienteServicio::modificarPaciente);
        post("/main/productoMod", ProductoServicio::modificarProducto);


    }

    public static ModelAndView pageMain(Request req, Response res) {
        HashMap<String, Object> modelo = new HashMap<>();
        get("main/paciente", PacienteServicio::pagePaciente, engine);
        get("/main/paciente/:id", PacienteServicio::cargarFormulario, engine);
        get("/main/paciente/eliminar/:id", PacienteServicio::eliminarPaciente, engine);
        LlamarProveedor();
        LlamarProducto();
        return new ModelAndView(modelo, "View/main.vm");

    }

    public static void LlamarProveedor() {
        get("/main/proveedor", ProveedorServicio::pageProveedor, engine);
        get("/main/proveedor/:id", ProveedorServicio::cargarFormulario, engine);
        get("/main/proveedor/eliminar/:id", ProveedorServicio::eliminarProveedor, engine);
    }
    public static void LlamarProducto() {
        get("main/producto", ProductoServicio::pageProducto,engine);
        get("/main/producto/:id", ProductoServicio::cargarFormulario, engine);
        get("/main/producto/eliminar/:id", ProductoServicio::eliminarProducto, engine);

    }

}
