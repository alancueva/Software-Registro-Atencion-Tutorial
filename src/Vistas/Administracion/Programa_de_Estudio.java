
package Vistas.Administracion;

import Controladores.ProgramaDeEstudio;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Programa_de_Estudio extends javax.swing.JPanel {
    DefaultTableModel tdatos1 = new DefaultTableModel();
    DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    ProgramaDeEstudio pro = new ProgramaDeEstudio();
    public Programa_de_Estudio() {
        initComponents();
        cboprograma.setModel(combo1);
        pro.programa(combo1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new rojeru_san.complementos.RSTableMetro();
        cboprograma = new com.icm.components.metro.ComboboxMetroICM();
        comboboxMetroICM2 = new com.icm.components.metro.ComboboxMetroICM();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_programa = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();

        rSButtonHover2.setText("Nuevo");

        rSButtonHover3.setText("Grabar");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonHover1.setText("Modificar");
        add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 170, -1));

        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_datos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 950, 370));
        add(cboprograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 350, -1));
        add(comboboxMetroICM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jLabel1.setText("Programas de Estudio");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel2.setText("Vigencia");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jLabel3.setText("Programa de Estudio");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txt_programa.setEditable(false);
        txt_programa.setBackground(new java.awt.Color(255, 255, 255));
        txt_programa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_programa.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txt_programa.setSelectionColor(new java.awt.Color(153, 204, 255));
        add(txt_programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, -1));

        jLabel4.setText("Programas de Estudio");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.icm.components.metro.ComboboxMetroICM cboprograma;
    private com.icm.components.metro.ComboboxMetroICM comboboxMetroICM2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSTableMetro tbl_datos;
    public static app.bolivia.swing.JCTextField txt_programa;
    // End of variables declaration//GEN-END:variables
}
