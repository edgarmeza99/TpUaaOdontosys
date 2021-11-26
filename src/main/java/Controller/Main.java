package Controller;

import Controller.Servicios.PacienteServicio;
import Controller.Servicios.ProveedorServicio;
import Controller.Servicios.UsuarioServicio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
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

    }

    public static ModelAndView pageMain(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        get("main/paciente",PacienteServicio::pagePaciente,engine);
        get("/main/paciente/:id", PacienteServicio::cargarFormulario, engine);
        get("/main/paciente/eliminar/:id", PacienteServicio::eliminarPaciente , engine);
        LlamarProveedor();
        return new ModelAndView(modelo, "View/main.vm");

    }

    public static void LlamarProveedor (){
        get("main/proveedor", ProveedorServicio::pageProveedor,engine);
        get("/main/proveedor/:id", ProveedorServicio::cargarFormulario, engine);
        get("/main/proveedor/eliminar/:id", ProveedorServicio::eliminarProveedor , engine);
    }


}
