
import Controladores.Internet;
//import Controladores.Usuario;
import Vistas.Incio_sesion.InicioSesion;
import Vistas.Mensajes.SinInternet;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class PantallaCarga extends javax.swing.JFrame {

    private Point initialClick;

    public PantallaCarga() {
        setUndecorated(true);
        initComponents();
        setSize(920, 580);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 25, 25);
        this.setShape(forma);
        setDefaultCloseOperation(PantallaCarga.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mensaje();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("iconos/t.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panelprincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelcarga = new javax.swing.JPanel();
        panelRound2 = new Controladores.PanelRound();
        lblcarga = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblcon = new javax.swing.JLabel();
        progrescon = new javax.swing.JProgressBar();
        lbl_txt = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(" \n LA TUTORIA ES EL ACOMPAÑAMIENTO PERMANENTE \n QUE REALIZA EL DOCENTE A SUS ALUMNOS,DESDE \n QUE ESTOS INGRESAN HASTA QUE EGRESAN\n (MINEDU).");
        jTextArea1.setBorder(null);
        jTextArea1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(183, 255, 250));
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setResizable(false);

        panelprincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Teaching-cuate (3).png"))); // NOI18N
        panelprincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 520));

        panelcarga.setBackground(new java.awt.Color(0, 153, 204));
        panelcarga.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelcargaMouseDragged(evt);
            }
        });
        panelcarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelcargaMousePressed(evt);
            }
        });
        panelcarga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(40);
        panelRound2.setRoundBottomRight(40);
        panelRound2.setRoundTopLeft(40);
        panelRound2.setRoundTopRight(40);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound2.add(lblcarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 310, 30));

        ProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        ProgressBar.setForeground(new java.awt.Color(0, 153, 204));
        panelRound2.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 330, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel4.setText("REGISTRO DE ATENCION TUTORIAL ");
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 310, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("© 2024");
        jLabel5.setToolTipText("");
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 20));
        panelRound2.add(lblcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 310, 30));

        progrescon.setBackground(new java.awt.Color(255, 255, 255));
        progrescon.setForeground(new java.awt.Color(0, 153, 204));
        panelRound2.add(progrescon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 330, -1));
        panelRound2.add(lbl_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 330, 170));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Formando ciudadanos");
        panelRound2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, 50));
        panelRound2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("V: 1.50.1");
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 60, 20));

        panelcarga.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 390, 510));

        panelprincipal.add(panelcarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelcargaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcargaMousePressed
        initialClick = evt.getPoint();
    }//GEN-LAST:event_panelcargaMousePressed

    private void panelcargaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelcargaMouseDragged
        int x = this.getLocation().x + evt.getX() - initialClick.x;
        int y = this.getLocation().y + evt.getY() - initialClick.y;
        this.setLocation(x, y);
    }//GEN-LAST:event_panelcargaMouseDragged

    private void panelRound1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MousePressed
        initialClick = evt.getPoint();
    }//GEN-LAST:event_panelRound1MousePressed

    private void panelRound1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseDragged
        int x = this.getLocation().x + evt.getX() - initialClick.x;
        int y = this.getLocation().y + evt.getY() - initialClick.y;
        this.setLocation(x, y);
    }//GEN-LAST:event_panelRound1MouseDragged
    private void setProgressConexion(int progress) {
        progrescon.setValue(progress);
        lblcon.setText("Conectando a la base de datos: " + progress + "%");
    }

    private void setProgressComponentes(int progress) {
        ProgressBar.setValue(progress);
        lblcarga.setText("Cargando componentes: " + progress + "%");

    }

    private void abrirInicioSesion() {
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
    }

    private void cerrar() {
        this.dispose();
    }
//
//    private void SinInternet() {
//        sin.setVisible(true);
//    }

    private void mensaje() {
        String d = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h4 { margin-bottom: 5px; }"
                + "p { margin: 5px 0; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h4>Programa realizado conjuntamente con los docentes:</h4>"
                + "<p>Dr. Lorenzo Flores Mederos</p>"
                + "<p>Ing. John Veliz Cruz</p>"
                + "<p>Programado por: Tec. Alan Cueva Tello</p>"
                + "</body>"
                + "</html>";
        lbl_txt.setText(d);
    }

    public static void main(String[] args) {
        PantallaCarga carga = new PantallaCarga();
//        Internet i = new Internet();
        carga.setVisible(true);
        SwingWorker<Connection, Integer> worker = new SwingWorker<Connection, Integer>() {
            @Override
            protected Connection doInBackground() throws Exception {
                try {
                    for (int i = 0; i <= 100; i++) {
                        TimeUnit.MILLISECONDS.sleep(30); // Simula una tarea que toma tiempo
                        carga.setProgressComponentes(i); // Actualiza el progreso de carga de componentes
                    }

                    for (int i = 0; i <= 100; i++) {
                        TimeUnit.MILLISECONDS.sleep(10); // Simula una tarea que toma tiempo
                        carga.setProgressConexion(i); // Actualiza el progreso de conexión
                    }
                    // Simula un tiempo de espera adicional para la conexión a la base de datos
                } catch (InterruptedException e) {
                    System.out.println("Error " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    SwingUtilities.invokeLater(() -> {
//                        i.addListener(isConnected -> {
//                            if (isConnected) {
                        carga.cerrar();
                        carga.abrirInicioSesion();
//                            } else {
////                                SwingUtilities.invokeLater(() -> {
//                                carga.SinInternet();
////                                });
//                                carga.cerrar();
//                            }
//                        });
//                        i.startMonitoring();
                    });
                } catch (InterruptedException | ExecutionException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        };

        worker.addPropertyChangeListener(evt
                -> {
            if ("progress".equals(evt.getPropertyName())) {
                carga.ProgressBar.setValue((Integer) evt.getNewValue());
            }
        }
        );

        worker.execute();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_txt;
    private javax.swing.JLabel lblcarga;
    private javax.swing.JLabel lblcon;
    private Controladores.PanelRound panelRound2;
    private javax.swing.JPanel panelcarga;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JProgressBar progrescon;
    // End of variables declaration//GEN-END:variables
}
