/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Administracion;

import Vistas.instrumento.Instrumento;
import Controladores.Ciclo;
import Modelo.Conexion;
import Controladores.GuardarAlumno;
import Controladores.ProgramaDeEstudio;
import Controladores.Turno;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
//import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alanc
 */
public class GuardarAlumnos extends javax.swing.JFrame {

    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion = 0;
    ProgramaDeEstudio pro = new ProgramaDeEstudio();
    Turno tu = new Turno();
    Ciclo ci = new Ciclo();
    DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    DefaultTableModel tdatos1 = new DefaultTableModel();
    DefaultTableModel tdatos2 = new DefaultTableModel();
    DefaultListModel lst = new DefaultListModel();
    GuardarAlumno alu = new GuardarAlumno();
    Conexion ocon = new Conexion();

    /**
     * Creates new form GuardarAlumnos
     */
    public GuardarAlumnos() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Guardar Alumos");
        setVisible(true);
        cboprograma.setModel(combo1);
        pro.programa(combo1);
        tbldatos.setModel(tdatos1);
//        tbldatos1.setModel(tdatos2);
        String Titulos[] = {"Alumnos", "idpro", "pro", "idturno", "tur", "idci", "ciclo"};
        tdatos1.setColumnIdentifiers(Titulos);
//        tdatos1.setAutoResizeMode(AUTO_RESIZE_OFF);
        cboturno.setModel(combo2);
        cbociclo.setModel(combo3);
        ci.ciclo(combo3);
        cboturno.setEnabled(false);
        cbociclo.setEnabled(false);
        tbldatos.setDefaultRenderer(Object.class, new CustomColumnRenderer());
        jList1.setModel(lst);
//        lstlis.setModel(lst);
    }

    private void limpiartabla() {
        int x = tdatos1.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos1.removeRow(0);
        }
    }

    private void llenar() {
//        String nom = txtnom.getText();
//        alu.setNom(nom);
//        String ape = txtape.getText();
//        alu.setApe(ape);
        String codpro = (String) cboprograma.getSelectedItem();
//        String txtprog = txtpro.getText();
//        alu.setIdpro(pro.capturacod(codpro));

        alu.setPro((String) cboprograma.getSelectedItem());
        String valorpro = (String) cboprograma.getSelectedItem();
        String nompro = txtpro.getText();
        
        String codtu = (String) cboturno.getSelectedItem();
        String txttur = txtturno.getText();
        
//        alu.setIdtu(tu.capturacod(codtu));
        alu.setTurno((String) cboturno.getSelectedItem());
        String codci = (String) cbociclo.getSelectedItem();
        String txtci  =txtciclo.getText();
//        alu.setIdci(ci.capturacod(codci));
        alu.setCi((String) cbociclo.getSelectedItem());

        
        
        tdatos1.setRowCount(0);
        // Obtener los elementos seleccionados del JList
        List<String> selectedItems = jList1.getSelectedValuesList();
        // Rellenar la tabla con los elementos seleccionados y cajas de texto vacías
        for (int i = 0; i < selectedItems.size(); i++) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(selectedItems.get(i)); // Elemento seleccionado
            rowData.add(pro.capturacod(codpro));
            rowData.add(nompro); // Caja de texto (vacía inicialmente)
            rowData.add(tu.capturacod(codtu));
            rowData.add(txttur);
            rowData.add(ci.capturacod(codci));
            rowData.add(txtci);
//            rowData.add(pro.capturacod(valorpro));
//            rowData.add(prog);
//            rowData.add(turn);
//            rowData.add(cic);
//            rowData.add(profes);
            // rowData.add(moti); // Esta línea está comentada en tu código original
            tdatos1.addRow(rowData);
        }
        try {
            ocon.conectar();
            for (int i = 0; i < tdatos1.getRowCount(); i++) {
                PreparedStatement stm = ocon.con.prepareStatement("INSERT INTO alumnos (nom_alumnos,idProgramaDeEstudio,programa,idTurno,turno,idCiclo,ciclo) VALUES (?,?,?,?,?,?,?)");
                stm.setString(1, tdatos1.getValueAt(i, 0).toString());
                stm.setString(2, tdatos1.getValueAt(i, 1).toString());
                stm.setString(3, tdatos1.getValueAt(i, 2).toString());
                stm.setString(4, tdatos1.getValueAt(i, 3).toString());
                stm.setString(5, tdatos1.getValueAt(i, 4).toString());
                stm.setString(6, tdatos1.getValueAt(i, 5).toString());
                stm.setString(7, tdatos1.getValueAt(i, 6).toString());
                stm.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente en la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + e.getMessage());
        }
    }

    static class CustomColumnRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.isColumnSelected(column)) {
                component.setBackground(Color.DARK_GRAY); // Change the color as needed
            } else {
                component.setBackground(table.getBackground());
            }
            return component;
        }
    }
    private void selectAllItems(boolean selected) {
        if (selected) {
            jList1.setSelectionInterval(0, lst.size() - 1);
        } else {
            jList1.clearSelection();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboprograma = new com.icm.components.metro.ComboboxMetroICM();
        cboturno = new com.icm.components.metro.ComboboxMetroICM();
        cbociclo = new com.icm.components.metro.ComboboxMetroICM();
        txtape = new javax.swing.JTextField();
        btnimportar = new com.icm.components.metro.ButtonMetroICM();
        btngrabar = new com.icm.components.metro.ButtonMetroICM();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonMetroICM3 = new com.icm.components.metro.ButtonMetroICM();
        jButton1 = new javax.swing.JButton();
        txtnom = new javax.swing.JTextField();
        buttonMetroICM1 = new com.icm.components.metro.ButtonMetroICM();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new com.icm.components.metro.TableMetroICM();
        btnmostaradoc = new javax.swing.JButton();
        txtpro = new javax.swing.JTextField();
        txtturno = new javax.swing.JTextField();
        txtciclo = new javax.swing.JTextField();
        chktodos = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboprograma.setMaximumRowCount(10);
        cboprograma.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboprogramaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cboprograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, -1));

        cboturno.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboturnoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cboturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        cbociclo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbocicloPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cbociclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));
        jPanel1.add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 160, -1));

        btnimportar.setText("IMPORTAR ALUMNOS");
        btnimportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportarActionPerformed(evt);
            }
        });
        jPanel1.add(btnimportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        btngrabar.setText("GRABAR");
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        jPanel1.add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        jLabel1.setText("Programa de Estudio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("Turno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel3.setText("Ciclo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        buttonMetroICM3.setText("MODIFICAR");
        jPanel1.add(buttonMetroICM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, -1));

        buttonMetroICM1.setText("Salir");
        buttonMetroICM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMetroICM1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonMetroICM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));

        jScrollPane3.setViewportView(jList1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 270, 530));

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbldatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 890, 300));

        btnmostaradoc.setText("Mostar Documento");
        btnmostaradoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostaradocActionPerformed(evt);
            }
        });
        jPanel1.add(btnmostaradoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 130, 40));
        jPanel1.add(txtpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, -1));
        jPanel1.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 140, -1));
        jPanel1.add(txtciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 150, -1));

        chktodos.setText("Seleccionalod todos");
        chktodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chktodosActionPerformed(evt);
            }
        });
        jPanel1.add(chktodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));

        jButton2.setText("limpiar lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 373, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboprogramaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboprogramaPopupMenuWillBecomeInvisible
        String valor1 = (String) cboprograma.getSelectedItem();
        if (valor1.equals("Seleccionar")) {
            cboturno.setSelectedItem("Seleccionar");
            txtpro.setText("");
            cboturno.setEnabled(false);
            cbociclo.setEnabled(false);
            cbociclo.removeAllItems();
            txtnom.setText("");
            txtape.setText("");
            cboturno.removeAllItems();
        } else {
            txtpro.setText(valor1);
            
            txtnom.setText("");
            txtape.setText("");
            txtnom.requestFocus();
            cboturno.setEnabled(true);
            cboturno.removeAllItems();
            tu.Turno(combo2, valor1);
            cboturno.setSelectedItem("Seleccionar");
            cbociclo.setSelectedItem("Seleccionar");
        }
    }//GEN-LAST:event_cboprogramaPopupMenuWillBecomeInvisible

    private void cboturnoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboturnoPopupMenuWillBecomeInvisible
        String valor2 = (String) cboturno.getSelectedItem();
        if (valor2.equals("Seleccionar")) {
            txtciclo.setText("");
            cbociclo.setEnabled(false);
        } else {
            txtturno.setText(valor2);
//            txtape.setText("");
            cbociclo.setEnabled(true);
            cbociclo.setSelectedItem("Seleccionar");
            cbociclo.removeAllItems();
            ci.ciclo(combo3);
        }
    }//GEN-LAST:event_cboturnoPopupMenuWillBecomeInvisible

    private void cbocicloPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbocicloPopupMenuWillBecomeInvisible
        String valor3 = (String) cbociclo.getSelectedItem();
//        txtape.setText(ci.capturacod(valor3));
        
        if (valor3.equals("Seleccionar")) {
            txtciclo.setText("");
        }else{
            txtciclo.setText(valor3);
        }

    }//GEN-LAST:event_cbocicloPopupMenuWillBecomeInvisible

    private void btnimportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportarActionPerformed
//        File excelFile;
//        FileInputStream excelFIS = null;
//        BufferedInputStream excelBIS = null;
//        XSSFWorkbook excelImportToJTable = null;
//        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
//        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
//        excelFileChooser.setDialogTitle("Select Excel File");
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
//        excelFileChooser.setFileFilter(fnef);
//        int excelChooser = excelFileChooser.showOpenDialog(null);
//        if (excelChooser == JFileChooser.APPROVE_OPTION) {
//            try {
//                excelFile = excelFileChooser.getSelectedFile();
//                excelFIS = new FileInputStream(excelFile);
//                excelBIS = new BufferedInputStream(excelFIS);
//                excelImportToJTable = new XSSFWorkbook(excelBIS);
//                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
//
//                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
//                    XSSFRow excelRow = excelSheet.getRow(row);
//
//                    XSSFCell excelName = excelRow.getCell(0);
//                    XSSFCell excelGender = excelRow.getCell(1);
//                    XSSFCell excelProgrammingLanguage = excelRow.getCell(2);
//                    XSSFCell excelSubject = excelRow.getCell(3);
////                    XSSFCell excelImage = excelRow.getCell(4);
//
////                    JLabel excelJL = new JLabel(new ImageIcon(new ImageIcon(excelImage.getStringCellValue()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
//                    tdatos2.addRow(new Object[]{excelName, excelGender, excelProgrammingLanguage, excelSubject});
//                }
//                JOptionPane.showMessageDialog(null, "Importado con exito !");
//            } catch (IOException iOException) {
//                JOptionPane.showMessageDialog(null, iOException.getMessage());
//            } finally {
//                try {
//                    if (excelFIS != null) {
//                        excelFIS.close();
//                    }
//                    if (excelBIS != null) {
//                        excelBIS.close();
//                    }
//                    if (excelImportToJTable != null) {
//                        excelImportToJTable.close();
//                    }
//                } catch (IOException iOException) {
//                    JOptionPane.showMessageDialog(null, iOException.getMessage());
//                }
//            }
//        }
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS;
        excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;

        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);

        int excelChooser = excelFileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                // Obtener el archivo seleccionado
                excelFile = excelFileChooser.getSelectedFile();

                // Crear flujos de entrada
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                // Crear un objeto de libro de trabajo de Excel
                excelImportToJTable = new XSSFWorkbook(excelBIS);

                // Obtener la primera hoja del libro
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                // Iterar sobre las filas y agregar datos a la tabla
                for (int row = 0; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    if (excelRow != null) {
                        XSSFCell excelName = excelRow.getCell(0);
                        XSSFCell excelGender = excelRow.getCell(1);
                        XSSFCell excelProgrammingLanguage = excelRow.getCell(2);
                        XSSFCell excelSubject = excelRow.getCell(3);

                        // Verificar si las celdas son nulas y agregar datos a la tabla
                        if (excelName != null && excelGender != null && excelProgrammingLanguage != null && excelSubject != null) {
                            tdatos2.addRow(new Object[]{excelName.toString(), excelGender.toString(),
                                excelProgrammingLanguage.toString(), excelSubject.toString()});
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Importado con éxito!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo Excel:\n" + e.getMessage());
            } finally {
                try {
                    // Cerrar los flujos de entrada y el libro de trabajo de Excel
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar los flujos:\n" + e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnimportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int[] selectedRows = tbldatos.getSelectedColumns();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
        String dato14 = (String) jList1.getSelectedValue();
        if (dato14 == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Faltan Alumnos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String txtprog = txtpro.getText();
        String txttur = txtturno.getText();
        String txtci  =txtciclo.getText();
        if (txtprog.isEmpty()& txttur.isEmpty()& txtci.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        } 
        JOptionPane.showConfirmDialog(rootPane, "Deseas Grabar", "Grabar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        llenar();
//        alu.grabar();
        limpiartabla();
        alu.mostrar(tdatos1);
        String Titulos[] = {"Codigo", "Alumnos", "idpro", "pro", "idturno", "tur", "idci", "ciclo"};
        tdatos1.setColumnIdentifiers(Titulos);
    }//GEN-LAST:event_btngrabarActionPerformed

    private void buttonMetroICM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMetroICM1ActionPerformed
        dispose();
        Instrumento ins = new Instrumento();
        ins.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_buttonMetroICM1ActionPerformed

    private void tbldatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatosMouseClicked
        int pos = tbldatos.getSelectedRow();
//        txtdni.setText((String) tbldatos.getValueAt(pos, 0));
        txtnom.setText((String) tbldatos.getValueAt(pos, 1));
        txtape.setText((String) tbldatos.getValueAt(pos, 2));
//        txtam.setText((String) tbldatos.getValueAt(pos, 3));
//        txtd.setText((String) tbldatos.getValueAt(pos, 4));
    }//GEN-LAST:event_tbldatosMouseClicked
    private void cargarDatosDesdeArchivo(File archivo) {
        try {
            List<String> lineas = leerArchivoTexto(archivo);
            lst.clear();
            for (String linea : lineas) {
                lst.addElement(linea);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Algo esta mal");
        }
    }
    private List<String> leerArchivoTexto(File archivo) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }

        return lineas;
    }
    private void btnmostaradocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostaradocActionPerformed
//         JFileChooser fileChooser = new JFileChooser();
//        
//        // Configuración para que solo se puedan seleccionar archivos de texto
//        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Texto", "txt"));
//
//        int resultado = fileChooser.showOpenDialog(this);
//
//        if (resultado == JFileChooser.APPROVE_OPTION) {
//            File archivoSeleccionado = fileChooser.getSelectedFile();
//            cargarDatosDesdeArchivo(archivoSeleccionado);
//        }
        FileDialog fileDialog = new FileDialog((Frame) null, "Seleccionar archivo", FileDialog.LOAD);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);

        String directorio = fileDialog.getDirectory();
        String archivo = fileDialog.getFile();

        if (directorio != null && archivo != null) {
            File archivoSeleccionado = new File(directorio, archivo);
            cargarDatosDesdeArchivo(archivoSeleccionado);
        }
    }//GEN-LAST:event_btnmostaradocActionPerformed

    private void chktodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chktodosActionPerformed
        selectAllItems(chktodos.isSelected());
    }//GEN-LAST:event_chktodosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       lst.clear();
       chktodos.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuardarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuardarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuardarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuardarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuardarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.icm.components.metro.ButtonMetroICM btngrabar;
    private com.icm.components.metro.ButtonMetroICM btnimportar;
    private javax.swing.JButton btnmostaradoc;
    private com.icm.components.metro.ButtonMetroICM buttonMetroICM1;
    private com.icm.components.metro.ButtonMetroICM buttonMetroICM3;
    private com.icm.components.metro.ComboboxMetroICM cbociclo;
    private com.icm.components.metro.ComboboxMetroICM cboprograma;
    private com.icm.components.metro.ComboboxMetroICM cboturno;
    private javax.swing.JCheckBox chktodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.icm.components.metro.TableMetroICM tbldatos;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtciclo;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtpro;
    private javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
}
