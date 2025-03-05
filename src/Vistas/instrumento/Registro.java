/**
 *
 * @author Alan Cueva
 */
package Vistas.instrumento;

import Modelo.inicio_sesion;
import Vistas.Mensajes.Acercade;
import Vistas.Pruebas.Historial;
import Vistas.Pruebas.Perfil;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Registro extends javax.swing.JFrame {

    private final Vistas.Pruebas.Bienvenida bien = new Vistas.Pruebas.Bienvenida();
    private final Registro_Tutorial rt = new Registro_Tutorial();

    public Registro() {
        initComponents();
        setExtendedState(Instrumento.MAXIMIZED_BOTH);
        setDefaultCloseOperation(Instrumento.EXIT_ON_CLOSE);
        this.setTitle("Registro de Atención Tutorial");
        this.setVisible(true);

        // Configurar el diseño del JMenuBar
        jMenuBar1.setLayout(new BoxLayout(jMenuBar1, BoxLayout.X_AXIS));
        // Añadir JMenu1 a la izquierda
        jMenuBar1.add(tutoria);
        // Agregar espacio flexible para centrar los JMenu2 y JMenu3
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu2 centrado
        jMenuBar1.add(menuinicio);
        // Añadir JMenu3 centrado
        jMenuBar1.add(menuficha);
        // Añadir espacio flexible a la derecha
        jMenuBar1.add(Box.createHorizontalGlue());
        // Añadir JMenu4 a la derecha
        jMenuBar1.add(ima);

        mostrarPanel(bien);
        mostrar();

    }

    private void mostrar() {
        String d = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h1 { margin: 0; }"
                + "p { text-align: right; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>" + inicio_sesion.nombre + "</h1>"
                + "<p>Docente</p>"
                + "</body>"
                + "</html>";
        ima.setText(d);
        ima.updateUI();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/t.png"));
        return retValue;
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
        tutoria = new javax.swing.JMenu();
        menuinicio = new javax.swing.JMenu();
        menuficha = new javax.swing.JMenu();
        ima = new javax.swing.JMenu();
        perfil = new javax.swing.JMenuItem();
        historial = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(340, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(340, 60));
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        tutoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cropped-cropped (1).png"))); // NOI18N
        tutoria.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        tutoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tutoriaMouseClicked(evt);
            }
        });
        jMenuBar1.add(tutoria);

        menuinicio.setBackground(new java.awt.Color(255, 255, 255));
        menuinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cucha-45.png"))); // NOI18N
        menuinicio.setText("Inicio");
        menuinicio.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        menuinicio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        menuinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuinicioMouseClicked(evt);
            }
        });
        menuinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuinicioActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuinicio);

        menuficha.setBackground(new java.awt.Color(255, 255, 255));
        menuficha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-documento-45.png"))); // NOI18N
        menuficha.setText("Registro");
        menuficha.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        menuficha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        menuficha.setMinimumSize(new java.awt.Dimension(73, 40));
        menuficha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menufichaMouseClicked(evt);
            }
        });
        menuficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menufichaActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuficha);

        ima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-usuario-masculino-en-círculo-45.png"))); // NOI18N
        ima.setText("Docente");
        ima.setAlignmentX(10.5F);
        ima.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ima.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        ima.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ima.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imaMouseClicked(evt);
            }
        });

        perfil.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-ajustes-30.png"))); // NOI18N
        perfil.setText("Perfil");
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        ima.add(perfil);

        historial.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-pasado-30.png"))); // NOI18N
        historial.setText("Historial");
        historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialActionPerformed(evt);
            }
        });
        ima.add(historial);

        salir.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cierre-de-sesión-redondeado-hacia-abajo-30.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        ima.add(salir);

        jMenuBar1.add(ima);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tutoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutoriaMouseClicked
        Acercade ace = new Acercade(this, rootPaneCheckingEnabled);
        ace.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_tutoriaMouseClicked

    private void menuinicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuinicioMouseClicked
        mostrarPanel(bien);
    }//GEN-LAST:event_menuinicioMouseClicked

    private void menufichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menufichaMouseClicked
        mostrarPanel(rt);
    }//GEN-LAST:event_menufichaMouseClicked

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        Perfil p = new Perfil();
        mostrarPanel(p);
    }//GEN-LAST:event_perfilActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
        Historial h = new Historial();
        mostrarPanel(h);
    }//GEN-LAST:event_historialActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void imaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imaMouseClicked

    }//GEN-LAST:event_imaMouseClicked

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked

    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void menuinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuinicioActionPerformed

    }//GEN-LAST:event_menuinicioActionPerformed

    private void menufichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menufichaActionPerformed

    }//GEN-LAST:event_menufichaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem historial;
    private javax.swing.JMenu ima;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuficha;
    private javax.swing.JMenu menuinicio;
    private javax.swing.JMenuItem perfil;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenu tutoria;
    // End of variables declaration//GEN-END:variables
}
