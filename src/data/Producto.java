package data;

import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < 5) throw new IllegalArgumentException("El precio de un producto debe ser 5 euros o más");
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock < 0) throw new IllegalArgumentException("El stock de un producto no puede ser negativo");
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto: " + "nombre: " + nombre + ", precio: " + precio + ", stock: " + stock ;
    }
}
