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

        // metodos post para paciente
        post("/main/paciente", PacienteServicio::crearPaciente);
        post("/main/pacienteMod", PacienteServicio::modificarPaciente);
        // metodos post para proveedores
        post("/main/proveedor", ProveedorServicio::crearProveedor);
        post("/main/proveedorMod", ProveedorServicio::modificarProveedor);
        // metodos post para producto
        post("/main/producto", ProductoServicio::crearProducto);
        post("/main/productoMod", ProductoServicio::modificarProducto);
        // metodos post para producto
        post("/main/medico", MedicoServicio::crearMedico);
        post("/main/medicoMod", MedicoServicio::modificarMedico);
        // metodos post para ventas
        post("/main/venta", VentaServicio::crearVenta);
        post("/main/medicoMod", MedicoServicio::modificarMedico);
        // metodos post para consulta
        post("/main/consulta",ConsultaServicio::crearConsulta);
        post("/main/consultaMod",ConsultaServicio::modificarConsulta);
        // metodos post para usuario
        post("/newAccount", UsuarioServicio::LoggincreateUsr);
        post("/main/usuario", UsuarioServicio::createUsr);
        post("/main/usuarioMod", UsuarioServicio::modificarUsuario);
        post("/main", UsuarioServicio::verificarLogin);
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
        LlamarPaciente();
        LlamarProveedor();
        LlamarProducto();
        LlamarMedico();
        LlamarVenta();
        LlamarConsulta();
        LlamarUsuario();
        return new ModelAndView(modelo, "View/main.vm");

    }
    public static void LlamarPaciente() {
        get("main/paciente", PacienteServicio::pagePaciente, engine);
        get("/main/paciente/:id", PacienteServicio::cargarFormulario, engine);
        get("/main/paciente/eliminar/:id", PacienteServicio::eliminarPaciente, engine);
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
    public static void LlamarMedico() {
        get("main/medico", MedicoServicio::pageMedico,engine);
        get("/main/medico/:id", MedicoServicio::cargarFormulario, engine);
        get("/main/medico/eliminar/:id", MedicoServicio::eliminarMedico , engine);

    }
    public static void LlamarVenta() {
        get("main/venta", VentaServicio::pageVenta,engine);
        get("/main/medico/:id", MedicoServicio::cargarFormulario, engine);
        get("/main/medico/eliminar/:id", MedicoServicio::eliminarMedico , engine);

    }
    public static void LlamarConsulta() {
        get("main/consulta", ConsultaServicio::pageConsulta, engine);
        get("/main/consulta/:id", ConsultaServicio::cargarFormulario, engine);
        get("/main/consulta/eliminar/:id", ConsultaServicio::eliminarConsulta, engine);
    }
      public static void LlamarUsuario() {
        get("main/usuario", UsuarioServicio::pageUsuario, engine);
        get("/main/usuario/:id", UsuarioServicio::cargarFormulario, engine);
        get("/main/usuario/eliminar/:id", UsuarioServicio::eliminarUsuario, engine);
    }

}
