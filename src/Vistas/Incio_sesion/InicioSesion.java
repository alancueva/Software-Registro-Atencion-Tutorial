/**
 *
 * @author Alan Cueva
 */
package Vistas.Incio_sesion;

import Controladores.Usuario;
import Modelo.Docentes;
import Modelo.inicio_sesion;
import Vistas.Administracion.Administrador;
import Vistas.Mensajes.Matriculas;
import Vistas.Mensajes.NoEsTutor;
import Vistas.Mensajes.NoEstarEnLista;
import java.awt.Shape;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class InicioSesion extends javax.swing.JFrame {

    Usuario r = new Usuario();
    Docentes du = new Docentes();
    inicio_sesion is = new inicio_sesion();
    private Point initialClick;
    private final JWindow tooltipWindow;
    private final JLabel tooltipLabel;
    private Timer timer;

    public InicioSesion() {
        initComponents();
        setDefaultCloseOperation(InicioSesion.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setSize(950, 600);
        this.setResizable(false);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 25, 25);
        this.setShape(forma);

        tooltipWindow = new JWindow();
        tooltipLabel = new JLabel("Cerrar");
        tooltipLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        tooltipLabel.setBackground(Color.LIGHT_GRAY);
        tooltipLabel.setOpaque(true);
        tooltipWindow.getContentPane().add(tooltipLabel);
        tooltipWindow.pack();
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

        lblclave = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_X = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_msg = new javax.swing.JLabel();
        panelRound2 = new Controladores.PanelRound();
        btninicio = new rojeru_san.complementos.RSButtonHover();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblcarga = new javax.swing.JLabel();
        txtdni = new app.bolivia.swing.JCTextField();
        lblerrorclave = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        chkm = new com.icm.components.metro.CheckBoxMetroICM();
        lblmsg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblerrordni = new javax.swing.JLabel();
        txtclave = new javax.swing.JPasswordField();

        lblclave.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_X.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        lbl_X.setForeground(new java.awt.Color(255, 255, 255));
        lbl_X.setText("X");
        lbl_X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_XMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_XMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_XMouseExited(evt);
            }
        });
        jPanel1.add(lbl_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 30, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Teacher-cuate (1).png"))); // NOI18N
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel8MouseDragged(evt);
            }
        });
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 470, 450));
        jPanel1.add(lbl_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 430, 20));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(80);
        panelRound2.setRoundBottomRight(80);
        panelRound2.setRoundTopLeft(80);
        panelRound2.setRoundTopRight(80);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninicio.setText("Iniciar Sesión");
        btninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioActionPerformed(evt);
            }
        });
        panelRound2.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 216, -1));

        jLabel14.setText("Ingrese su Contraseña");
        panelRound2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/id_90968 (1).png"))); // NOI18N
        panelRound2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 40, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("INICIO DE SESIÓN");
        panelRound2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user_icon_172810 (2).png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setName(""); // NOI18N
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 140, 120));
        panelRound2.add(lblcarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 200, 30));

        txtdni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdniMouseClicked(evt);
            }
        });
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });
        panelRound2.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 220, 40));
        panelRound2.add(lblerrorclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 220, 20));

        jLabel15.setText("Ingrese su DNI");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        chkm.setText("  Mostrar Contraseña");
        chkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmActionPerformed(evt);
            }
        });
        panelRound2.add(chkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        panelRound2.add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 300, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3643755-hide-lock-locked-padlock-private_113428 (1).png"))); // NOI18N
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 40, 40));
        panelRound2.add(lblerrordni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 220, 20));

        txtclave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtclaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclaveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclaveKeyTyped(evt);
            }
        });
        panelRound2.add(txtclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 220, 40));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 420, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioActionPerformed
        entrar();
    }//GEN-LAST:event_btninicioActionPerformed
    private boolean isSpecialCharacter(char c) {
        String specialCharacters = "!@#$%^&*()-_+=<>?";
        return specialCharacters.contains(String.valueOf(c));
    }

    private boolean isLowerCaseOnly(char[] text) {
        for (char c : text) {
            if (c >= 'A' && c <= 'Z') {
                return false;
            }
        }
        return true;
    }

    private boolean mayu(char[] text) {
        for (char c : text) {
            if (c >= 'A' && c <= 'Z') {
                return false;
            }
        }
        return true;
    }

    private void verificar() {
        if (isLowerCaseOnly(txtclave.getPassword()) && Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo minúsculas. ¡La tecla Mayús está activado!");
            lblmsg.setVisible(true);
        } else if (isLowerCaseOnly(txtclave.getPassword())) {
            lblmsg.setText("");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
        }

    }

    private void entrar() {

        String d = txtdni.getText();
        String cla = new String(txtclave.getPassword());

        if (d.trim().isEmpty()) {
            lblerrordni.setText("Ingrese Su DNI por favor");
            lblerrordni.setForeground(java.awt.Color.RED);
            txtdni.requestFocus();
            return;
        }
        if (cla.trim().isEmpty()) {
            lblerrorclave.setText("Este campo es Obligatorio");
            lblerrorclave.setForeground(java.awt.Color.RED);
            txtclave.requestFocus();
            return;
        }
        Thread cargaDatosThread = new Thread(() -> {
            SwingUtilities.invokeLater(() -> {
                btninicio.setEnabled(false);
                btninicio.setText("Cargando...");
            });
            Map<String, String> resultado = r.inicio_sesion(d, cla);
            if (resultado.isEmpty()) {
                NoEstarEnLista nel = new NoEstarEnLista(this, true);
                nel.setVisible(true);
                SwingUtilities.invokeLater(() -> {
                    btninicio.setEnabled(true);
                    btninicio.setText("Iniciar sesión");
                });
                return;
            }
            inicio_sesion.setUserData(resultado);

            String rol = inicio_sesion.rol;
            String Matricula = inicio_sesion.estado_matricula;
            switch (Matricula) {
                case "MA" -> {
                    if ("Admin".equals(rol)) {
                        Administrador ins = new Administrador();
                        ins.setVisible(true);
                        this.dispose();
                    } else {
                        Matriculas m = new Matriculas(this, true);
                        m.setVisible(true);
                        SwingUtilities.invokeLater(() -> {
                            btninicio.setEnabled(true);
                            btninicio.setText("Iniciar sesión");
                        });
                    }
                }
                case "MC" -> {
                    switch (rol) {
                        case "Admin" -> {
                            Administrador ins = new Administrador();
                            ins.setVisible(true);
                            this.dispose();
                        }
                        case "Docente" -> {
                            if ("NO ES TUTOR".equals(inicio_sesion.turno) && "NO ES TUTOR".equals(inicio_sesion.ciclo)) {
                                mostrarVentanaNoEsTutor(inicio_sesion.nombre, inicio_sesion.apellido);
                            } else {
                                Vistas.instrumento.Registro reg = new Vistas.instrumento.Registro();
                                reg.setVisible(true);
                                this.dispose();
                            }
                        }
                        default ->
                            JOptionPane.showMessageDialog(this, "Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                default ->
                    throw new AssertionError();
            }
        });
        cargaDatosThread.start();

    }

    private void mostrarVentanaNoEsTutor(String nombre, String apellido) {
        NoEsTutor nst = new NoEsTutor(this, true);
        nst.mensajeNOESTUTOR(nombre, apellido);
        nst.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                btninicio.setEnabled(true);
                btninicio.setText("Iniciar sesión");
            }
        });
        nst.setVisible(true);
    }

//    private void mostrarVentanaDocente() {
//        Instrumento inst = new Instrumento();
//        inst.codigo(inicio_sesion.idusuario);
//        inst.mostrarBienvenidaDocente(inicio_sesion.nombre + " " + inicio_sesion.apellido);
//        inst.mostrarNombreDocente(inicio_sesion.nombre);
//        inst.mostrarApelledioDocente(inicio_sesion.apellido);
//        inst.mostrardni(inicio_sesion.dni);
//        inst.MostarCorreo(inicio_sesion.correo);
//        inst.mostrarNomApeDocente(inicio_sesion.nombre + " " + inicio_sesion.apellido);
//        inst.MostrarNomApe(inicio_sesion.nombre, inicio_sesion.apellido);
//        inst.mostrarprograma(inicio_sesion.programa);
//        inst.Mostrar_turno(inicio_sesion.turno);
//        inst.Mostrar_ciclo(inicio_sesion.ciclo);
//        inst.setVisible(true);
//        this.dispose();
//    }

    private void lbl_XMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_XMouseClicked
//        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_lbl_XMouseClicked

    private void txtdniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdniMouseClicked
        txtdni.setFocusable(true);
    }//GEN-LAST:event_txtdniMouseClicked

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        txtdni.setFocusable(true);
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyPressed
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
            lblerrordni.setText("");
        }
        txtdni.setFocusable(true);
    }//GEN-LAST:event_txtdniKeyPressed

    private void txtdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyReleased
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
            lblerrordni.setText("");
        }
    }//GEN-LAST:event_txtdniKeyReleased

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || txtdni.getText().length() >= 8) {
            evt.consume(); // Consume el evento si no es un dígito o si la longitud es mayor a 8
        }
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
            lblerrordni.setText("");
        }
        txtdni.setFocusable(true);
    }//GEN-LAST:event_txtdniKeyTyped

    private void chkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmActionPerformed
        if (chkm.isSelected()) {
            txtclave.setEchoChar((char) 0); // Mostrar caracteres
        } else {
            txtclave.setEchoChar('*'); // Ocultar caracteres
        }
        String c = new String(txtclave.getPassword());
        if (c.isEmpty()) {
            txtclave.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chkmActionPerformed

    private void txtclaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclaveKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_V && evt.isControlDown()) || (evt.getKeyCode() == KeyEvent.VK_INSERT && evt.isShiftDown())) {
            // Deshabilitar la combinación CTRL+V y Shift+Insert
            evt.consume();
        }
        verificar();
        lblerrorclave.setText("");
    }//GEN-LAST:event_txtclaveKeyPressed

    private void txtclaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclaveKeyReleased
        verificar();
        char c = (char) evt.getKeyCode();
        lblerrorclave.setText("");
        if (c == KeyEvent.VK_ENTER) {
//            i.addListener(isConnected -> {
//                if (isConnected) {
//                    System.out.println("Conexión a Internet establecida.");
//                    // Iniciar el monitoreo de la conexión a Internet
//                    i.startMonitoring();
            entrar();
//                } else {
//                    System.out.println("Conexión a Internet perdida.");
//                    sit.setVisible(true);
//                }
//            });
        }
    }//GEN-LAST:event_txtclaveKeyReleased

    private void txtclaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclaveKeyTyped
        char c = evt.getKeyChar();
        lblerrorclave.setText("");
        // Permitir minúsculas, números y ciertos caracteres especiales
        if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || isSpecialCharacter(c))) {
            evt.consume(); // Consumir el evento para evitar que se ingrese el carácter
        }
        verificar();
    }//GEN-LAST:event_txtclaveKeyTyped

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = this.getLocation().x + evt.getX() - initialClick.x;
        int y = this.getLocation().y + evt.getY() - initialClick.y;
        this.setLocation(x, y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void lbl_XMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_XMouseEntered
        lbl_X.setForeground(Color.BLACK);
        // Configurar el Timer para que muestre el mensaje después de 2 segundos
        timer = new Timer(2000, (ActionEvent e) -> {
            if (lbl_X.isShowing()) {
                Point location = lbl_X.getLocationOnScreen();
                tooltipWindow.setLocation(location.x, location.y + lbl_X.getHeight());
                tooltipWindow.setVisible(true);
            }
            timer.stop(); // Detener el timer después de mostrar el mensaje
        });
        timer.setRepeats(false); // Para que el Timer se ejecute solo una vez
        timer.start();
    }//GEN-LAST:event_lbl_XMouseEntered

    private void lbl_XMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_XMouseExited
        lbl_X.setForeground(Color.WHITE);
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Detener el timer si el ratón sale del label antes de los 2 segundos
        }
        tooltipWindow.setVisible(false); // Ocultar el tooltip si el ratón sale
    }//GEN-LAST:event_lbl_XMouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        lbl_msg.setText("Programado por: Alan Cueva Tello");
        lbl_msg.setForeground(java.awt.Color.WHITE);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        lbl_msg.setText("");
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseDragged
        int x = this.getLocation().x + evt.getX() - initialClick.x;
        int y = this.getLocation().y + evt.getY() - initialClick.y;
        this.setLocation(x, y);
    }//GEN-LAST:event_jLabel8MouseDragged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btninicio;
    private com.icm.components.metro.CheckBoxMetroICM chkm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_X;
    private javax.swing.JLabel lbl_msg;
    private javax.swing.JLabel lblcarga;
    private javax.swing.JLabel lblclave;
    private javax.swing.JLabel lblerrorclave;
    private javax.swing.JLabel lblerrordni;
    private javax.swing.JLabel lblmsg;
    private Controladores.PanelRound panelRound2;
    private javax.swing.JPasswordField txtclave;
    private app.bolivia.swing.JCTextField txtdni;
    // End of variables declaration//GEN-END:variables

}
