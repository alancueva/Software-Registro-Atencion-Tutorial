package Vistas.Administracion;

import Controladores.ExportarExcel;
import Controladores.Ficha;
import java.io.IOException;
import java.time.Month;
import java.time.YearMonth;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteGeneralMes extends javax.swing.JPanel {

    private final DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    private final DefaultTableModel tdatosreporte = new DefaultTableModel();
    private final Ficha fi = new Ficha();

    public ReporteGeneralMes() {
        initComponents();

        cbo_mes.setModel(combo1);

        String[] nombresMeses = fi.getNombresMeses();
        for (String mes : nombresMeses) {
            combo1.addElement(mes);
        }
        Month mesActual = YearMonth.now().getMonth();

        // Establecer el mes actual como seleccionado en el JComboBox
        cbo_mes.setSelectedIndex(mesActual.getValue() - 1);

        String Titulos1[] = {"N°", "Nombre y Apellido", "Area", "Motivo", "Observación", "Fecha", "Atención", "Programa", "Turno", "Semestre", "Tutor"};
        tdatosreporte.setColumnIdentifiers(Titulos1);
        tbldatos.setModel(tdatosreporte);
//        tbldatos.getColumnModel().getColumn(0).setPreferredWidth(5);//Tamaño columnas
//        tbldatos.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tbldatos.getColumnModel().getColumn(2).setPreferredWidth(100);
//        tbldatos.getColumnModel().getColumn(3).setPreferredWidth(80);
//        tbldatos.getColumnModel().getColumn(4).setPreferredWidth(100);
//        tbldatos.getColumnModel().getColumn(5).setPreferredWidth(10);
//        tbldatos.getColumnModel().getColumn(6).setPreferredWidth(30);
//        tbldatos.getColumnModel().getColumn(7).setPreferredWidth(80);
//        tbldatos.getColumnModel().getColumn(8).setPreferredWidth(5);
//        tbldatos.getColumnModel().getColumn(9).setPreferredWidth(5);
//        tbldatos.getColumnModel().getColumn(9).setPreferredWidth(50);
        tbldatos.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbldatos.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbldatos.setRowSelectionAllowed(true);
        tbldatos.setColumnSelectionAllowed(false);

        String msge = "<html>"
                + "<head>"
                + "<style>h1 {color: #000; text-align: center;} "
                + "p {font-style: italic;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>Reporte por Mes</h1>"
                //                + "<p>reporte.</p>"
                + "</body>"
                + "</html>";
        msg.setText(msge);
    }

    private void limpiartabla2() {
        int x = tdatosreporte.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatosreporte.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSCalendarBeanInfo1 = new rojeru_san.componentes.RSCalendarBeanInfo();
        cbo_mes = new com.icm.components.metro.ComboboxMetroICM();
        btn_mostrar = new rojeru_san.complementos.RSButtonHover();
        jLabel1 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new com.icm.components.metro.TableMetroICM();
        btn_expo = new rojeru_san.complementos.RSButtonHover();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbo_mes.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        add(cbo_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 240, 40));

        btn_mostrar.setText("Mostrar");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 140, -1));

        jLabel1.setText("Meses");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));
        add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 710, 90));

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldatos.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbldatos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 1170, 490));

        btn_expo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/microsoft_office_excel_logo_icon_145720 (1).png"))); // NOI18N
        btn_expo.setText("Exportar");
        btn_expo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_expoActionPerformed(evt);
            }
        });
        add(btn_expo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        String nombreMes = (String) cbo_mes.getSelectedItem();
        int numeroMes = fi.getNumeroMes(nombreMes);
        System.out.println("mes " + numeroMes);
        limpiartabla2();
        if (!fi.mostrarporfechaMensual(tdatosreporte, numeroMes)) {
            JOptionPane.showMessageDialog(this, "No hay registros en este mes seleccionado");
        }

    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void btn_expoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_expoActionPerformed
        if (tbldatos == null || tbldatos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos. La tabla está vacía.", "Tabla vacía", JOptionPane.WARNING_MESSAGE);
        } else {
            ExportarExcel obj;
            try {
                obj = new ExportarExcel();
                obj.exportarExcel(tbldatos);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_btn_expoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_expo;
    private rojeru_san.complementos.RSButtonHover btn_mostrar;
    private com.icm.components.metro.ComboboxMetroICM cbo_mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    private com.icm.components.metro.TableMetroICM tbldatos;
    // End of variables declaration//GEN-END:variables
}
