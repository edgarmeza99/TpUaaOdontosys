import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

public class PacienteServicio {
    static Paciente pac = new Paciente();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public PacienteServicio() {


    }

    public static ModelAndView pagePaciente(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        PacienteRecurso.porPaciente(pac).clear();
        PacienteRecurso.listarPaciente().clear();
        modelo.put("paciente", PacienteRecurso.listarPaciente());


        return new ModelAndView(modelo, "View/main/paciente.vm");
    }

    public static Object crearPaciente(Request req, Response res) throws SQLException {
        pac.setNumeroDoc(req.queryParams("documento"));
        pac.setNombre(req.queryParams("nombre"));
        pac.setTelefono(req.queryParams("telefono"));
        pac.setDireccion(req.queryParams("direccion"));
        pac.setTipoPlan(req.queryParams("plan"));


        PacienteRecurso.crearPaciente(pac);

        res.redirect("/main/paciente");

        return "";
    }

    public static ModelAndView cargarFormulario(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pac.setNumeroDoc(req.params("id"));

        PacienteRecurso.porPaciente(pac).clear();
        PacienteRecurso.listarPaciente().clear();

        modelo.put("porPaciente", PacienteRecurso.porPaciente(pac));
        modelo.put("paciente", PacienteRecurso.listarPaciente());

        return new ModelAndView(modelo, "View/main/pacienteMod.vm");
    }
    public static Object modificarPaciente(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pac.setNumeroDoc(req.queryParams("documento"));
        pac.setNombre(req.queryParams("nombre"));
        pac.setTelefono(req.queryParams("telefono"));
        pac.setDireccion(req.queryParams("direccion"));
        pac.setTipoPlan(req.queryParams("plan"));


        PacienteRecurso.modPaciente(pac);

        res.redirect("/main/paciente");

        return "";
    }
    public static ModelAndView eliminarPaciente(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        pac.setNumeroDoc(req.params("id"));
        PacienteRecurso.eliminarPaciente(pac);
        res.redirect("/main/paciente");
        return new ModelAndView(modelo, "View/main/paciente.vm");
    }
}
