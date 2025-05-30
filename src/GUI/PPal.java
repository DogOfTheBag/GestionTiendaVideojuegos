package GUI;

import data.Producto;
import data.Tienda;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class PPal extends javax.swing.JPanel {

    VPal v;
    Tienda tienda;
    public PPal(Tienda tienda,VPal v) {
        this.tienda = tienda;
        this.v = v;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonAltasBajasModificaciones = new javax.swing.JButton();
        botonListados = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(3, 1));

        tituloLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("TIENDA DE VIDEOJUEGOS PLEYSTEICHON");
        add(tituloLabel);
        add(jPanel1);

        panelBotones.setLayout(new java.awt.GridLayout(1, 3));

        botonAltasBajasModificaciones.setText("Altas, bajas, modificaciones");
        botonAltasBajasModificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltasBajasModificacionesActionPerformed(evt);
            }
        });
        panelBotones.add(botonAltasBajasModificaciones);

        botonListados.setText("Listados");
        botonListados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListadosActionPerformed(evt);
            }
        });
        panelBotones.add(botonListados);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelBotones.add(botonSalir);

        add(panelBotones);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAltasBajasModificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        v.setContentPane(v.pABM);
        //IMPORTANTE EL REVALIDATE QUE SI NO NO SE CAMBIA EL PANEL ***************************************************
        v.revalidate();
    }//GEN-LAST:event_botonJugarActionPerformed

    private void botonListadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReglasActionPerformed
        v.setContentPane(v.pListados);
        //IMPORTANTE EL REVALIDATE QUE SI NO NO SE CAMBIA EL PANEL ***************************************************
        v.revalidate();

    }//GEN-LAST:event_botonReglasActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        //he puesto unos mensajes por consola, que he tenido problemas al guardar en el archivo, y esto me dice que se ha guardado.
        System.out.println("Guardando productos desde instancia: " + tienda);
        System.out.println("Cantidad de productos: " + tienda.getProductos().size());
        for (Producto p : tienda.getProductos()) {
            System.out.println("Va a guardarse: " + p);
        }
        tienda.guardarProductosEnArchivo("res/productos.txt");
        JOptionPane.showMessageDialog(null, "Guardando productos en el archivo. Hasta la proxima!");
        v.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAltasBajasModificaciones;
    private javax.swing.JButton botonListados;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables
}
