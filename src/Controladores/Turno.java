package Controladores;

import Modelo.Conexion;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

public class Turno {

    Conexion ocon = new Conexion();

      public void Turno(DefaultComboBoxModel combo2, String valor) {
        combo2.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    ocon.conectar();
                    CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_turno(?, 'SELECT')}");
                    cstmt.setString(1, valor);
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        publish(rs.getString(1)); // Publicar los resultados para procesar en el hilo de interfaz de usuario
                    }
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    if (ocon.con != null) {
                        try {
                            ocon.con.close();
                        } catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String turno : chunks) {
                    combo2.addElement(turno); // Actualizar el combo box en el hilo de interfaz de usuario
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }

    public void Turno_nom(DefaultComboBoxModel combo2, String valor) {
        combo2.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    ocon.conectar();
                    CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_turno(?, 'CAPTURA_PRO')}");
                    cstmt.setString(1, valor);
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        publish(rs.getString(1)); // Publicar los resultados para procesar en el hilo de interfaz de usuario
                    }
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    if (ocon.con != null) {
                        try {
                            ocon.con.close();
                        } catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String turno : chunks) {
                    combo2.addElement(turno); // Actualizar el combo box en el hilo de interfaz de usuario
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }

//    public String capturacod(String valor) {
//        SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
//            String datos = "";
//
//            @Override
//            protected String doInBackground() throws Exception {
//                try {
//                    ocon.conectar();
//                    CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_turno(?, 'CAPTURA')}");
//                    cstmt.setString(1, valor);
//                    ResultSet rs = cstmt.executeQuery();
//                    while (rs.next()) {
//                        datos = rs.getString(1);
//                    }
//                } catch (SQLException ex) {
//                    System.err.println(ex.getMessage());
//                } finally {
//                    if (ocon.con != null) {
//                        try {
//                            ocon.con.close();
//                        } catch (SQLException ex) {
//                            System.err.println(ex.getMessage());
//                        }
//                    }
//                }
//                return datos;
//            }
//        };
//
//        try {
//            return worker.get(); // Obtener el resultado de forma sincrónica
//        } catch (InterruptedException | ExecutionException ex) {
//            ex.printStackTrace();
//            return ""; // Manejar errores de ejecución
//        }
//    }
    public String capturacod(String valor) {
        ocon.conectar();
        String datos = "";
        try {
            CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_turno(?, 'CAPTURA')}");
            cstmt.setString(1, valor);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                datos = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("captura turno: "+ex.getMessage());
        }finally {
                if (ocon.con != null) {
                    try {
                        ocon.con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
        return datos;
    }  
}
