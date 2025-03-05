package Vistas.Administracion;

import Controladores.Area;
import Controladores.ExportarExcel;
import Controladores.Ficha;
import Controladores.ProgramaDeEstudio;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Month;
import java.time.YearMonth;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ReporteMensual extends javax.swing.JPanel {

    DefaultTableModel tdatosreporte = new DefaultTableModel();
    DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    Ficha fi = new Ficha();
    ProgramaDeEstudio pro = new ProgramaDeEstudio();
    Area ar = new Area();

    public ReporteMensual() {
        initComponents();
//        this.add(jScrollPane1, BorderLayout.CENTER);
//        reportemensual.setVisible(false);
        cboprograma.setModel(combo1);
        cboarea.setModel(combo2);
        pro.programa(combo1);
        ar.area(combo2);

        cbo_mes.setModel(combo3);
        String[] nombresMeses = fi.getNombresMeses();
        for (String mes : nombresMeses) {
            combo3.addElement(mes);
        }
        Month mesActual = YearMonth.now().getMonth();

        // Establecer el mes actual como seleccionado en el JComboBox
        cbo_mes.setSelectedIndex(mesActual.getValue() - 1);

//        jMenu2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tbldatos1.setModel(tdatosreporte);
        adjustColumnWidths(tbldatos1);
        String Titulos1[] = {"N°", "Nombre y Apellido", "Area", "Motivo", "Observación", "Fecha", "Atención", "Programa", "Turno", "Semestre", "Tutor"};
        tdatosreporte.setColumnIdentifiers(Titulos1);
//        tbldatos1.getColumnModel().getColumn(0).setPreferredWidth(5);//Tamaño columnas
//        tbldatos1.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tbldatos1.getColumnModel().getColumn(2).setPreferredWidth(100);
//        tbldatos1.getColumnModel().getColumn(3).setPreferredWidth(80);
//        tbldatos1.getColumnModel().getColumn(4).setPreferredWidth(100);
//        tbldatos1.getColumnModel().getColumn(5).setPreferredWidth(10);
//        tbldatos1.getColumnModel().getColumn(6).setPreferredWidth(30);
//        tbldatos1.getColumnModel().getColumn(7).setPreferredWidth(80);
//        tbldatos1.getColumnModel().getColumn(8).setPreferredWidth(5);
//        tbldatos1.getColumnModel().getColumn(9).setPreferredWidth(5);
//        tbldatos1.getColumnModel().getColumn(9).setPreferredWidth(50);
        // Establecer el comportamiento de redimensionamiento del JScrollPane
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tbldatos1.setDefaultEditor(Object.class, null);
        // Deshabilitar el arrastre de columnas
        tbldatos1.getTableHeader().setReorderingAllowed(false);
        // Permitir la selección de filas
        tbldatos1.setRowSelectionAllowed(true);
        tbldatos1.setColumnSelectionAllowed(false);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        String msge = "<html>"
                + "<head>"
                + "<style>h1 {color: #000; text-align: center;} "
                + "p {font-style: italic;}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>Reporte por Mes, Programa de Estudio y Área</h1>"
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

// Método para obtener un nombre de archivo PDF válido
    private String getValidPdfFileName(String fileName) {
        // Si el nombre del archivo no termina con .pdf, agregarlo
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            fileName += ".pdf";
        }
        return fileName;
    }

    public static void adjustColumnWidths(JTable table) {
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            TableColumn column = table.getColumnModel().getColumn(columnIndex);

            // Set minimum width
            column.setMinWidth(15);

            // Get the header width
            int headerWidth = getHeaderWidth(table, columnIndex);

            // Get the maximum cell width
            int cellWidth = getMaxCellWidth(table, columnIndex);

            // Set the column width to the maximum of the header and cell widths
            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }

    private static int getHeaderWidth(JTable table, int columnIndex) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        Object headerValue = column.getHeaderValue();
        TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
        Component headerComponent = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, columnIndex);
        return headerComponent.getPreferredSize().width;
    }

    private static int getMaxCellWidth(JTable table, int columnIndex) {
        int maxWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, columnIndex);
            Object cellValue = table.getValueAt(row, columnIndex);
            Component cellComponent = cellRenderer.getTableCellRendererComponent(table, cellValue, false, false, row, columnIndex);
            int cellWidth = cellComponent.getPreferredSize().width;
            maxWidth = Math.max(maxWidth, cellWidth);
        }
        return maxWidth;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtmes = new com.toedter.calendar.JMonthChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos1 = new com.icm.components.metro.TableMetroICM();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnpdf = new rojeru_san.complementos.RSButtonHover();
        jLabel6 = new javax.swing.JLabel();
        cboprograma = new com.icm.components.metro.ComboboxMetroICM();
        cboarea = new com.icm.components.metro.ComboboxMetroICM();
        cbo_mes = new com.icm.components.metro.ComboboxMetroICM();
        msg = new javax.swing.JLabel();
        btn_exportar = new rojeru_san.complementos.RSButtonHover();
        btn_mostrar = new rojeru_san.complementos.RSButtonHover();

        dtmes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldatos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldatos1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbldatos1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbldatos1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbldatos1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1200, 480));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Mes:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Área");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, -1));

        btnpdf.setText("PDF");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });
        add(btnpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 120, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Programa de Estudio");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        cboprograma.setMaximumRowCount(9);
        add(cboprograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 340, -1));
        add(cboarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 230, -1));

        cbo_mes.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        add(cbo_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, -1));
        add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 660, 40));

        btn_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/microsoft_office_excel_logo_icon_145720 (1).png"))); // NOI18N
        btn_exportar.setText("Excel");
        btn_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarActionPerformed(evt);
            }
        });
        add(btn_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 120, -1));

        btn_mostrar.setText("Mostrar");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void generatePDFi(DefaultTableModel table, String title, String title1, String title2) {
        if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos para imprimir.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Crear un cuadro de diálogo para elegir la ubicación y el nombre del archivo PDF
        FileDialog fileDialog = new FileDialog((Frame) null, "Guardar archivo", FileDialog.SAVE);
        // Configurar el filtro para que solo muestre archivos con extensión .pdf
        fileDialog.setFile("*.pdf");
        // Mostrar solo archivos con extensión .pdf
        fileDialog.setFilenameFilter((dir, name) -> name.endsWith(".pdf"));
        fileDialog.setVisible(true);
        // Obtener el nombre del archivo seleccionado
        String archivo = fileDialog.getFile();
        if (archivo != null) {
            // Asegurarse de que el archivo tenga la extensión .pdf
            String filePath = fileDialog.getDirectory() + "\\" + getValidPdfFileName2(archivo);

            Document document = new Document(PageSize.A4.rotate()); // Configurar la hoja en orientación horizontal
            float leftMargin = 1.5f * 28.35f;
            float rightMargin = 1.5f * 28.35f;
            document.setMargins(leftMargin, rightMargin, document.topMargin(), document.bottomMargin()); // Convertir centímetros a puntos
//            // Ajustar los márgenes (1.5 cm en cada lado)
//            document.setMargins(1.5f * 28.35f, 1.5f * 28.35f, 1.5f * 28.35f, 1.5f * 28.35f); // Convertir centímetros a puntos
            try {
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();
                // Añadir título al PDF
                Phrase phrase = new Phrase(title, new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
                PdfPCell cell = new PdfPCell(phrase);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorder(PdfPCell.NO_BORDER);
                PdfPTable titleTable = new PdfPTable(1);
                titleTable.setWidthPercentage(100);
                titleTable.addCell(cell);
                document.add(titleTable);
                // Añadir segundo título al PDF (centrado)
                Phrase phraseTitle2 = new Phrase(title1, new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
                PdfPCell cellTitle2 = new PdfPCell(phraseTitle2);
                cellTitle2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTitle2.setBorder(PdfPCell.NO_BORDER);
                PdfPTable titleTable2 = new PdfPTable(1);
                titleTable2.setWidthPercentage(100);
                titleTable2.addCell(cellTitle2);
                document.add(titleTable2);
                // Espacio
//                document.add(new Phrase("\n"));
                // Añadir título al PDF
                Phrase phrase2 = new Phrase(title2, new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
                PdfPCell cell2 = new PdfPCell(phrase2);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell2.setBorder(PdfPCell.NO_BORDER);
                PdfPTable titleTable1 = new PdfPTable(1);
                titleTable1.setWidthPercentage(100);
                titleTable1.addCell(cell2);
                document.add(titleTable1);
                // Espacio
                document.add(new Phrase("\n"));

                // Ajustar el ancho de las columnas proporcionalmente al espacio disponible
                float tableWidth = PageSize.A4.rotate().getWidth() - leftMargin - rightMargin;
                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                float[] columnWidths = new float[table.getColumnCount()];

                for (int i = 0; i < table.getColumnCount(); i++) {
                    columnWidths[i] = tableWidth / table.getColumnCount(); // Distribuir el ancho equitativamente entre las columnas
                }
                pdfTable.setWidths(columnWidths);
                // Añadir encabezados de columna
                for (int i = 0; i < table.getColumnCount(); i++) {
                    pdfTable.addCell(new Phrase(table.getColumnName(i)));
                }
                // Añadir datos de la tabla
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        pdfTable.addCell(new Phrase(table.getValueAt(i, j).toString()));
                    }
                }
                // Añadir tabla al documento PDF
                document.add(pdfTable);
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                document.close();
                JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            System.out.println("Guardado cancelado por el usuario");
        }
    }

    private String getValidPdfFileName2(String fileName) {
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            fileName += ".pdf";
        }
        return fileName;
    }
    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
        if (tbldatos1 == null || tbldatos1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos. La tabla está vacía.", "Tabla vacía", JOptionPane.WARNING_MESSAGE);
            //            return;
        } else {
            String titulo = "IESTP \"Carlos Salazar Romero\" \n"
                    + "Unidad de Binestar y Empleabilidad \n"
                    + "Programa: Orientacion y Tutoria";
            String titulo2 = "REPORTE MENSUAL";
            String mes = fi.getNombreMes(dtmes);
            String programa = (String) cboprograma.getSelectedItem();
            String area = (String) cboarea.getSelectedItem();
            String titulo3 = "Mes de " + mes + "\n"
                    + "Programa: " + programa + "\n"
                    + "Area: " + area;

            generatePDFi(tdatosreporte, titulo, titulo2, titulo3);

        }

    }//GEN-LAST:event_btnpdfActionPerformed

    private void btn_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarActionPerformed
        if (tbldatos1 == null || tbldatos1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos. La tabla está vacía.", "Tabla vacía", JOptionPane.WARNING_MESSAGE);
        } else {
            ExportarExcel obj;
            try {
                obj = new ExportarExcel();
                obj.exportarExcel(tbldatos1);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_btn_exportarActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        String are = (String) cboarea.getSelectedItem();
        if (are.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione un area");
            return;
        }
        String prog = (String) cboprograma.getSelectedItem();

        if (prog.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione un programa de estudio");
        } else {
            Thread cargaDatosThread = new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    btn_mostrar.setEnabled(false);
                    btn_mostrar.setText("Cargando...");
                });
                String nombreMes = (String) cbo_mes.getSelectedItem();
                //            String mes = fi.getMes(dtmes);
                int numeroMes = fi.getNumeroMes(nombreMes);

                String mes = String.valueOf(numeroMes);
                limpiartabla2();
                if (!fi.mostrarporfecha(tdatosreporte, are, prog, mes)) {
                    btn_mostrar.setEnabled(true);
                    btn_mostrar.setText("Mostrar");
                    JOptionPane.showMessageDialog(this, "No hay registros en este programa y área para el mes seleccionado");
                }
                btn_mostrar.setEnabled(true);
                btn_mostrar.setText("Mostrar");
            });
            cargaDatosThread.start();
        }
    }//GEN-LAST:event_btn_mostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_exportar;
    private rojeru_san.complementos.RSButtonHover btn_mostrar;
    private rojeru_san.complementos.RSButtonHover btnpdf;
    private com.icm.components.metro.ComboboxMetroICM cbo_mes;
    private com.icm.components.metro.ComboboxMetroICM cboarea;
    private com.icm.components.metro.ComboboxMetroICM cboprograma;
    private com.toedter.calendar.JMonthChooser dtmes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private com.icm.components.metro.TableMetroICM tbldatos1;
    // End of variables declaration//GEN-END:variables
}
