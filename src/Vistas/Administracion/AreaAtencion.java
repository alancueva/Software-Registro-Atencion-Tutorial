package Vistas.Administracion;

import Controladores.Area;
import Controladores.Motivo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AreaAtencion extends javax.swing.JPanel {

    private final DefaultComboBoxModel combo = new DefaultComboBoxModel();
    private final DefaultTableModel tdatos = new DefaultTableModel();
    private final Area ar = new Area();
    private final Motivo mo = new Motivo();
    private String codigo;

    public AreaAtencion() {
        initComponents();
        ar.area(combo);
        cboarea.setModel(combo);
//         tbl_motivos.setModel(tdatos);
        txt_motivos.setEnabled(false);
        txt_motivos.setEditable(false);
        btn_guardar.setVisible(false);
        String Titulos[] = {"ID", "Nombre"};
        tdatos.setColumnIdentifiers(Titulos);
        tbl_motivos.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbl_motivos.getColumnModel().getColumn(0).setMaxWidth(10); // Ajusta este valor según tus necesidades
        tbl_motivos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_motivos.getColumnModel().getColumn(1).setMaxWidth(200); // Opcional, para limitar el ancho máximo

        tbl_motivos.getColumnModel().getColumn(0).setMinWidth(5);

        tbl_motivos.setModel(tdatos);
        tbl_motivos.setDefaultEditor(Object.class, null);
        tbl_motivos.getTableHeader().setReorderingAllowed(false);
        tbl_motivos.setRowSelectionAllowed(true);
        tbl_motivos.setColumnSelectionAllowed(false);

        String valor = (String) cboarea.getSelectedItem();
        if (valor.equals("Seleccionar")) {
            txt_motivos.setText("");
            limpiartabla();
        }
    }

    private void limpiartabla() {
        int x = tdatos.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_motivos = new com.icm.components.metro.TableMetroICM();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_motivos = new javax.swing.JTextArea();
        btn_guardar = new rojeru_san.complementos.RSButtonHover();
        btn_modificar = new rojeru_san.complementos.RSButtonHover();
        cboarea = new com.icm.components.metro.ComboboxMetroICM();
        msg = new javax.swing.JLabel();
        linkMetroICM1 = new com.icm.components.metro.LinkMetroICM();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Área");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Motivos");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        tbl_motivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_motivos.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tbl_motivos.setShowHorizontalLines(false);
        tbl_motivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_motivosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_motivos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 980, 490));

        txt_motivos.setColumns(20);
        txt_motivos.setRows(5);
        txt_motivos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txt_motivosMouseDragged(evt);
            }
        });
        txt_motivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_motivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_motivosMouseExited(evt);
            }
        });
        jScrollPane3.setViewportView(txt_motivos);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 670, 130));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 130, -1));

        cboarea.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboareaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        add(cboarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, -1));
        add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 370, 30));

        linkMetroICM1.setText("Agregar Nuevo Motivo");
        linkMetroICM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkMetroICM1MouseClicked(evt);
            }
        });
        add(linkMetroICM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 30, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cboareaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboareaPopupMenuWillBecomeInvisible
        String valor = (String) cboarea.getSelectedItem();
        if (valor.equals("Seleccionar")) {
            txt_motivos.setText("");
            txt_motivos.setEditable(false);
            limpiartabla();
            btn_guardar.setVisible(false);
        } else {
            limpiartabla();
            txt_motivos.setText("");
            mo.mostrarT(tdatos, valor);
            txt_motivos.setEnabled(true);

            btn_modificar.setEnabled(true);
        }

    }//GEN-LAST:event_cboareaPopupMenuWillBecomeInvisible

    private void tbl_motivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_motivosMouseClicked
        int fila = tbl_motivos.getSelectedRow();
        codigo = tdatos.getValueAt(fila, 0).toString();
        System.out.println("id " + codigo);
        txt_motivos.setText(tdatos.getValueAt(fila, 1).toString());
        txt_motivos.setEditable(true);
        txt_motivos.setFocusable(true);
        btn_guardar.setVisible(false);
        btn_modificar.setEnabled(true);
    }//GEN-LAST:event_tbl_motivosMouseClicked

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        String valor = (String) cboarea.getSelectedItem();
        if (valor.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Selecciona área", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String idar = ar.capturacod(valor);
        String motivo = txt_motivos.getText();
        if (motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Motivo para Modificar", "Motivo Vacio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Modificar", "Modificar Motivo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            boolean exito = mo.actualizar(idar, codigo, motivo);
            if (exito) {
                txt_motivos.setText("");
                limpiartabla();
                mo.mostrarT(tdatos, valor);
                JOptionPane.showMessageDialog(null, "Actualizado con Exito!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                txt_motivos.setEditable(false);
                txt_motivos.setFocusable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al Actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String valor = (String) cboarea.getSelectedItem();
        if (valor.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Selecciona área", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String idar = ar.capturacod(valor);
        String motivo = txt_motivos.getText();
        if (motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Motivo para Guardar", "Motivo Vacio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int guardar = JOptionPane.showConfirmDialog(null, "Deseas Guardar", "Guardar Motivo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            boolean exito = mo.guardar(idar,motivo);
            if (exito) {
                txt_motivos.setText("");
                limpiartabla();
                mo.mostrarT(tdatos, valor);
                JOptionPane.showMessageDialog(null, "Guardado con Exito!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                txt_motivos.setEditable(false);
                txt_motivos.setFocusable(false);
                btn_guardar.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al Guardar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_motivosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_motivosMouseDragged

    }//GEN-LAST:event_txt_motivosMouseDragged

    private void txt_motivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_motivosMouseEntered
        String valor = (String) cboarea.getSelectedItem();
        if (valor.equals("Seleccionar")) {
            msg.setText("Seleccione un Área");
        } else {
            msg.setText("");
        }

    }//GEN-LAST:event_txt_motivosMouseEntered

    private void txt_motivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_motivosMouseExited
        msg.setText("");
    }//GEN-LAST:event_txt_motivosMouseExited

    private void linkMetroICM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkMetroICM1MouseClicked
        int guardar = JOptionPane.showConfirmDialog(null, "¿Deseas Agregar Nuevo Motivo?", "Motivo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (guardar == JOptionPane.YES_OPTION) {
            btn_guardar.setVisible(true);
            txt_motivos.setText("");
            txt_motivos.setEnabled(true);
            txt_motivos.setEditable(true);
            txt_motivos.setFocusable(true);
        } else {
            btn_guardar.setVisible(false);
            txt_motivos.setText("");
            txt_motivos.setEnabled(false);
            txt_motivos.setEditable(false);
            txt_motivos.setFocusable(false);
        }

    }//GEN-LAST:event_linkMetroICM1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_guardar;
    private rojeru_san.complementos.RSButtonHover btn_modificar;
    private com.icm.components.metro.ComboboxMetroICM cboarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.icm.components.metro.LinkMetroICM linkMetroICM1;
    private javax.swing.JLabel msg;
    private com.icm.components.metro.TableMetroICM tbl_motivos;
    private javax.swing.JTextArea txt_motivos;
    // End of variables declaration//GEN-END:variables
}
