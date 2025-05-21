package data;

import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Consola extends Producto {
    protected String generacion;
    
    public Consola(String nombre, double precio, int stock, String generacion) {
        super(nombre, precio, stock);
        this.generacion = generacion;
    }
    //verificacion de precio y stock estatico para la funcion xEsValido
        static boolean verificarPrecio(double precio) throws Exception  {
        if(precio >= 5)
            return true;
        else
            throw new Exception("El precio debe ser 5 euros o mas");
    }

    static boolean verificarStock(int stock) throws Exception {
         if(stock >= 0)
            return true;
        else
            throw new Exception("El stock debe ser 0 o más");
    }

    static boolean consolaEsValido(String nombre, double precio, int stock, String generacion) {
        try{
            if (verificarPrecio(precio) && verificarStock(stock))
            return true;
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false;
    }


    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    @Override
    public String toString() {
        return  nombre + " | precio: " + precio + "€ | Stock: " + stock + " uds | Generacion: " + generacion; 
    }
}
