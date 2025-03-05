package Vistas.Administracion;

import Modelo.inicio_sesion;
import Vistas.Mensajes.Acercade;
import Vistas.Pruebas.Historial;
import Vistas.Pruebas.Perfil;
import Vistas.Pruebas.Registro;
import Vistas.instrumento.Registro_Tutorial;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Administrador extends javax.swing.JFrame {

    private final Bienvenida b = new Bienvenida();
    private final Vistas.Pruebas.Bienvenida bien = new Vistas.Pruebas.Bienvenida();
    private final ReporteMensual rm = new ReporteMensual();
    private final ReporteGeneralMes rgm = new ReporteGeneralMes();
    private final AreaAtencion aa = new AreaAtencion();
    private final Docentes d = new Docentes();
    private final inicio_sesion is = new inicio_sesion();
//    private final AsignarTutoria at = new AsignarTutoria();
    private final Registro_Tutorial rt = new Registro_Tutorial();

    public Administrador() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(Administrador.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Administrador");
        jMenuBar1.setLayout(new BoxLayout(jMenuBar1, BoxLayout.X_AXIS));
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu4);
//        getContentPane().setLayout(new BorderLayout());
        mostrarPanel(b);
        mostrar();
    }

    private void mostrar(){
         String d = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h1 { margin-bottom: 0px; }"
                + "p { text-align: right; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>"+inicio_sesion.nombre+ "</h1>"
                + "<p>Administrador</p>"
                + "</body>"
                + "</html>";
        jMenu4.setText(d);
        jMenu4.updateUI();
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

        panelPrincipal = new javax.swing.JPanel();
        inicio = new javax.swing.JPanel();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        registro_docente = new javax.swing.JMenuItem();
        asignar_tutoria = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        perfil = new javax.swing.JMenuItem();
        registor_tutorial = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        inicio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        panelPrincipal.add(inicio, java.awt.BorderLayout.CENTER);

        jMenuItem9.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-hojas-de-cálculo-30.png"))); // NOI18N
        jMenuItem9.setText(" Simulador de Registro Tutorial");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setRequestFocusEnabled(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-opciones-30.png"))); // NOI18N
        jMenu1.setText(" Menú Administrador");
        jMenu1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-cuadrado-de-información-30.png"))); // NOI18N
        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-casa-30.png"))); // NOI18N
        jMenuItem7.setText(" Inicio");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-usuario-30.png"))); // NOI18N
        jMenu3.setText("Docentes");
        jMenu3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N

        registro_docente.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        registro_docente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-registro-30 (1).png"))); // NOI18N
        registro_docente.setText("Registro de Docente");
        registro_docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro_docenteActionPerformed(evt);
            }
        });
        jMenu3.add(registro_docente);

        asignar_tutoria.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        asignar_tutoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-registro-30.png"))); // NOI18N
        asignar_tutoria.setText("Asignar Tutoria");
        asignar_tutoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignar_tutoriaActionPerformed(evt);
            }
        });
        jMenu3.add(asignar_tutoria);

        jMenu1.add(jMenu3);

        jMenuItem2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/id_90968 (1).png"))); // NOI18N
        jMenuItem2.setText("Área de Atención");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-nueva-hoja-de-cálculo-30.png"))); // NOI18N
        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-reporte-de-negocios-25.png"))); // NOI18N
        jMenuItem4.setText("Reporte Mensual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem8.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-reporte-de-negocios-25.png"))); // NOI18N
        jMenuItem8.setText(" Reporte General");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenu1.add(jMenu2);
        jMenu1.add(jSeparator1);

        jMenuItem5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-x-25.png"))); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-usuario-masculino-en-círculo-45.png"))); // NOI18N
        jMenu4.setText("Docente");
        jMenu4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        perfil.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        perfil.setText(" Perfil");
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        jMenu4.add(perfil);

        registor_tutorial.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        registor_tutorial.setText("Registro Tutorial");
        registor_tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registor_tutorialActionPerformed(evt);
            }
        });
        jMenu4.add(registor_tutorial);

        jMenuItem3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem3.setText("Bienvenida Docente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem6.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jMenuItem6.setText(" Historial");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(jMenu4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Acercade ace = new Acercade(this, true);
        ace.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        mostrarPanel(b);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        mostrarPanel(aa);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        mostrarPanel(rm);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void registro_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro_docenteActionPerformed
        mostrarPanel(d);
    }//GEN-LAST:event_registro_docenteActionPerformed

    private void asignar_tutoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignar_tutoriaActionPerformed
        AsignarTutoria at = new AsignarTutoria();
        mostrarPanel(at);
    }//GEN-LAST:event_asignar_tutoriaActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Registro r = new Registro();
        mostrarPanel(r);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        mostrarPanel(rgm);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void registor_tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registor_tutorialActionPerformed
//        Registro_Tutorial rt = new Registro_Tutorial();
        mostrarPanel(rt);
    }//GEN-LAST:event_registor_tutorialActionPerformed

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        Perfil p = new Perfil();
        mostrarPanel(p);
    }//GEN-LAST:event_perfilActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        mostrarPanel(bien);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Historial  h = new Historial();
        mostrarPanel(h);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Administrador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem asignar_tutoria;
    private javax.swing.JPanel inicio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JMenuItem perfil;
    private javax.swing.JMenuItem registor_tutorial;
    private javax.swing.JMenuItem registro_docente;
    // End of variables declaration//GEN-END:variables
}
