package Vistas.Pruebas;

import Controladores.GuardarAlumno;

import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static Vistas.instrumento.Registro_Tutorial.lstalumnos;
import static Vistas.instrumento.Registro_Tutorial.txt_programa;
import static Vistas.instrumento.Registro_Tutorial.txt_turnos;
import static Vistas.instrumento.Registro_Tutorial.txt_ciclo;
import java.util.List;
import utils.DragComponentHelper;

public class BuscarAlumnos extends javax.swing.JDialog {
    
    private final DragComponentHelper dragComponentHelper = new DragComponentHelper(this);
    private final DragComponentHelper dragComponentHelper_;
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel listModel2 = new DefaultListModel();
    DefaultListModel listModel3 = new DefaultListModel();
    GuardarAlumno alum = new GuardarAlumno();

    public BuscarAlumnos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dragComponentHelper_ = new DragComponentHelper(jPanel1);
        setLocationRelativeTo(null);
        lstuno.setModel(listModel);
        lstdos.setModel(listModel2);
        lstalumnos.setModel(listModel3);
        updateJList();
        setResizable(false);
    }

    private void updateJList() {
        String progra = (String) txt_programa.getText();
        String turn = (String) txt_turnos.getText();
        String cic = (String) txt_ciclo.getText();
        alum.mostraralu(listModel, progra, turn, cic);
    }

    private void moveAllItems() {
        listModel3.clear();
        for (int i = 0; i < listModel2.getSize(); i++) {
            listModel3.addElement(listModel2.getElementAt(i));
        }

    }

    private void selectAllItems(boolean selected) {
        int itemCount = listModel.getSize();
        if (itemCount > 0) {
            if (selected) {
                int[] indices = new int[itemCount];
                for (int i = 0; i < itemCount; i++) {
                    indices[i] = i;
                }
                lstuno.setSelectedIndices(indices);
            } else {
                lstuno.clearSelection();
            }
        }
    }

    private void addItemToListAndClearTextField() {
        String nombre = txtalu.getText();

        if (!nombre.isEmpty()) {
            listModel.addElement(nombre);
            txtalu.setText("");
            txtalu.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtalu = new javax.swing.JTextField();
        btnagregar = new com.icm.components.metro.ButtonMetroICM();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chktodo = new com.icm.components.metro.CheckBoxMetroICM();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstuno = new com.icm.components.metro.ListMetroICM();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstdos = new com.icm.components.metro.ListMetroICM();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        agregar = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();

        txtalu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaluKeyPressed(evt);
            }
        });

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Escribir Alumnos:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chktodo.setForeground(new java.awt.Color(255, 255, 255));
        chktodo.setText("Seleccionar todo");
        chktodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chktodoMouseClicked(evt);
            }
        });
        jPanel1.add(chktodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 230, -1));

        lstuno.setVisibleRowCount(32);
        jScrollPane2.setViewportView(lstuno);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 300, 500));

        jScrollPane3.setViewportView(lstdos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 310, 500));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alumnos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumnos Seleccionados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        agregar.setText("Agregar ->");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 170, -1));

        rSButtonHover2.setText("<- Regresar");
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 170, -1));

        rSButtonHover1.setText("Agregar Alumno");
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        String nombre = txtalu.getText();

        if (!nombre.isEmpty()) {
            listModel.addElement(nombre);
            txtalu.setText("");
            txtalu.requestFocus();
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void chktodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chktodoMouseClicked
        selectAllItems(chktodo.isSelected());
    }//GEN-LAST:event_chktodoMouseClicked

    private void txtaluKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaluKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addItemToListAndClearTextField();
        }
    }//GEN-LAST:event_txtaluKeyPressed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        List<String> selectedValuesList = lstuno.getSelectedValuesList();
        if (selectedValuesList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Alumno, al menos!");
        } else {
            for (String value : selectedValuesList) {
                listModel.removeElement(value);
                listModel2.addElement(value);
            }
            lstuno.clearSelection();
            chktodo.setSelected(false);
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        String dato = (String) lstdos.getSelectedValue();
        if (dato == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un Alumno de la \n"
                    + "lista Seleccionados", "Alumnos Selecionados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[] selectedElements = (Object[]) lstdos.getSelectedValue();
            for (Object element : selectedElements) {
                listModel2.removeElement(element);
                listModel.addElement(element);
            }
        }
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        if (listModel2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta Alumnos en la Lista");
        } else {
            moveAllItems();
            dispose();
        }
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            BuscarAlumnos dialog = new BuscarAlumnos(new javax.swing.JFrame(), true);
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
    private rojeru_san.complementos.RSButtonHover agregar;
    private com.icm.components.metro.ButtonMetroICM btnagregar;
    private com.icm.components.metro.CheckBoxMetroICM chktodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static com.icm.components.metro.ListMetroICM lstdos;
    public static com.icm.components.metro.ListMetroICM lstuno;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private javax.swing.JTextField txtalu;
    // End of variables declaration//GEN-END:variables
}
