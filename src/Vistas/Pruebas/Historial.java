package Vistas.Pruebas;

import Controladores.Ficha;
import Modelo.inicio_sesion;
import javax.swing.table.DefaultTableModel;

public class Historial extends javax.swing.JPanel {

    private final DefaultTableModel tdatos2 = new DefaultTableModel();
    private final Ficha fi = new Ficha();

    public Historial() {
        initComponents();
        mostrar();
        tbldatos_Historial.setModel(tdatos2);
        String TitulosHistorial[] = {"Nombre y Apellido", "Área", "Motivo", "Obseración", "Fecha", "Atención", "Fecha-Hora"};
        tdatos2.setColumnIdentifiers(TitulosHistorial);
        tbldatos_Historial.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbldatos_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbldatos_Historial.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbldatos_Historial.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbldatos_Historial.getColumnModel().getColumn(4).setPreferredWidth(20);
        tbldatos_Historial.getColumnModel().getColumn(5).setPreferredWidth(25);
        tbldatos_Historial.getColumnModel().getColumn(6).setPreferredWidth(40);
        tbldatos_Historial.setDefaultEditor(Object.class, null);
        tbldatos_Historial.getTableHeader().setReorderingAllowed(false);
        tbldatos_Historial.setRowSelectionAllowed(true);
        tbldatos_Historial.setColumnSelectionAllowed(false);
        mostrartabla();
    }

    private void limpiartablaHistorial() {
        int x = tdatos2.getRowCount();
        for (int i = 0; i < x; i++) {
            tdatos2.removeRow(0);
        }
    }

    private void mostrar() {
        lbl_docente.setText(inicio_sesion.nombre + " " + inicio_sesion.apellido);
        lbl_programa_estudio.setText(inicio_sesion.programa);
        lbl_ciclo.setText(inicio_sesion.ciclo);
        lbl_turno.setText(inicio_sesion.turno);
    }

    private void mostrartabla() {
        limpiartablaHistorial();
        // Crear un hilo para cargar los datos en segundo plano
        Thread cargaDatosThread = new Thread(() -> {
            String ide = inicio_sesion.idusuario;
            int id = Integer.parseInt(ide);
            fi.mostrarHistorial(tdatos2, id);
        });
        // Iniciar el hilo
        cargaDatosThread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tbldatos_Historial = new rojeru_san.complementos.RSTableMetro();
        jLabel28 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbl_programa_estudio = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_docente = new javax.swing.JLabel();
        lbl_turno = new javax.swing.JLabel();
        lbl_ciclo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldatos_Historial.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldatos_Historial.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbldatos_Historial.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbldatos_Historial.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbldatos_Historial.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tbldatos_Historial);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1260, 650));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Historial");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setText("Programa de Estudio:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel29.setText("Turno:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jLabel30.setText("Ciclo:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 20));
        add(lbl_programa_estudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 560, 20));

        jLabel32.setText("Docente:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));
        add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 560, 20));
        add(lbl_turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 20));
        add(lbl_ciclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 100, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_ciclo;
    private javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_programa_estudio;
    private javax.swing.JLabel lbl_turno;
    private rojeru_san.complementos.RSTableMetro tbldatos_Historial;
    // End of variables declaration//GEN-END:variables
}
