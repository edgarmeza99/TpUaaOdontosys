import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/assets");
        UsuarioServicio.llamargets();
        get("/",(request, response) -> {
            response.redirect("/login");
            return "";
        });

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
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
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