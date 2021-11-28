import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.SQLException;
import java.util.HashMap;

import static spark.Spark.*;

public class UsuarioServicio {
    static VelocityTemplateEngine engine = new VelocityTemplateEngine();
    static Usuario usr = new Usuario();

    public UsuarioServicio() {
       // post("/usuario/new", UsuarioServicio::createUsr);

    }

    public static void llamargets() {
        get("/login", UsuarioServicio::pageLogin, engine);
        get("/newAccount", UsuarioServicio::pageNewAccount, engine);


    }

    private static ModelAndView pageLogin(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();

        return new ModelAndView(modelo, "View/login.vm");
    }

    public static Object verificarLogin(Request req, Response res) throws SQLException {
        HashMap<String, Object> modelo = new HashMap<>();
        usr.setMail(req.queryParams("mail"));
        usr.setPass(req.queryParams("pass"));
        try {
            if (UsuarioRecurso.verificarUsuario(usr)){
                get("/main", Main::pageMain, engine);
                res.redirect("/main");
                return "";

            }
            res.redirect("/login");

        }catch (SQLException e){
            System.err.println(e);
        }


        return "";
    }

    private static ModelAndView pageNewAccount(Request req, Response res) {
        HashMap<String, Object> modelo = new HashMap<>();
        return new ModelAndView(modelo, "View/newAccount.vm");
    }

    public static Object createUsr(Request req, Response res) {
        HashMap<String, Object> model = new HashMap<>();
        usr.setNombre(req.queryParams("nombre"));
        usr.setMail(req.queryParams("mail"));
        usr.setPass(req.queryParams("pass"));

        try {

            if (UsuarioRecurso.verificarMail(usr)) {
                res.redirect("/login");
               model.put("mensajeError", "<p style=\"display:'block'\">EL CORREO YA EXISTE</p>");
            } else {

                UsuarioRecurso.crearUsuario(usr);
                res.redirect("/login");
            }
        } catch (Exception e) {
            System.out.println("Error al grabar " + e);
        }
        return "ok";
    }


}
