package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author alber
 */
//crearemos un set de producto donde guardaremos cualquier tipo de producto que hagamos
public class Tienda {
    private final Set <Producto> productos;

    public Tienda() {
        productos = new HashSet();
    }
    //altas bajas y modificaiones, la baja con iterator para evitarnos errores de concurrencia
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
    //valida si los parametros son válidos y si lo son lo mete, lo haremos booleanos después para lanzar mensajes
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
    /*Las siguientes funciones se encargan de cargar y guardar respectivamente
    la información de los listados en archivos.txt, de forma que tenemos persistencia de informacion al cerrar la app
    a la vez que mantenemos una distincion entre cada tipo de producto*/
    public void cargarProductosDeArchivo(String ruta){
        File archivo = new File(ruta);
        if(!archivo.exists()) return;
        //hacemos un bufferedReader, y hacemos una variable temporal para que guarde las lineas leidas
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
        String linea;
        while((linea = reader.readLine()) != null){ //mientras haya lineas haz:
            String[] partes = linea.split(";");
            if(partes.length > 0){
                if(partes[0].equalsIgnoreCase("Videojuego") && partes.length == 5){
                    String nombre = partes[1];
                    String genero = partes[2];
                    double precio = Double.parseDouble(partes[3]);
                    int stock = Integer.parseInt(partes[4]);
                    
                    productos.add(new Videojuego(nombre,genero,precio,stock));
                }
                else if(partes[0].equalsIgnoreCase("Consola") && partes.length == 5){
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int stock = Integer.parseInt(partes[3]); 
                    String generacion = partes[4];
                    
                    productos.add(new Consola(nombre,precio,stock,generacion));
                }
            }
        }
            
        }catch (IOException e){
            System.out.println("Error cargando productos: " + e.getMessage());
        }
    }
    
    public void guardarProductosEnArchivo(String ruta){
        System.out.println("ENTRANDO A GUARDAR PRODUCTOS");
        System.out.println("PRODUCTOS A GUARDAR: " + productos.size());
        //hacemos un printerWriter para que escriba texto en el archivo, y hacemos como queremos las lineas
        try(PrintWriter writer = new PrintWriter(new FileWriter(ruta))){
            for (Producto p : productos) {
                if(p instanceof Videojuego v)
                    writer.println("Videojuego;" + v.getNombre() + ";" + v.getGenero() + ";" + v.getPrecio() + ";" + v.getStock());
                else if(p instanceof Consola c)
                    writer.println("Consola;" + c.getNombre() + ";" + c.getPrecio() + ";" + c.getStock() + ";" + c.getGeneracion());
            }
        }
        catch(IOException e){
            System.out.println("Error al guardar productos" + e.getMessage());
        }
    }
    //hacemos un toString chulo con StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("En la tienda tenemos estos productos: \n");
        for (Producto producto : productos) {
            sb.append(producto.getNombre())
            .append(" | Precio: ")      
            .append(producto.getPrecio())
            .append("$ | Stock: ")
            .append(producto.getStock())
            .append(" uds");
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
