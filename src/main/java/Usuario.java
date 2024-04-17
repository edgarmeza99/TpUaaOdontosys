public class Usuario {

    private Integer usuId;
    private String nombre;
    private String mail;
    private String pass;
    private String telefono;
    private String rol;

    public Usuario() {
    }

    public Usuario(Integer usuId, String nombre, String mail, String pass) {
        this.usuId = usuId;
        this.nombre = nombre;
        this.mail = mail;
        this.pass = pass;
    }

    public Usuario(String nombre, String mail, String pass) {

        this.nombre = nombre;
        this.mail = mail;
        this.pass = pass;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuId=" + usuId +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
