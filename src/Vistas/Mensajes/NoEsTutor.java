package Vistas.Mensajes;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import utils.DragComponentHelper;

public class NoEsTutor extends javax.swing.JDialog {
    
    private final DragComponentHelper dragComponentHelper_1;
    private final DragComponentHelper dragComponentHelper_2;
    private final DragComponentHelper dragComponentHelper_3;

    public NoEsTutor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dragComponentHelper_1 = new DragComponentHelper(jPanel2);
        this.dragComponentHelper_2 = new DragComponentHelper(jLabel1);
        this.dragComponentHelper_3 = new DragComponentHelper(lbl_msg);
        setSize(730, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        this.setShape(forma);

    }

    public void mensajeNOESTUTOR(String nombre, String apellido) {
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();
        String mensaje = "<html>"
            + "<head>"
            + "<style>"
            + "body { font-family: Arial, sans-serif; text-align: center; }"
            + "h1 { color: #fff;  text-align: center;}"
            + "p { font-size: 25px; color: #fff;}"
            + "</style>"
            + "</head>"
            + "<body>"
            + "<h1>HOLA!</h1>"
            + "<p>" + nombre + "</p>"
            + "<p>" + apellido + "</p>"
            + "</body>"
            + "</html>";

        lbl_msg.setText(mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        lbl_msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Professor-pana (2).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Actualmente no estás Asignado como tutor");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonHover1.setText("Salir");
        rSButtonHover1.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 90, 40));

        lbl_msg.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_msg.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 370, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        dispose();
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            NoEsTutor dialog = new NoEsTutor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_msg;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    // End of variables declaration//GEN-END:variables
}
