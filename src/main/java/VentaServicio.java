import com.google.gson.Gson;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;

public class VentaServicio {

    static Medico med = new Medico();
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();


    public static ModelAndView pageVenta(Request req, Response res) throws SQLException {
        HashMap<String,Object> modelo = new HashMap<>();
        MedicoRecurso.listarMedico().clear();
        PacienteRecurso.listarPaciente().clear();
        ProductoRecurso.listarProducto().clear();

        modelo.put("venta",VentaRecurso.verifiarVenta());
        modelo.put("paciente",PacienteRecurso.listarPaciente());
        modelo.put("producto",ProductoRecurso.listarProducto());
        modelo.put("medico",MedicoRecurso.listarMedico());
        return new ModelAndView(modelo,"View/main/venta.vm");
    }

    public static Object crearVenta(Request req, Response res) throws SQLException, ParseException {
        System.out.println(req.body());
        Venta venta = new Gson().fromJson(req.body(), Venta.class);

        VentaRecurso.aggVenta(venta);
        return new Gson().toJson("");
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
