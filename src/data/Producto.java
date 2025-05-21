package data;

/**
 *
 * @author alber
 */
//hacemos una clase abstracta base preparada para cualquier producto que queramos ofrecer en la tienda, todo protected para que las subclases accedan a esto
public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock) throws Exception {
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre != null || nombre.trim().isEmpty())
            this.nombre = nombre;
        else
            throw new Exception("El nombre no puede estar vacio");
    }

    public double getPrecio() {
        return precio;
    }
    //validamos precios y stock
    public void setPrecio(double precio) {
        if(precio < 5 || precio > 5000) throw new IllegalArgumentException("El precio de un producto debe estar entre 5 y 5000 euros");
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
