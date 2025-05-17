package data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author alber
 */
public class Tienda {
    private final Set <Producto> productos;

    public Tienda() {
        productos = new HashSet();
    }
    
    public boolean eliminarProducto(String nombre){
        Iterator<Producto> it = productos.iterator();
        while(it.hasNext()){
            Producto producto = it.next();
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    public boolean modificarPrecioStockProducto(String nombre, double nuevoPrecio, int nuevoStock){
        for (Producto producto : productos) {
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                producto.setPrecio(nuevoPrecio);
                producto.setStock(nuevoStock);
                return true;
            }
            
        }
        return false;
    }
    
    public boolean añadirVideojuego(String nombre, String genero, double precio, int stock) {
        if(!Videojuego.videojuegoEsValido(nombre, genero, precio, stock)) {
            return false;
        } else {
            productos.add(new Videojuego(nombre, genero, precio, stock));
            return true;
        }
        
    }
    public boolean añadirConsola(String nombre, double precio, int stock, String generacion) {
          if(!Consola.consolaEsValido(nombre, precio, stock, generacion)) {
              return false;
        } else {
            productos.add(new Consola(nombre, precio, stock, generacion));
            return true;
        }
    }
 
    public Set<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("En la tienda tenemos estos productos: \n");
        for (Producto producto : productos) {
            sb.append(producto.getNombre())
            .append(" | Precio: ")      
            .append(producto.getPrecio())
            .append("$ | Stock: ")
            .append(producto.getStock());
          //si el producto es un videojuego le metemos el género, consola generacion...  
            if(producto instanceof Videojuego)
                sb.append(" | Genero: ").append(((Videojuego) producto).getGenero());
            else if(producto instanceof Consola)
                sb.append(" | Generacion: ").append(((Consola) producto).getGeneracion());
            
            sb.append("\n");
        }
        return sb.toString();
    }

   
    
}
