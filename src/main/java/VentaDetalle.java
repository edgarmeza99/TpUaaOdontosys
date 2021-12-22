public class VentaDetalle {
    private Integer ventaId;
    private Integer id;
    private String proId;
    private String descripcion;
    private Integer cantidad;
    private Integer precio;
    private Integer total;

    public VentaDetalle() {

    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public VentaDetalle(Integer ventaId, Integer id, String proId, String descripcion, Integer cantidad, Integer precio, Integer total) {
        this.ventaId = ventaId;
        this.id = id;
        this.proId = proId;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "VentaDetalle{" +
                "ventaId=" + ventaId +
                ", id=" + id +
                ", proId=" + proId +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
