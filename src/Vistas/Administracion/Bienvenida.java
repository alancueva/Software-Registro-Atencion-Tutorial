package Vistas.Administracion;

import Controladores.Ficha;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class Bienvenida extends javax.swing.JPanel {

    DefaultTableModel tdatos = new DefaultTableModel();
    DefaultTableModel tdatosDOC = new DefaultTableModel();
    Ficha fi = new Ficha();

    public Bienvenida() {
        initComponents();
        tbldato3.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbldato3.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbldato3.setRowSelectionAllowed(true);
        tbldato3.setColumnSelectionAllowed(false);
        tbldato3.setModel(tdatos);
        //
        tbl_docentes.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbl_docentes.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbl_docentes.setRowSelectionAllowed(true);
        tbl_docentes.setColumnSelectionAllowed(false);
        tbl_docentes.setModel(tdatosDOC);
        String Titulos[] = {"Areas", "Registro", "Total", "Porcentaje"};
        tdatos.setColumnIdentifiers(Titulos);
        String Titulos2[] = {"DOCENTE", "CANTIDAD REGRISTRADO", "CANTIDAD DE SESIONES"};
        tdatosDOC.setColumnIdentifiers(Titulos2);

        String titulo = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + "h1 { margin-bottom: 10px; text-align: center; }"
                + "p { margin-top: 0; text-align: justify; margin: 0; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>BIENVENIDO ADMIN</h1>"
                + "<p>En esta ventana, observarás dos tablas:</p>"
                + "<ol>"
                + "<li>a. Cantidad de Áreas atendidas.</li>"
                + "<li>b. Registro de Atención de Docentes.</li>"
                + "</ol>"
                + "<p>En detalle:</p>"
                + "<ol>"
                + "<li>a. En Cantidad de Áreas atendidas, observarás el total de alumnos registrados y su porcentaje según las áreas atendidas.</li>"
                + "<li>b. En Registro de atención de Docentes, observarás el total de atenciones realizadas.</li>"
                + "</ol>"
                + "</body>"
                + "</html>";
        lbl_msg.setText(titulo);
        mostrarA();
        mostrarR();
    }

    private void mostrarA() {
        limpiartablaAREA();
        Thread cargaDatosThread = new Thread(() -> {
            fi.numeroporc(tdatos);
        });
        cargaDatosThread.start();
    }

    private void mostrarR() {
        limpiartablaRl();
        Thread cargaDatosThread = new Thread(() -> {
            fi.docenteregistro(tdatosDOC);
        });
        cargaDatosThread.start();
    }

    private void limpiartablaAREA() {
        int x = tdatos.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos.removeRow(0);
        }
    }

    private void limpiartablaRl() {
        int x = tdatosDOC.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatosDOC.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ini = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldato3 = new com.icm.components.metro.TableMetroICM();
        lbl_msg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_docentes = new com.icm.components.metro.TableMetroICM();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        ini.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout iniLayout = new javax.swing.GroupLayout(ini);
        ini.setLayout(iniLayout);
        iniLayout.setHorizontalGroup(
            iniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        iniLayout.setVerticalGroup(
            iniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldato3.setBackground(new java.awt.Color(0, 0, 0));
        tbldato3.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldato3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbldato3.setGridColor(new java.awt.Color(0, 0, 0));
        tbldato3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbldato3.setSurrendersFocusOnKeystroke(true);
        jScrollPane3.setViewportView(tbldato3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 560, 380));
        add(lbl_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 880, 200));

        tbl_docentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_docentes.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbl_docentes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 490, 380));

        jLabel2.setText("Cantidad de Areas");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));

        jLabel3.setText("Registro de Docentes");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, -1, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ini;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_msg;
    private com.icm.components.metro.TableMetroICM tbl_docentes;
    private com.icm.components.metro.TableMetroICM tbldato3;
    // End of variables declaration//GEN-END:variables
}
