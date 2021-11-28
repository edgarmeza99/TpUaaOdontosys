import java.util.Objects;

public class Proveedor {
    private Integer id;
    private String pro_ruc;
    private String pro_nombre;
    private String pro_direccion;
    private String pro_telefono;
    private String pro_correo;
    private String pro_tipo;
    private String pro_estado;

    public Proveedor() {
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", pro_ruc='" + pro_ruc + '\'' +
                ", pro_nombre='" + pro_nombre + '\'' +
                ", pro_direccion='" + pro_direccion + '\'' +
                ", pro_telefono='" + pro_telefono + '\'' +
                ", pro_correo='" + pro_correo + '\'' +
                ", pro_tipo='" + pro_tipo + '\'' +
                ", pro_estado='" + pro_estado + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPro_ruc() {
        return pro_ruc;
    }

    public void setPro_ruc(String pro_ruc) {
        this.pro_ruc = pro_ruc;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public String getPro_direccion() {
        return pro_direccion;
    }

    public void setPro_direccion(String pro_direccion) {
        this.pro_direccion = pro_direccion;
    }

    public String getPro_telefono() {
        return pro_telefono;
    }

    public void setPro_telefono(String pro_telefono) {
        this.pro_telefono = pro_telefono;
    }

    public String getPro_correo() {
        return pro_correo;
    }

    public void setPro_correo(String pro_correo) {
        this.pro_correo = pro_correo;
    }

    public String getPro_tipo() {
        return pro_tipo;
    }

    public void setPro_tipo(String pro_tipo) {
        this.pro_tipo = pro_tipo;
    }

    public String getPro_estado() {
        return pro_estado;
    }

    public void setPro_estado(String pro_estado) {
        this.pro_estado = pro_estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(pro_ruc, proveedor.pro_ruc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pro_ruc);
    }
}
