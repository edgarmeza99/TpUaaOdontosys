package Modelo;


import java.util.Objects;

public class Paciente {
    private Integer id;
    private String numeroDoc, nombre, telefono,direccion,tipoPlan;

    public Paciente() {
    }

    public Paciente(String numeroDoc, String nombre, String telefono, String direccion, String tipoPlan) {
        this.numeroDoc = numeroDoc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoPlan = tipoPlan;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

        public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", numeroDoc='" + numeroDoc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoPlan='" + tipoPlan + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(numeroDoc, paciente.numeroDoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDoc);
    }
}
