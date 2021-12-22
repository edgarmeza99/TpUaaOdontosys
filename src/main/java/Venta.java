import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Venta {
    private  Integer ventaId;
    private String cedula;
    private String nombre;
    private String fecha;
    private Integer nroTicket;
    private String idDoctor;
    private Integer totalComp;
    private VentaDetalle[] ventaDetalle;
    private Date fechaConvertida;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(Integer nroTicket) {
        this.nroTicket = nroTicket;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getTotalComp() {
        return totalComp;
    }

    public void setTotalComp(Integer totalComp) {
        this.totalComp = totalComp;
    }

    public VentaDetalle[] getVentaDetalle() {
        return ventaDetalle;
    }

    public void setVentaDetalle(VentaDetalle[] ventaDetalle) {
        this.ventaDetalle = ventaDetalle;
    }




    @Override
    public String toString() {
        return "Venta{" +
                "ventaId=" + ventaId +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", nroTicket=" + nroTicket +
                ", idDoctor=" + idDoctor +
                ", totalComp=" + totalComp +
                '}';
    }

}
