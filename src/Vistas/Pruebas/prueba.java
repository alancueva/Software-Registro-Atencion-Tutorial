
package Vistas.Pruebas;

import Modelo.Docentes;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class prueba extends javax.swing.JFrame {
    private final Bienvenida b = new Bienvenida();
    private final Historial h = new Historial();
    private final Registro r = new Registro();
    private final Perfil p = new Perfil();
    Docentes du = new Docentes();
//    private JMenu menu;
//    private JMenuItem tutoria, menuinicio, menuficha,ima;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public prueba() {
        setIconImage(getIconImage());
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); 
        setDefaultCloseOperation(prueba.EXIT_ON_CLOSE);
        this.setTitle("Registro de Atención Tutorial");
        //this.setVisible(true);
        mostrarPanel(b);
       
        // Configurar el diseño del JMenuBar
        jMenuBar1.setLayout(new BoxLayout(jMenuBar1, BoxLayout.X_AXIS));
        // Añadir JMenu1 a la izquierda
        jMenuBar1.add(jMenu1);
        // Agregar espacio flexible para centrar los JMenu2 y JMenu3
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu2 centrado
        jMenuBar1.add(jMenu2);
        // Añadir JMenu3 centrado
        jMenuBar1.add(jMenu3);
        // Añadir espacio flexible a la derecha
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu4 a la derecha
        jMenuBar1.add(jMenu4);
        
        
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/t.png"));
        return retValue;
    }
     public void mostrarNombreDocente() {
//        txtnombre.setText(nombre);
        String nombre = du.getNombre();
        jMenu4.setText(nombre);
        jMenu4.updateUI();
    } 
    private void mostrarPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER); 
        revalidate();
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        config = new javax.swing.JMenuItem();
        Historial = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(getIconImages());
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cropped-cropped (1).png"))); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Inicio");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Registro");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-usuario-30.png"))); // NOI18N
        jMenu4.setText("Docente");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        config.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        config.setText("Configuración");
        config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configMouseClicked(evt);
            }
        });
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });
        jMenu4.add(config);

        Historial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Historial.setText("Historial");
        Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistorialMouseClicked(evt);
            }
        });
        Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialActionPerformed(evt);
            }
        });
        jMenu4.add(Historial);

        salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salir.setText("Salir");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu4.add(salir);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        mostrarPanel(b);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        mostrarPanel(r);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void configMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMouseClicked
         
    }//GEN-LAST:event_configMouseClicked

    private void HistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialMouseClicked
        
    }//GEN-LAST:event_HistorialMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        
    }//GEN-LAST:event_salirMouseClicked

    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        // TODO add your handling code here:
        mostrarPanel(p);
    }//GEN-LAST:event_configActionPerformed

    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
         mostrarPanel(h);
    }//GEN-LAST:event_HistorialActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Historial;
    private javax.swing.JMenuItem config;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
}
