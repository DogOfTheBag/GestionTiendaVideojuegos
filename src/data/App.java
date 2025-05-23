package data;

import GUI.VPal;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    //dev version para probar cosas, o abrir la ventana si es la versión final
    @Override
    public void run(){
        if(DEV_VERSION){
            tienda = new Tienda();
            try {
                this.crearDatosPrueba();
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.visualizarConsola();
            this.visualizarVentana();
        }else{
        /*creamos la tienda, cargamos los productos del archivo y activamos la ventana*/
        tienda = new Tienda();
           
            try {
                tienda.cargarProductosDeArchivo("res/productos.txt");
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        VPal v = new VPal(NOM, tienda);
        v.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new App().start();
    }
//***********************************PARA PRUEBAS SOLO*******************************
    private void crearDatosPrueba() throws Exception {
    tienda.añadirVideojuego("Halo", "Shooter", 18.54, 5);
    tienda.añadirVideojuego("COD", "Shooter", 59.99, 1);
    tienda.añadirVideojuego("UFC 5", "Deportes", 32.54, 2);
    tienda.añadirConsola("PS5", 599.99, 133, "Novena");
    tienda.añadirConsola("Xbox Series S", 349.99, 58, "Novena");
    tienda.añadirConsola("Xbox Series X", 499.99, 100, "Novena");

    }

    private void visualizarConsola() {
        System.out.println("" + tienda);
    }

    private void visualizarVentana() {
      //parent component, mensaje, titulo de la ventana, icono que sale
      JOptionPane.showMessageDialog(null, tienda.toString(), NOM, 1);
    }
}
