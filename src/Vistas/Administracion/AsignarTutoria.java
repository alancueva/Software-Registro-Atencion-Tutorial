package Vistas.Administracion;

import Controladores.Ciclo;
import Controladores.ControladorDocente_Detalle;
import Controladores.Turno;
import java.awt.HeadlessException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

public class AsignarTutoria extends javax.swing.JPanel {

    private final DefaultTableModel tdatos1 = new DefaultTableModel();
    private final DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
    private final DefaultComboBoxModel vigencia = new DefaultComboBoxModel();

    Ciclo ci;
    Turno tur;

    public AsignarTutoria() {
        initComponents();
        ci = new Ciclo();
        tur = new Turno();

        cbo_turno.setModel(combo4);
        cbo_turno.setSelectedItem("Seleccionar");
        cbo_semestre.setModel(combo5);
        ci.ciclo(combo5);
        cbovigencia.setModel(vigencia);
        cbovigencia.addItem("SI");
        cbovigencia.addItem("NO");
        cbovigencia.setEnabled(false);
        cbovigencia.setEnabled(false);
        String Titulos[] = {"Codigo", "Nombre", "Apellido", "Programa", "Turno", "Ciclo", "Vigencia"};
        tdatos1.setColumnIdentifiers(Titulos);
        tbl_datos.setModel(tdatos1);
        tbl_datos.setDefaultEditor(Object.class, null);
        tbl_datos.getTableHeader().setReorderingAllowed(false);
        tbl_datos.setRowSelectionAllowed(true);
        tbl_datos.setColumnSelectionAllowed(false);

        String programa = txt_programa.getText();
        if (programa.isEmpty()) {
            cbo_turno.setEnabled(false);
            cbo_turno.setEditable(false);
            cbo_turno.setSelectedItem("Seleccionar");
        } else {
            cbo_turno.setSelectedItem("Seleccionar");
            cbo_turno.setEnabled(true);
            cbo_turno.removeAllItems();
            cbo_turno.setFocusable(true);
            tur.capturacod(programa);
        }
        txt_codigo.setEditable(false);
        txt_nom.setEditable(false);
        txt_programa.setEditable(false);
        btn_modificar.setEnabled(false);
        btn_modificar.setText("");

    }

    /**
     *
     * @param codigo
     * @param nom
     * @param programa
     */
    public void setValores(String codigo, String nom, String programa) {

//        SwingUtilities.invokeLater(() -> {
//            System.out.println("jpanelform: " + codigo + " " + nom + " " + programa);
        txt_nom.setText(nom);
        txt_codigo.setText(codigo);
        txt_programa.setText(programa);

        String progra = txt_programa.getText();
        cbo_turno.removeAllItems();
        tur.Turno_nom(combo4, progra);
        cbo_turno.setEnabled(true);
//        });
//        revalidate();
//        repaint();
    }

    private void limpiartabla1() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void limpiar() {
        txt_nom.setText("");
        txt_codigo.setText("");
        txt_programa.setText("");
        txt_busqueda.setText("");
        cbovigencia.setSelectedItem("SI");
        cbo_semestre.setSelectedItem("Seleccionar");

        cbo_turno.setEnabled(false);
        cbo_turno.setEditable(false);
        cbo_turno.setSelectedItem("Seleccionar");
        limpiartabla1();
    }

    private boolean camposVacios() {
        return txt_nom.getText().isEmpty()
                && txt_codigo.getText().isEmpty()
                && txt_programa.getText().isEmpty()
                && cbo_semestre.getSelectedIndex() == -1
                && cbo_turno.getSelectedIndex() == -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbo_semestre = new com.icm.components.metro.ComboboxMetroICM();
        jLabel9 = new javax.swing.JLabel();
        cbo_turno = new com.icm.components.metro.ComboboxMetroICM();
        jLabel10 = new javax.swing.JLabel();
        btn_buscar = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar1 = new rojeru_san.complementos.RSButtonHover();
        txt_busqueda = new app.bolivia.swing.JCTextField();
        btn_grabar = new rojeru_san.complementos.RSButtonHover();
        btn_modificar = new rojeru_san.complementos.RSButtonHover();
        btn_nuevo = new rojeru_san.complementos.RSButtonHover();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        txt_programa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbovigencia = new com.icm.components.metro.ComboboxMetroICM();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(cbo_semestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, -1, 40));

        jLabel9.setText("Turno");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        cbo_turno.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbo_turnoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(cbo_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, 40));

        jLabel10.setText("Semestre");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, -1, -1));

        btn_buscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 60, 40));

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 1230, 410));

        jLabel1.setText("Nombre");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jLabel2.setText("Codigo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        btn_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-búsqueda-30.png"))); // NOI18N
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });
        add(btn_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 60, 40));
        add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 40));

        btn_grabar.setText("Grabar");
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });
        add(btn_grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, -1, -1));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 140, -1));

        jLabel3.setText("Asignar tutoria a cada docente");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 270, 50));

        jLabel4.setText("Programa de Estudio");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 660, 50));

        txt_nom.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_nom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_nom.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 270, 40));

        txt_codigo.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_codigo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 50, 40));

        txt_programa.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_programa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_programa.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        add(txt_programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 270, 40));

        jLabel6.setText("Buscar Docentes Tutores");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel7.setText("Mostrar");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));
        add(cbovigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 150, 90, 40));

        jLabel8.setText("Vigencia");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_turnoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbo_turnoPopupMenuWillBecomeInvisible
        String turno = (String) cbo_turno.getSelectedItem();
        if (turno.equals("Seleccinar") || turno.isEmpty()) {
            cbo_semestre.setEnabled(false);
        } else {
            cbo_semestre.removeAllItems();
            ci.ciclo(combo5);
        }
    }//GEN-LAST:event_cbo_turnoPopupMenuWillBecomeInvisible

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        BuscarDocente bd = new BuscarDocente(null, true);
        bd.setVisible(true);

        String codigo = bd.getCodigo();
        String nombre = bd.getNombre();
        String programa = bd.getPrograma();
        setValores(codigo, nombre, programa);
        cbo_semestre.setSelectedItem("Seleccionar");
        cbo_turno.setSelectedItem("Seleccionar");
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tbl_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_datosMouseClicked
        int pos = tbl_datos.getSelectedRow();
        txt_codigo.setText((String) tbl_datos.getValueAt(pos, 0));
        txt_nom.setText((String) tbl_datos.getValueAt(pos, 1) + " " + tbl_datos.getValueAt(pos, 2));
        txt_programa.setText((String) tbl_datos.getValueAt(pos, 3));
        cbo_turno.setSelectedItem((String) tbl_datos.getValueAt(pos, 4));
//        tur.capturacod((String) tbl_datos.getValueAt(pos, 4));
        cbo_turno.setEnabled(true);
//        cbo_turno.removeAllItems();
        tur.Turno_nom(combo4, (String) tbl_datos.getValueAt(pos, 3));
        cbo_semestre.setSelectedItem((String) tbl_datos.getValueAt(pos, 5));
        cbovigencia.setSelectedItem((String) tbl_datos.getValueAt(pos, 6));
        cbovigencia.setEnabled(true);
        cbovigencia.setEnabled(true);
        btn_modificar.setEnabled(true);
        btn_modificar.setText("Modificar");
        btn_grabar.setEnabled(false);
    }//GEN-LAST:event_tbl_datosMouseClicked

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        ControladorDocente_Detalle cdd = new ControladorDocente_Detalle();
        String bus = txt_busqueda.getText();
        if (bus.trim().isEmpty()) {
            limpiartabla1();
            cdd.mostrarUsuario_Detalle(tdatos1);
        } else {
            limpiartabla1();
            cdd.BucarUsuario_Detalle(tdatos1, bus);
        }
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        ControladorDocente_Detalle cdd = new ControladorDocente_Detalle();
        ci = new Ciclo();
        tur = new Turno();
        String cod = txt_codigo.getText();
        String nom = txt_nom.getText();
        String programa = txt_programa.getText();
        String turno = (String) cbo_turno.getSelectedItem();
        String ciclo = (String) cbo_semestre.getSelectedItem();

        if (cod.isEmpty() || nom.isEmpty() || programa.isEmpty() || turno.isEmpty() || ciclo.isEmpty()) {
            JOptionPane.showMessageDialog(this.getParent(), "Por favor, completa todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int guardar = JOptionPane.showConfirmDialog(this.getParent(), "Deseas Grabar", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            try {
                Thread cargaDatosThread = new Thread(() -> {
                    SwingUtilities.invokeLater(() -> {
                        btn_grabar.setEnabled(false);
                        btn_grabar.setText("Cargando...");
                    });
                    int idusu = Integer.parseInt(cod);

                    boolean existe = cdd.UsuarioDetalle_existe(idusu);
                    if (!existe) {
                        Modelo.Docentes_Detalle doc = new Modelo.Docentes_Detalle();
                        doc.setIdusuario(idusu);
                        doc.setIdturno(tur.capturacod(turno));
                        doc.setIdciclo(ci.capturacod(ciclo));
                        boolean exito = cdd.guardar_Usuario_Detalle(doc);
                        if (exito) {
                            limpiartabla1();
                            cdd.mostrarUsuario_Detalle(tdatos1);
                            btn_grabar.setEnabled(true);
                            btn_grabar.setText("Grabar");
                            JOptionPane.showMessageDialog(null, "Detalle grabado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            btn_grabar.setEnabled(true);
                            btn_grabar.setText("Grabar");
                            JOptionPane.showMessageDialog(null, "Hubo un error al grabar el detalle.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        btn_grabar.setEnabled(true);
                        btn_grabar.setText("Grabar");
                        JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado.", "Usuario Existe", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                cargaDatosThread.start();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código de usuario debe ser un número.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        if (!camposVacios()) {
            limpiar();
            cbovigencia.setEnabled(false);
            cbovigencia.setEnabled(false);
            btn_modificar.setEnabled(false);
            btn_modificar.setText("");
            btn_grabar.setEnabled(true);
            limpiartabla1();
        } else {
            JOptionPane.showMessageDialog(this.getParent(), "Los campos ya están limpios.", "Campos Limpios", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        ControladorDocente_Detalle cdd = new ControladorDocente_Detalle();
        String cod = txt_codigo.getText();
        String nom = txt_nom.getText();
        String programa = txt_programa.getText();
        String turno = (String) cbo_turno.getSelectedItem();
        String ciclo = (String) cbo_semestre.getSelectedItem();
        String vige = (String) cbovigencia.getSelectedItem();

        // Verificar si algún campo está vacío
        if (cod.isEmpty() || nom.isEmpty() || programa.isEmpty() || turno.isEmpty() || ciclo.isEmpty()) {
            JOptionPane.showMessageDialog(this.getParent(), "Por favor, completa todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return; // Retorna si hay campos vacíos
        }
        if (turno.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this.getParent(), "Por favor, Seleccione bien la fila. No hay turno", "Turno vacio", JOptionPane.WARNING_MESSAGE);
            return; // Retorna si hay campos vacíos
        }
        if (ciclo.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this.getParent(), "Por favor, Seleccione bien la fila.", "Ciclo vacio", JOptionPane.WARNING_MESSAGE);
            return; // Retorna si hay campos vacíos
        }

        int guardar = JOptionPane.showConfirmDialog(this.getParent(), "Deseas Modificar", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_modificar.setEnabled(false);
                    btn_modificar.setText("Cargando...");
                });
                Modelo.Docentes_Detalle doc = new Modelo.Docentes_Detalle();

                int idusu = Integer.parseInt(cod);
                doc.setIdusuario(idusu);

                doc.setIdturno(tur.capturacod(turno));
                doc.setIdciclo(ci.capturacod(ciclo));
                doc.setVigencia(vige);
                boolean g = cdd.Modificar_Usuario_Detalle(doc);
                if (g) {
                    limpiartabla1();
                    cdd.mostrarUsuario_Detalle(tdatos1);
                    btn_modificar.setEnabled(true);
                    btn_modificar.setText("Modificar");
                    JOptionPane.showMessageDialog(this.getParent(), "Detalle Modificado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    btn_modificar.setEnabled(true);
                    btn_modificar.setText("Modificar");
                    JOptionPane.showMessageDialog(this.getParent(), "Ocurrió un error al modificar el detalle.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            cargaDatosThread.start();
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_buscar;
    private rojeru_san.complementos.RSButtonHover btn_buscar1;
    private rojeru_san.complementos.RSButtonHover btn_grabar;
    private rojeru_san.complementos.RSButtonHover btn_modificar;
    private rojeru_san.complementos.RSButtonHover btn_nuevo;
    private com.icm.components.metro.ComboboxMetroICM cbo_semestre;
    private com.icm.components.metro.ComboboxMetroICM cbo_turno;
    private com.icm.components.metro.ComboboxMetroICM cbovigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro tbl_datos;
    private app.bolivia.swing.JCTextField txt_busqueda;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_programa;
    // End of variables declaration//GEN-END:variables
}
