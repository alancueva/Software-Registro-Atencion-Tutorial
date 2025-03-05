package Controladores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import java.awt.FileDialog;
import javax.swing.JFrame;

public class ExportarExcel {

    public void exportarExcel(JTable t) throws IOException {
        FileDialog fileDialog = new FileDialog(new JFrame(), "Guardar archivo", FileDialog.SAVE);

        fileDialog.setFile("*.xls");
        fileDialog.setFilenameFilter((dir, name) -> name.endsWith(".xls"));
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String fileName = fileDialog.getFile();

        if (directory == null || fileName == null || fileName.trim().isEmpty()) {
            return;
        }

        String ruta = directory + fileName;
            String extension = "";
            if (ruta.endsWith(".xls")) {
                extension = ".xls";
            } else if (ruta.endsWith(".xlsx")) {
                extension = ".xlsx";
            } else {
                extension = ".xlsx";
                ruta += extension;
            }

        try {
             File archivoXLS = new File(ruta);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();

            Workbook libro;
            if (extension.equals(".xls")) {
                libro = new HSSFWorkbook();
            } else {
                libro = new XSSFWorkbook();
            }


            try ( FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
                Sheet hoja = libro.createSheet("Mi hoja de trabajo ");
                hoja.setDisplayGridlines(true);

                // Crear encabezados
                Row encabezado = hoja.createRow(0);
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = encabezado.createCell(c);
                    celda.setCellValue(t.getColumnName(c));
                }

                // Crear filas con datos
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f + 1);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        Object valor = t.getValueAt(f, c);
                        if (valor instanceof Number) {
                            celda.setCellValue(((Number) valor).doubleValue());
                        } else {
                            celda.setCellValue(valor.toString());
                        }
                    }
                }
//                Sheet hoja = libro.createSheet("Mi hoja de trabajo");
//                hoja.setDisplayGridlines(false);
//                for (int f = 0; f < t.getRowCount(); f++) {
//                    Row fila = hoja.createRow(f);
//                    for (int c = 0; c < t.getColumnCount(); c++) {
//                        Cell celda = fila.createCell(c);
//                        if (f == 0) {
//                            celda.setCellValue(t.getColumnName(c));
//                        }
//                    }
//                }

//                int filaInicio = 1;
//                for (int f = 0; f < t.getRowCount(); f++) {
//                    Row fila = hoja.createRow(filaInicio);
//                    filaInicio++;
//                    for (int c = 0; c < t.getColumnCount(); c++) {
//                        Cell celda = fila.createCell(c);
//                        if (t.getValueAt(f, c) instanceof Double) {
//                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
//                        } else if (t.getValueAt(f, c) instanceof Float) {
//                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
//                        } else {
//                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
//                        }
//                    }
//                }
//                for (int f = 0; f < t.getRowCount(); f++) {
//                    Row fila = hoja.createRow(f + 1);
//                    for (int c = 0; c < t.getColumnCount(); c++) {
//                        Cell celda = fila.createCell(c);
//                        Object valor = t.getValueAt(f, c);
//                        if (valor instanceof Number) {
//                            celda.setCellValue(((Number) valor).doubleValue());
//                        } else {
//                            celda.setCellValue(valor.toString());
//                        }
//                    }
//                }

                libro.write(archivo);
            }
            Desktop.getDesktop().open(archivoXLS);
        } catch (IOException | NumberFormatException e) {
            throw e;
        }
    }
}
