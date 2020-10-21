package modelo;

import com.example.tarea14.Producto;

public class Producto1  {
    private String uid;
    private String Codigo;
    private String Producto;
    private String Stock;
    private String Costo;
    private String Venta;

    public Producto1() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }

    public String getVenta() {
        return Venta;
    }

    public void setVenta(String venta) {
        Venta = venta;
    }

    @Override
    public String toString() {
        return  "Codigo: '" + Codigo + '\'' +
                ", Producto: '" + Producto + '\'' +
                ", Stock: '" + Stock + '\'' +
                ", Venta:'" + Venta + '\'';
    }
}
