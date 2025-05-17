package data;

import GUI.VPal;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class App extends Thread {

    /**
     * @param args the command line arguments
     */
    final boolean DEV_VERSION = false;
    final String NOM = "Tienda de videojuegos Pleysteichon";
    Tienda tienda;
   
    @Override
    public void run(){
        if(DEV_VERSION){
            tienda = new Tienda();
            this.crearDatosPrueba();
            this.visualizarConsola();
            this.visualizarVentana();
        }else{
        tienda = new Tienda();
        VPal v = new VPal(NOM, tienda);
        v.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new App().start();
    }

    private void crearDatosPrueba() {
    tienda.añadirVideojuego("Halo", "Shooter", 18.54, 5);
    tienda.añadirVideojuego("COD", "Shooter", 59.99, 1);
    tienda.añadirVideojuego("UFC 5", "Deportes", 32.54, 2);
    tienda.añadirConsola("PS5", 599.99, 133, "Novena");
    tienda.añadirConsola("Xbox Series S", 349.99, 58, "Novena");
    tienda.añadirConsola("Xbox Series X", 499.99, 100, "Novena");
    if(tienda.eliminarProducto("PS5"))
        JOptionPane.showMessageDialog(null, "Producto Eliminado correctamente");
    else
        JOptionPane.showMessageDialog(null, "Error, no se ha encontrado el producto");
    if(tienda.eliminarProducto("pepe"))
        JOptionPane.showMessageDialog(null, "Producto Eliminado correctamente");
    else
        JOptionPane.showMessageDialog(null, "Error, no se ha encontrado el producto");
    tienda.modificarPrecioStockProducto("Halo", 54.54, 354);
    tienda.modificarPrecioStockProducto("COD", 13, 354);
    tienda.modificarPrecioStockProducto("UFC 5", 54.54, 0);

    }

    private void visualizarConsola() {
        System.out.println("" + tienda);
    }

    private void visualizarVentana() {
      //parent component, mensaje, titulo de la ventana, icono que sale
      JOptionPane.showMessageDialog(null, tienda.toString(), NOM, 1);
    }
    
}
