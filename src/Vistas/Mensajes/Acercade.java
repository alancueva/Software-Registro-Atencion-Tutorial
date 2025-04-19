
package Vistas.Mensajes;

import utils.DragComponentHelper;


public class Acercade extends javax.swing.JDialog {

    private final DragComponentHelper dragComponentHelper_;
    private final DragComponentHelper dragComponentHelper_1;
    private final DragComponentHelper dragComponentHelper_2;
    
    public Acercade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dragComponentHelper_ = new DragComponentHelper(jPanel1);     
        this.dragComponentHelper_1 = new DragComponentHelper(jLabel12);
        this.dragComponentHelper_2 = new DragComponentHelper(panelRound1);
        setTitle("Acerca De");
        setSize(884, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        String d ="<html>"
                 + "<body>"
                 + "<h4>Programa realizado conjuntamente con los docentes</h4>"
//                 + "<br>"
                 + "Dr. Lorenzo Flores Mederos"
                 + "<br>"
                 + "Ing. John Veliz Cruz"
                 + "<br>"
                 + "Programado por: Tec. Alan Cueva Tello"
                 + "</body>"
                 + "</html>";
        lbl_txt.setText(d);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new Controladores.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_txt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setFocusable(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setModal(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("© 2024");
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Formando ciudadanos");
        panelRound1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Version: 1.50.1");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 20));

        lbl_txt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRound1.add(lbl_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 300, 140));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel4.setText("REGISTRO DE ATENCION TUTORIAL ");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 50, 310, -1));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 360, 390));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Learning-bro (1).png"))); // NOI18N
        jLabel12.setFocusable(false);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, -70, 600, 620));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 960, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Acercade dialog = new Acercade(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_txt;
    private Controladores.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
