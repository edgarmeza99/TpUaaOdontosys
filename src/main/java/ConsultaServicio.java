import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

public class ConsultaServicio {

    static Consulta cons = new Consulta();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();

    public ConsultaServicio() {
    }

    public static ModelAndView pageConsulta(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        ConsultaRecurso.porConsulta(cons).clear();
        ConsultaRecurso.listarConsulta().clear();
        modelo.put("consulta", ConsultaRecurso.listarConsulta());


        return new ModelAndView(modelo, "View/main/consulta.vm");
    }

    public static Object crearConsulta(Request req, Response res) throws SQLException {
        cons.setIdConsulta(req.queryParams("consulta_id"));
        cons.setNombrePac(req.queryParams("nombre"));
        cons.setDocumentoPac(req.queryParams("documento"));
        cons.setNombreDoctor(req.queryParams("nombredoctor"));
        cons.setFecha(req.queryParams("fecha"));
        cons.setHora(req.queryParams("hora"));


        ConsultaRecurso.crearConsulta(cons);

        res.redirect("/main/consulta");

        return "";
    }

    public static ModelAndView cargarFormulario(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        cons.setIdConsulta(req.params("id"));

        ConsultaRecurso.porConsulta(cons).clear();
        ConsultaRecurso.listarConsulta().clear();

        modelo.put("porConsulta", ConsultaRecurso.porConsulta(cons));
        modelo.put("consulta", ConsultaRecurso.listarConsulta());

        return new ModelAndView(modelo, "View/main/consultaMod.vm");
    }
    public static Object modificarConsulta(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        cons.setIdConsulta(req.queryParams("consulta_id"));
        cons.setNombrePac(req.queryParams("nombre"));
        cons.setDocumentoPac(req.queryParams("documento"));
        cons.setNombreDoctor(req.queryParams("nombredoctor"));
        cons.setFecha(req.queryParams("fecha"));
        cons.setHora(req.queryParams("hora"));


        ConsultaRecurso.modConsulta(cons);

        res.redirect("/main/consulta");

        return "";
    }
    public static ModelAndView eliminarConsulta(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        cons.setIdConsulta(req.params("id"));
        ConsultaRecurso.eliminarConsulta(cons);
        res.redirect("/main/consulta");
        return new ModelAndView(modelo, "View/main/consulta.vm");
    }

}
