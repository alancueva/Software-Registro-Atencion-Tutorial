package Vistas.Administracion;

import Controladores.Ciclo;
import Controladores.ControladorDocentes;
import Controladores.ControladorRolUsuario;
import Controladores.ProgramaDeEstudio;
import Controladores.Turno;
import Controladores.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Docentes extends javax.swing.JPanel {

    private final DefaultTableModel tdatos1 = new DefaultTableModel();
    private final DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo6 = new DefaultComboBoxModel();
    private final ControladorDocentes cdoc = new ControladorDocentes();
    private final ControladorRolUsuario cru = new ControladorRolUsuario();
    private final Ciclo ci = new Ciclo();
    private final Turno tur = new Turno();
    private final ProgramaDeEstudio pro = new ProgramaDeEstudio();
    private final Usuario u = new Usuario();
    private String codigo_usu;

    public Docentes() {
        initComponents();

        /*Combo estado*/
        cbo_estado.setModel(combo1);
//        cbo_estado.addItem("Seleccionar");
        cbo_estado.addItem("activo");
        cbo_estado.addItem("inactivo");
        cbo_estado.setEditable(false);
        cbo_estado.setEnabled(false);
        cbo_vigencia.setModel(combo6);

//        cbo_vigencia.addItem("Seleccionar");
        cbo_vigencia.addItem("SI");
        cbo_vigencia.addItem("NO");
        cbo_vigencia.setEditable(false);
        cbo_vigencia.setEnabled(false);

        cbo_rol.setModel(combo2);
        cru.Rol(combo2);

        cbo_programa.setModel(combo3);
        pro.programa(combo3);
        cbo_turno.setModel(combo4);

        cbo_semestre.setModel(combo5);
        ci.ciclo(combo5);

        String Titulos[] = {"codigo", "DNI", "nombre", "Apellido", "Correo", "Clave", "Estado", "Vigencia", "Programa", "Rol"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbl_datos.setModel(tdatos1);
        tbl_datos.setDefaultEditor(Object.class, null);
        tbl_datos.getTableHeader().setReorderingAllowed(false);
        tbl_datos.setRowSelectionAllowed(true);
        tbl_datos.setColumnSelectionAllowed(false);

        // Cambiar color de la fila seleccionada
        tbl_datos.setSelectionBackground(Color.BLUE);
        ListSelectionModel selectionModel = tbl_datos.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbl_datos.getSelectedRow();
                tbl_datos.setSelectionBackground(Color.BLUE);
            }
        });

        btn_modificar.setEnabled(false);
        btn_modificar.setText("");

    }

    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void llenar_Docente(Modelo.Docentes doc) {
        String codigoStr = codigo_usu; // Asignar a una variable auxiliar para evitar el error
        int codigo = 0; // Valor predeterminado si la cadena está vacía o es nula

        if (codigoStr != null && !codigoStr.isEmpty()) {
            // Si la cadena no es nula ni está vacía, intenta convertirla a entero
            codigo = Integer.parseInt(codigoStr);
        }

        // Resto del método llenar_Docente...
        doc.setIdusuario(codigo);
//        int codigo = Integer.parseInt(codigo_usu);
        doc.setIdusuario(codigo);
        doc.setDni(txt_dni.getText());
        doc.setNombre(txt_nom.getText());
        doc.setApellido(txt_ape.getText());
        doc.setCorreo(txt_correo.getText());
        String c = new String(txt_clave.getPassword());
        doc.setClave(c);
        String estado = (String) cbo_estado.getSelectedItem();
        doc.setEstado(estado);
        String vigencia = (String) cbo_vigencia.getSelectedItem();
        doc.setVigencia(vigencia);
        String programa = (String) cbo_programa.getSelectedItem();
        doc.setPrograma(pro.capturacod(programa));
        String rol = (String) cbo_rol.getSelectedItem();
        doc.setRol(cru.capturacod(rol));
    }

    private void limpiar() {
        txt_dni.setText("");
        txt_nom.setText("");
        txt_ape.setText("");
        txt_correo.setText("");
        txt_clave.setText("");
        cbo_programa.setSelectedItem("Seleccionar");
        limpiartabla1();
        cbo_vigencia.setSelectedItem("SI");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbo_turno = new com.icm.components.metro.ComboboxMetroICM();
        cbo_semestre = new com.icm.components.metro.ComboboxMetroICM();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbo_estado = new com.icm.components.metro.ComboboxMetroICM();
        cbo_rol = new com.icm.components.metro.ComboboxMetroICM();
        cbo_vigencia = new com.icm.components.metro.ComboboxMetroICM();
        cbo_programa = new com.icm.components.metro.ComboboxMetroICM();
        txt_clave = new com.icm.components.metro.PasswordFieldMetroICM();
        btn_buscar = new rojeru_san.complementos.RSButtonHover();
        btn_nuevo = new rojeru_san.complementos.RSButtonHover();
        btn_modificar = new rojeru_san.complementos.RSButtonHover();
        btn_grabar = new rojeru_san.complementos.RSButtonHover();
        txt_busqueda = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new rojeru_san.complementos.RSTableMetro();
        clave_generica = new com.icm.components.metro.switchButtonMetroICM();
        txt_ape = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        lblmsg = new javax.swing.JLabel();

        cbo_turno.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbo_turnoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbo_semestre.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbo_semestrePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel10.setText("Semestre");

        jLabel9.setText("Turno");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbo_estado.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        add(cbo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 190, -1));
        add(cbo_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 190, -1));

        cbo_vigencia.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cbo_vigencia.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbo_vigenciaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(cbo_vigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, -1, -1));

        cbo_programa.setMaximumRowCount(9);
        cbo_programa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbo_programaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(cbo_programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 390, -1));
        add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 270, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 60, -1));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 140, -1));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        btn_grabar.setText("Grabar");
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });
        add(btn_grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, -1, -1));
        add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 200, 40));

        jLabel1.setText("DNI");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel3.setText("Apellidos");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        jLabel4.setText("Correo");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, -1, -1));

        jLabel5.setText("Clave");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setText("Estado");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel7.setText("Rol");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        jLabel8.setText("Programa de Estudio");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel11.setText("Busqueda Docente");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Docentes");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, 150, 20));

        jLabel13.setText("Vigencia");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, -1, -1));

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_datos.setMultipleSeleccion(false);
        tbl_datos.getTableHeader().setReorderingAllowed(false);
        tbl_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_datos);
        tbl_datos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 1160, 450));

        clave_generica.setText("Clave Generica");
        clave_generica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clave_genericaActionPerformed(evt);
            }
        });
        add(clave_generica, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        txt_ape.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_ape.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_ape.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 270, 40));

        txt_correo.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_correo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_correo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 270, 40));

        txt_nom.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_nom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_nom.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 270, 40));

        txt_dni.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_dni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_dni.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });
        add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 270, 40));

        lblmsg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 220, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        String nom = txt_nom.getText();
        String n = txt_ape.getText();
        String d = txt_dni.getText();
        String c = new String(txt_clave.getPassword());
        String prog = (String) cbo_programa.getSelectedItem();
        String rol = (String) cbo_rol.getSelectedItem();

        if (nom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Su Nombre", "Atencion", JOptionPane.ERROR_MESSAGE);
            txt_ape.requestFocus();
            return;
        }
        if (n.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Su apellido", "Atencion", JOptionPane.ERROR_MESSAGE);
            txt_ape.requestFocus();
            return;
        }
        if (d.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Su Dni", "Atencion", JOptionPane.ERROR_MESSAGE);
            txt_dni.requestFocus();
            return;
        }
        if (c.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Una Contraseña", "Atencion", JOptionPane.ERROR_MESSAGE);
            txt_clave.requestFocus();
            return;
        }
        if (prog.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione el programa de Estudio", "Atencion", JOptionPane.ERROR_MESSAGE);
//            txtclave.requestFocus();
            return;
        }
        if (rol.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione el Rol", "Atención", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Guardar", "Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_grabar.setEnabled(false);
                    btn_grabar.setText("Cargando...");
                });
                boolean existe = u.verificar_dni(d);
                if (!existe) {
                    Modelo.Docentes doc = new Modelo.Docentes();
                    llenar_Docente(doc);
                    boolean g = cdoc.guardar_Usuario(doc);
                    if (g) {
                        limpiar();
                        limpiartabla1();
                        btn_grabar.setEnabled(true);
                        btn_grabar.setText("Grabar");
                        btn_modificar.setEnabled(false);
                        btn_modificar.setText("");
                        cbo_estado.setEnabled(false);
                        cbo_vigencia.setEnabled(false);
                        cdoc.mostrarUsuario(tdatos1);
                        clave_generica.setSelected(false);
                        JOptionPane.showMessageDialog(null, "Grabado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        btn_grabar.setEnabled(true);
                        btn_grabar.setText("Grabar");
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al grabar.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    btn_grabar.setEnabled(true);
                    btn_grabar.setText("Grabar");
                    JOptionPane.showMessageDialog(null, "El Docente Ya esta Registrado.", "Existe", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            // Iniciar el hilo
            cargaDatosThread.start();
        }

    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String bus = txt_busqueda.getText();
        if (bus.trim().isEmpty()) {
            limpiartabla1();
            cdoc.mostrarUsuario(tdatos1);
        } else {
            limpiartabla1();
            cdoc.BucarUsuario(tdatos1, bus);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        limpiar();
        btn_grabar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_modificar.setText("");
        cbo_estado.setEnabled(false);
        cbo_vigencia.setEnabled(false);
        clave_generica.setSelected(false);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void cbo_programaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbo_programaPopupMenuWillBecomeInvisible
//        String programa =  (String) cbo_programa.getSelectedItem();
//        tur.Turno_nom(combo4, programa);
    }//GEN-LAST:event_cbo_programaPopupMenuWillBecomeInvisible

    private void cbo_turnoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbo_turnoPopupMenuWillBecomeInvisible
        String programa = (String) cbo_programa.getSelectedItem();
        if (programa.equals("Seleccinar")) {

        } else {
            tur.Turno_nom(combo4, programa);
        }
    }//GEN-LAST:event_cbo_turnoPopupMenuWillBecomeInvisible

    private void cbo_semestrePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbo_semestrePopupMenuWillBecomeInvisible
        String turno = (String) cbo_turno.getSelectedItem();
        if (turno.equals("Seleccinar")) {

        } else {
            ci.ciclo(combo5);
        }
    }//GEN-LAST:event_cbo_semestrePopupMenuWillBecomeInvisible

    private void cbo_vigenciaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbo_vigenciaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_vigenciaPopupMenuWillBecomeInvisible

    private void tbl_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_datosMouseClicked
        int pos = tbl_datos.getSelectedRow();
        codigo_usu = (String) tbl_datos.getValueAt(pos, 0);
        txt_dni.setText((String) tbl_datos.getValueAt(pos, 1));
        txt_nom.setText((String) tbl_datos.getValueAt(pos, 2));
        txt_ape.setText((String) tbl_datos.getValueAt(pos, 3));
        txt_correo.setText((String) tbl_datos.getValueAt(pos, 4));
        txt_clave.setText((String) tbl_datos.getValueAt(pos, 5));
        cbo_estado.setSelectedItem((String) tbl_datos.getValueAt(pos, 6));
        cbo_vigencia.setSelectedItem((String) tbl_datos.getValueAt(pos, 7));
        cbo_programa.setSelectedItem((String) tbl_datos.getValueAt(pos, 8));
        cbo_rol.setSelectedItem((String) tbl_datos.getValueAt(pos, 9));

        btn_modificar.setEnabled(true);
        btn_modificar.setText("Modificar");
        btn_grabar.setEnabled(false);
        cbo_vigencia.setEnabled(true);
        cbo_estado.setEnabled(true);
    }//GEN-LAST:event_tbl_datosMouseClicked

    private void clave_genericaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clave_genericaActionPerformed
        if (clave_generica.isSelected()) {
            txt_clave.setText("123456");
        } else {
            txt_clave.setText("");
        }
    }//GEN-LAST:event_clave_genericaActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Modificar", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_modificar.setEnabled(false);
                    btn_modificar.setText("Cargando...");
                });
                Modelo.Docentes doc = new Modelo.Docentes();
                llenar_Docente(doc);
                boolean g = cdoc.Modificar_Usuario(doc);
                if (g) {
                    limpiar();
                    limpiartabla1();
                    cdoc.mostrarUsuario(tdatos1);
                    btn_modificar.setEnabled(true);
                    btn_modificar.setText("Modificar");
                    JOptionPane.showMessageDialog(null, "Modificado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    btn_modificar.setEnabled(true);
                    btn_modificar.setText("Modificar");
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al Modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            // Iniciar el hilo
            cargaDatosThread.start();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || txt_dni.getText().length() >= 8) {
            evt.consume(); // Consume el evento si no es un dígito o si la longitud es mayor a 8
        }
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
//            lblerrordni.setText("");
        }
        txt_dni.setFocusable(true);
    }//GEN-LAST:event_txt_dniKeyTyped

    private void txt_dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyPressed
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
//            lblerrordni.setText("");
        }
        txt_dni.setFocusable(true);
    }//GEN-LAST:event_txt_dniKeyPressed

    private void txt_dniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyReleased
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            lblmsg.setText("Solo Se permite Numeros");
            lblmsg.setVisible(true);
        } else {
            lblmsg.setVisible(false);
//            lblerrordni.setText("");
        }
    }//GEN-LAST:event_txt_dniKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_buscar;
    private rojeru_san.complementos.RSButtonHover btn_grabar;
    private rojeru_san.complementos.RSButtonHover btn_modificar;
    private rojeru_san.complementos.RSButtonHover btn_nuevo;
    private com.icm.components.metro.ComboboxMetroICM cbo_estado;
    private com.icm.components.metro.ComboboxMetroICM cbo_programa;
    private com.icm.components.metro.ComboboxMetroICM cbo_rol;
    private com.icm.components.metro.ComboboxMetroICM cbo_semestre;
    private com.icm.components.metro.ComboboxMetroICM cbo_turno;
    private com.icm.components.metro.ComboboxMetroICM cbo_vigencia;
    private com.icm.components.metro.switchButtonMetroICM clave_generica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblmsg;
    private rojeru_san.complementos.RSTableMetro tbl_datos;
    private javax.swing.JTextField txt_ape;
    private app.bolivia.swing.JCTextField txt_busqueda;
    private com.icm.components.metro.PasswordFieldMetroICM txt_clave;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nom;
    // End of variables declaration//GEN-END:variables
}
