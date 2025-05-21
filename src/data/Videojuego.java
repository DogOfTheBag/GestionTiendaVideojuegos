package data;

import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Videojuego extends Producto {
    protected String genero;
    

    public Videojuego(String nombre, String genero, double precio, int stock) {
        super(nombre, precio, stock);
        this.genero = genero;
    }
    //verificacion de precio y stock estatico para la funcion xEsValido
    static boolean verificarPrecio(double precio) throws Exception  {
        if(precio >= 5)
            return true;
        else
            throw new Exception("El precio debe ser mayor que 5 euros");
    }

    static boolean verificarStock(int stock) throws Exception {
         if(stock >= 0)
            return true;
        else
            throw new Exception("El stock debe ser 0 o más");
    }

    static boolean videojuegoEsValido(String nombre, String genero, double precio, int stock) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  nombre + " | Genero: " + genero + " | Precio: " + precio + "€ | Stock: " + stock + " uds";
    }
}
