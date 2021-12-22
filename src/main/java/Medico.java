import java.util.Objects;

public class Medico {
    private Integer id;
    private String med_registro;
    private String med_nombre;
    private String med_direccion;
    private String med_telefono;
    private String med_correo;
    private String med_estado;

    public Medico() {
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", med_registro='" + med_registro + '\'' +
                ", med_nombre='" + med_nombre + '\'' +
                ", med_direccion='" + med_direccion + '\'' +
                ", med_telefono='" + med_telefono + '\'' +
                ", med_correo='" + med_correo + '\'' +
                ", med_estado='" + med_estado + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMed_registro() {
        return med_registro;
    }

    public void setMed_registro(String med_registro) {
        this.med_registro = med_registro;
    }

    public String getMed_nombre() {
        return med_nombre;
    }

    public void setMed_nombre(String med_nombre) {
        this.med_nombre = med_nombre;
    }

    public String getMed_direccion() {
        return med_direccion;
    }

    public void setMed_direccion(String med_direccion) {
        this.med_direccion = med_direccion;
    }

    public String getMed_telefono() {
        return med_telefono;
    }

    public void setMed_telefono(String med_telefono) {
        this.med_telefono = med_telefono;
    }

    public String getMed_correo() {
        return med_correo;
    }

    public void setMed_correo(String med_correo) {
        this.med_correo = med_correo;
    }

    public String getMed_estado() {
        return med_estado;
    }

    public void setMed_estado(String med_estado) {
        this.med_estado = med_estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(med_registro, medico.med_registro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(med_registro);
    }
}
