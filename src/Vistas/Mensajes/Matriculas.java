package Vistas.Mensajes;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import utils.DragComponentHelper;

public class Matriculas extends javax.swing.JDialog {

    private final DragComponentHelper dragComponentHelper_1;
    private final DragComponentHelper dragComponentHelper_2;
    private final DragComponentHelper dragComponentHelper_3;

    public Matriculas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dragComponentHelper_1 = new DragComponentHelper(jLabel2);
        this.dragComponentHelper_2 = new DragComponentHelper(jPanel1);
        this.dragComponentHelper_3 = new DragComponentHelper(text);
        this.setSize(610, 335);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 20, 20);
        this.setShape(forma);
        String mensaje = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; text-align: center; }"
                + "p { font-size: 15px; color: #fff;  text-align: justify; hyphens: auto;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<p>Actualmente nos encontramos </p>"
                + "<p>en registro de matriculas.</p>"
                + "<p>Un ves culminada las matriculas</p> "
                + "<p>comenzarás a registrar tu atención.</p>"
                + "</body>"
                + "</html>";

        text.setText(mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Forms-cuate (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonHover1.setText("Salir");
        rSButtonHover1.setColorHover(new java.awt.Color(0, 51, 51));
        rSButtonHover1.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 90, -1));

        text.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        text.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 310, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        dispose();
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            Matriculas dialog = new Matriculas(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
