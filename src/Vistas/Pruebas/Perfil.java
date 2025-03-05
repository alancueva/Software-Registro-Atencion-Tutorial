package Vistas.Pruebas;

import Controladores.Usuario;
import Modelo.inicio_sesion;
import Vistas.Administracion.Administrador;
import Vistas.Incio_sesion.InicioSesion;
import javax.swing.JOptionPane;

public class Perfil extends javax.swing.JPanel {

    Usuario re = new Usuario();
    private boolean camposEditables = false;

    public Perfil() {
        initComponents();
        mostrar();
        txtdni.setEditable(false);
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txtcorreo.setEditable(false);
        Cambios_Perfil.setVisible(false);
        
        //Cambiar contraseña
        jLabel16.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        txtcontraantigua.setVisible(false);
        txtcontranueva.setVisible(false);
        chkmostrar1.setVisible(false);
        chlmostrar2.setVisible(false);
        btncambio.setVisible(false);
        lblmensaje2.setVisible(false);
        lblmensaje1.setVisible(false);
    }

    private void mostrar() {
        txtnombre.setText(inicio_sesion.nombre);
        txtapellido.setText(inicio_sesion.apellido);
        txtdni.setText(inicio_sesion.dni);
        txtcorreo.setText(inicio_sesion.correo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        chkmostrar1 = new javax.swing.JCheckBox();
        chlmostrar2 = new javax.swing.JCheckBox();
        btncambio = new javax.swing.JButton();
        lblmensaje1 = new javax.swing.JLabel();
        txtcontraantigua = new javax.swing.JPasswordField();
        txtcontranueva = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        lblmensaje2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblmensaje3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Editar_Usuario = new com.icm.components.metro.LinkMetroICM();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        Cambios_Perfil = new javax.swing.JButton();
        cambiar_clave = new com.icm.components.metro.LinkMetroICM();
        jSeparator4 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 600, 10));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setText(" Perfil");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Contraseña:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 100, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Contraseña Antigua");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Contraseña Nueva");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        chkmostrar1.setText("Mostrar Contraseña");
        chkmostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkmostrar1ActionPerformed(evt);
            }
        });
        add(chkmostrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        chlmostrar2.setText("Mostrar Contraseña");
        chlmostrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chlmostrar2ActionPerformed(evt);
            }
        });
        add(chlmostrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, -1));

        btncambio.setText("Cambiar contraseña");
        btncambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambioActionPerformed(evt);
            }
        });
        add(btncambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 220, 30));
        add(lblmensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 220, 20));
        add(txtcontraantigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 220, 30));
        add(txtcontranueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 220, 30));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1370, 10));
        add(lblmensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 220, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("DNI:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));
        add(lblmensaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 220, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Nombre:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Apellido:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Datos de Usuario");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 30));

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Nuestra misión es proporcionar una Tutoria gratuita de clase mundial para cualquier persona en cualquier lugar");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 1280, 30));
        add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 220, 30));
        add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 230, 30));
        add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 220, 30));
        add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 230, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Correo:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        Editar_Usuario.setText("Editar");
        Editar_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Editar_UsuarioMouseClicked(evt);
            }
        });
        add(Editar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 30));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1370, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 600, 10));

        Cambios_Perfil.setText("Confirmar Cambios");
        Cambios_Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambios_PerfilActionPerformed(evt);
            }
        });
        add(Cambios_Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 330, 160, -1));

        cambiar_clave.setText("Cambiar clave");
        cambiar_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiar_claveMouseClicked(evt);
            }
        });
        add(cambiar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void chkmostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkmostrar1ActionPerformed
        if (chkmostrar1.isSelected()) {
            txtcontraantigua.setEchoChar((char) 0); // Mostrar caracteres
        } else {
            txtcontraantigua.setEchoChar('*'); // Ocultar caracteres
        }
        String c = new String(txtcontraantigua.getPassword());
        if (c.isEmpty()) {
            txtcontraantigua.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chkmostrar1ActionPerformed

    private void chlmostrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chlmostrar2ActionPerformed
        if (chlmostrar2.isSelected()) {
            txtcontranueva.setEchoChar((char) 0); // Mostrar caracteres
        } else {
            txtcontranueva.setEchoChar('*'); // Ocultar caracteres
        }
        String c = new String(txtcontraantigua.getPassword());
        if (c.isEmpty()) {
            txtcontranueva.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_chlmostrar2ActionPerformed

    private void btncambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambioActionPerformed
        String dni = txtdni.getText();
        String clave1 = new String(txtcontraantigua.getPassword());
        String clave2 = new String(txtcontranueva.getPassword());
        if (dni.length() != 8) {
            lblmensaje3.setText("El DNI debe tener 8 dígitos");
            lblmensaje3.setForeground(java.awt.Color.BLACK);
        }
        if (clave1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese su antigua Clave", "Atencion", JOptionPane.ERROR_MESSAGE);
            txtcontraantigua.requestFocus();
            return;
        }
        if (clave2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese La Nueva Clave", "Atencion", JOptionPane.ERROR_MESSAGE);
            txtcontranueva.requestFocus();
            return;
        }
        if (clave1.length() > 6) {
            lblmensaje1.setText("La clave parece buena, Trate de NO OLVIDARSE!");
            lblmensaje1.setForeground(java.awt.Color.BLACK);
        }
        if (clave2.length() > 8) {
            lblmensaje2.setText("La clave parece buena, Trate de NO OLVIDARSE!");
            lblmensaje2.setForeground(java.awt.Color.BLACK);
        }
        if (re.verificarContraseñaAntigua(dni, clave1)) {
            boolean cambioExitoso = re.cambiarContraseñaDocente(dni, clave2);
            if (cambioExitoso) {
                int opcion = JOptionPane.showConfirmDialog(this, "Contraseña cambiada exitosamente.\n¿Deseas mantener la sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.NO_OPTION) {
                    Administrador a = new Administrador();
                    InicioSesion ventanaInicioSesion = new InicioSesion();
                    ventanaInicioSesion.setVisible(true);
                    a.dispose();
                } else {
//                    txtdni.setText("");
                    txtcontraantigua.setText("");
                    txtcontranueva.setText("");
                    chkmostrar1.setSelected(false);
                    chlmostrar2.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña. Inténtalo de nuevo.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña antigua incorrecta. Inténtalo de nuevo.");
        }
    }//GEN-LAST:event_btncambioActionPerformed

    private void Editar_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Editar_UsuarioMouseClicked
        if (!camposEditables) {
            // Hacer los campos editables
            txtdni.setEditable(false);
            txtnombre.setEditable(true);
            txtapellido.setEditable(true);
            txtcorreo.setEditable(true);
            Cambios_Perfil.setVisible(true);
            camposEditables = true; // Establecer el estado de edición como verdadero
        } else {
            // Hacer los campos no editables
            txtdni.setEditable(false);
            txtnombre.setEditable(false);
            txtapellido.setEditable(false);
            txtcorreo.setEditable(false);
            Cambios_Perfil.setVisible(false);
            camposEditables = false; // Establecer el estado de edición como falso
        }
    }//GEN-LAST:event_Editar_UsuarioMouseClicked

    private void Cambios_PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cambios_PerfilActionPerformed
        String nom = txtnombre.getText();
        String ape = txtapellido.getText();
        String dni = txtdni.getText();
        String correo = txtcorreo.getText();
        if (nom.isEmpty() || ape.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos por favor.", "Faltan llenar Campos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validación de formato de correo electrónico
        if (!correo.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un correo electrónico válido.", "Formato de Correo Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Modificar?", "Modificar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            boolean cambioExitoso = re.actualizar_usuario(nom, ape, dni, correo);
            if (cambioExitoso) {
                JOptionPane.showConfirmDialog(this, "Datos Modificados Exitosamente.", "Datos Modificados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al cambiar la Datos. Inténtalo de nuevo.");
            }
        }
    }//GEN-LAST:event_Cambios_PerfilActionPerformed

    private void cambiar_claveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiar_claveMouseClicked
        if (!camposEditables) {
            jLabel18.setVisible(true);
            jLabel16.setVisible(true);
            txtcontraantigua.setVisible(true);
            txtcontranueva.setVisible(true);
            chkmostrar1.setVisible(true);
            chlmostrar2.setVisible(true);
            btncambio.setVisible(true);
            lblmensaje2.setVisible(true);
            lblmensaje1.setVisible(true);
            jLabel19.setVisible(true);
            camposEditables = true;
        } else {
            jLabel18.setVisible(false);
            jLabel16.setVisible(false);
            txtcontraantigua.setVisible(false);
            txtcontranueva.setVisible(false);
            chkmostrar1.setVisible(false);
            chlmostrar2.setVisible(false);
            btncambio.setVisible(false);
            lblmensaje2.setVisible(false);
            lblmensaje1.setVisible(false);
            jLabel19.setVisible(false);
            camposEditables = false;
        }
    }//GEN-LAST:event_cambiar_claveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cambios_Perfil;
    private com.icm.components.metro.LinkMetroICM Editar_Usuario;
    private javax.swing.JButton btncambio;
    private com.icm.components.metro.LinkMetroICM cambiar_clave;
    private javax.swing.JCheckBox chkmostrar1;
    private javax.swing.JCheckBox chlmostrar2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblmensaje1;
    private javax.swing.JLabel lblmensaje2;
    private javax.swing.JLabel lblmensaje3;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JPasswordField txtcontraantigua;
    private javax.swing.JPasswordField txtcontranueva;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
