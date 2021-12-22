
public class Consulta {
    private String idConsulta, nombrePac, documentoPac, nombreDoctor, fecha, hora;

    public Consulta() {
    }

    public Consulta(String idConsulta, String nombrePac, String documentoPac, String nombreDoctor, String fecha, String hora) {
        this.idConsulta = idConsulta;
        this.nombrePac = nombrePac;
        this.documentoPac = documentoPac;
        this.nombreDoctor = nombreDoctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getDocumentoPac() {
        return documentoPac;
    }

    public void setDocumentoPac(String documentoPac) {
        this.documentoPac = documentoPac;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", nombrePac='" + nombrePac + '\'' +
                ", documentoPac='" + documentoPac + '\'' +
                ", nombreDoctor='" + nombreDoctor + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }


}
