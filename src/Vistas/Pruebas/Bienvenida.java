
package Vistas.Pruebas;

import Modelo.inicio_sesion;
import Vistas.Mensajes.estrategias;
import Vistas.Mensajes.ima_profe_1;

public class Bienvenida extends javax.swing.JPanel {

    public Bienvenida() {
        initComponents();
        String titulo_a_v_d ="<html>"
                + "<body>"
                + "<h1>¿A quién va dirigido?<h1>"
                + "</body>"
                + "</html>";
        String t = "<html>"
                + "<body>Dirigido a cada uno de nuestros estudiantes de los ocho programas <br> "
                + "académicos que designan a sus docentes tutores."
                + "</body></html>";        
          String msge = "<html>"
                + "<body>LA TUTORIA ES EL ACOMPAÑAMIENTO PERMANENTE QUE REALIZA EL DOCENTE A SUS ALUMNOS,DESDE QUE ESTOS <br> "
                + "INGRESAN HASTA QUE EGRESAN(MINEDU)."
                + "</body></html>";
        lbltutoria.setText(msge);
        
        String rpt_benficio = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h2 { text-align: center; margin-top: 0; }"
                + "p { text-align: justify; margin: 0; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h2>¿CUÁLES SON LOS BENEFICIOS DEL REGISTRO Y LA ATENCIÓN?</h2>"
                + "<p>A la Institución nos ayuda a conocer las causas por las cuales <br>"
                + "nuestros alumnos: faltan, rinden por debajo de la media, <br>"
                + "desertan o abandonan los estudios, ya sea por salud, trabajo, <br>"
                + "problemas familiares, etc.</p>"
                + "</body></html>";
        lbl_txt_a_q_v_d.setText(rpt_benficio);
         mostrar();
    }
    
    private void mostrar(){
        lblmsg.setText("Bienvenido, " + inicio_sesion.nombre +" "+ inicio_sesion.apellido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo_tutoria = new javax.swing.JLabel();
        titulo_csr = new javax.swing.JLabel();
        panel_abajo = new Controladores.PanelRound();
        panelRound2 = new Controladores.PanelRound();
        lbltutoria = new javax.swing.JLabel();
        btn_ima_a_p = new rojeru_san.complementos.RSButtonHover();
        panelRound3 = new Controladores.PanelRound();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_ima_estra = new rojeru_san.complementos.RSButtonHover();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        lbl_txt_a_q_v_d = new javax.swing.JLabel();
        panelRound1 = new Controladores.PanelRound();
        lblmsg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        titulo_tutoria.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        titulo_tutoria.setForeground(new java.awt.Color(153, 0, 0));
        titulo_tutoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_tutoria.setText("TUTORÍA EN EL IESTP");

        titulo_csr.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titulo_csr.setForeground(new java.awt.Color(0, 153, 204));
        titulo_csr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_csr.setText(" “CARLOS SALAZAR ROMERO”");

        panel_abajo.setBackground(java.awt.SystemColor.activeCaption);
        panel_abajo.setRoundBottomLeft(100);
        panel_abajo.setRoundTopRight(100);
        panel_abajo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltutoria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbltutoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound2.add(lbltutoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 886, 50));

        btn_ima_a_p.setBackground(new java.awt.Color(232, 233, 232));
        btn_ima_a_p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-tutoring-70.png"))); // NOI18N
        btn_ima_a_p.setColorHover(java.awt.SystemColor.activeCaption);
        btn_ima_a_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ima_a_pActionPerformed(evt);
            }
        });
        panelRound2.add(btn_ima_a_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 126, 60));

        panel_abajo.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 1280, 80));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 23, 340));

        jLabel22.setBackground(new java.awt.Color(0, 153, 204));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Estrategias de Intervención Tutorial");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 460, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Classroom-cuate (1).png"))); // NOI18N
        jLabel23.setText("IMAGEN");
        panelRound3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, -10, 500, 400));

        btn_ima_estra.setBackground(java.awt.SystemColor.activeCaption);
        btn_ima_estra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-task-70.png"))); // NOI18N
        btn_ima_estra.setColorHover(java.awt.SystemColor.scrollbar);
        btn_ima_estra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ima_estraActionPerformed(evt);
            }
        });
        panelRound3.add(btn_ima_estra, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 80, 60));
        panelRound3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 650, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cansado.png"))); // NOI18N
        panelRound3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 210, 120));

        lbl_txt_a_q_v_d.setBackground(new java.awt.Color(0, 102, 204));
        lbl_txt_a_q_v_d.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_txt_a_q_v_d.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_txt_a_q_v_d.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound3.add(lbl_txt_a_q_v_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 620, 170));

        panel_abajo.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1280, 340));

        panelRound1.setBackground(java.awt.SystemColor.activeCaption);
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmsg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblmsg.setForeground(new java.awt.Color(255, 255, 255));
        lblmsg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblmsg.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblmsg.setVerifyInputWhenFocusTarget(false);
        panelRound1.add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 500, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo_tutoria, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(titulo_csr, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo_tutoria)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(titulo_csr)))
                .addGap(24, 24, 24)
                .addComponent(panel_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ima_a_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ima_a_pActionPerformed
        Vistas.Mensajes.ima_profe_1 m = new ima_profe_1(null,true);
        m.setVisible(true);
    }//GEN-LAST:event_btn_ima_a_pActionPerformed

    private void btn_ima_estraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ima_estraActionPerformed
        Vistas.Mensajes.estrategias m = new estrategias(null,true);
        m.setVisible(true);
    }//GEN-LAST:event_btn_ima_estraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_ima_a_p;
    private rojeru_san.complementos.RSButtonHover btn_ima_estra;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_txt_a_q_v_d;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JLabel lbltutoria;
    private Controladores.PanelRound panelRound1;
    private Controladores.PanelRound panelRound2;
    private Controladores.PanelRound panelRound3;
    private Controladores.PanelRound panel_abajo;
    private javax.swing.JLabel titulo_csr;
    private javax.swing.JLabel titulo_tutoria;
    // End of variables declaration//GEN-END:variables
}
