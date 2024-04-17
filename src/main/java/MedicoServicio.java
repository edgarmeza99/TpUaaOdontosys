import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

public class MedicoServicio {

    static Medico med = new Medico();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public MedicoServicio() {

    }

    public static ModelAndView pageMedico(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        MedicoRecurso.porMedico(med).clear();
        MedicoRecurso.listarMedico().clear();
        modelo.put("medico", MedicoRecurso.listarMedico());


        return new ModelAndView(modelo, "View/main/medico.vm");
    }

    public static Object crearMedico(Request req, Response res) throws SQLException {
        med.setMed_registro(req.queryParams("documento"));
        med.setMed_nombre(req.queryParams("nombre"));
        med.setMed_direccion(req.queryParams("direccion"));
        med.setMed_telefono(req.queryParams("telefono"));
        med.setMed_correo(req.queryParams("correo"));
        med.setMed_estado(req.queryParams("estado"));

        MedicoRecurso.crearMedico(med);

        res.redirect("/main/medico");

        return "";
    }

    public static ModelAndView cargarFormulario(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        med.setMed_registro(req.params("id"));

        MedicoRecurso.porMedico(med).clear();
        MedicoRecurso.listarMedico().clear();

        modelo.put("porMedico", MedicoRecurso.porMedico(med));
        modelo.put("medico", MedicoRecurso.listarMedico());

        return new ModelAndView(modelo, "View/main/medicoMod.vm");
    }
    public static Object modificarMedico(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        med.setMed_registro(req.queryParams("documento"));
        med.setMed_nombre(req.queryParams("nombre"));
        med.setMed_direccion(req.queryParams("direccion"));
        med.setMed_telefono(req.queryParams("telefono"));
        med.setMed_correo(req.queryParams("correo"));
        med.setMed_estado(req.queryParams("estado"));

        MedicoRecurso.modMedico(med);
        modelo.put("medico", MedicoRecurso.listarMedico());
        res.redirect("/main/medico");

        return "";
    }
    public static ModelAndView eliminarMedico(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        med.setMed_registro(req.params("id"));
        MedicoRecurso.eliminarMedico(med);
        res.redirect("/main/medico");
        return new ModelAndView(modelo, "View/main/medico.vm");
    }
}
