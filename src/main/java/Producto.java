import java.util.Objects;

public class Producto {

    private String productoId;
    private String productoDescripcion;
    private Integer productoPrecio;
    private String productoTipo;
    private String productoUsu;
    private int productoMinimo;

    public Producto() {
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public Integer getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(Integer productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public String getProductoTipo() {
        return productoTipo;
    }

    public void setProductoTipo(String productoTipo) {
        this.productoTipo = productoTipo;
    }

    public String getProductoUsu() {
        return productoUsu;
    }

    public void setProductoUsu(String productoUsu) {
        this.productoUsu = productoUsu;
    }

    public int getProductoMinimo() {
        return productoMinimo;
    }

    public void setProductoMinimo(int productoMinimo) {
        this.productoMinimo = productoMinimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return productoId.equals(producto.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId);
    }

    @Override
    public String toString() {
        return "Producto{" +
                ", productoId='" + productoId + '\'' +
                ", productoDescripcion='" + productoDescripcion + '\'' +
                ", productoPrecio='" + productoPrecio + '\'' +
                ", productoTipo='" + productoTipo + '\'' +
                '}';
    }
}
