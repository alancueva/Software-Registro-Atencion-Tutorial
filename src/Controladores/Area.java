
package Controladores;

import Modelo.Conexion;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

public class Area {

    private Statement stmt;
    private ResultSet rs; 
    Conexion ocon = new Conexion();

//    public void area(DefaultComboBoxModel combo4) {
////        combo4.addElement("Seleccionar");
////        String sql;
////        try {
////            ocon.conectar();
////            sql = "SELECT idArea,area FROM area;";
////            stmt = ocon.con.createStatement();
////            rs = stmt.executeQuery(sql);
////            while (rs.next()) {
////                combo4.addElement(rs.getString(2));
////            }
////        } catch (SQLException ex) {
////            JOptionPane.showMessageDialog(null, ex.getMessage());
////        }
//        combo4.addElement("Seleccionar");
//           try {
//               ocon.conectar();
//               // Llamada al procedimiento almacenado para obtener todas las áreas
//               String sql = "CALL sp_area(NULL, 'SELECT')";
//               stmt = ocon.con.createStatement();
//               rs = stmt.executeQuery(sql);
//               while (rs.next()) {
//                   combo4.addElement(rs.getString(2));
//               }
//           } catch (SQLException ex) {
//               System.err.println(ex.getMessage());
//           } finally {
//               // Asegurar cerrar la conexión después de su uso
//               if (ocon.con != null) {
//                   try {
//                       ocon.con.close();
//                   } catch (SQLException ex) {
//                       System.err.println(ex.getMessage());
//                   }
//               }
//           }
//    }

//    public String capturacod(String valor) {
//        ocon.conectar();
//        String datos = "";
//        try {
//            String sql = "select idarea from area where area = '" + valor + "'";
//            stmt = ocon.con.createStatement();
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                datos = rs.getString(1);
//            }
//            ocon.con.close();
//            stmt.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        return datos;
        
//        String datos = "";
//        try {
//            ocon.conectar();
//            // Llamada al procedimiento almacenado para capturar el idArea según el valor proporcionado
//            String sql = "CALL sp_area('?', 'CAPTURA')";
//            PreparedStatement pstmt = ocon.con.prepareStatement(sql);
//            pstmt.setString(1, valor);
////            stmt = ocon.con.createStatement();
//            rs = pstmt.executeQuery(sql);
//            while (rs.next()) {
//                datos = rs.getString(1);
//            }
//        } catch (SQLException ex) {
//            System.out.println( ex.getMessage());
//        } finally {
//            // Asegurarse de cerrar la conexión después de su uso
//            if (ocon.con != null) {
//                try {
//                    ocon.con.close();
//                } catch (SQLException ex) {
//                    System.err.println(ex.getMessage());
//                }
//            }
//        }
//        return datos;
//    }
    
    
    
    
    
    public void area(DefaultComboBoxModel combo4) {
        combo4.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    ocon.conectar();
                    String sql = "CALL sp_area(NULL,'SELECT')";
                    Statement stmt = ocon.con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        publish(rs.getString(2)); // Publicar los resultados para procesar en el hilo de interfaz de usuario
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
                for (String area : chunks) {
                    combo4.addElement(area); // Actualizar el combo box en el hilo de interfaz de usuario
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }
    
    public String capturacod(String valor) {
        String datos = "";
        try {
            ocon.conectar();
            String sql = "CALL sp_area(?,'CAPTURA')";
            CallableStatement cstmt = ocon.con.prepareCall(sql);
            cstmt.setString(1, valor);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                datos = rs.getString(1);
            }
        } catch (SQLException ex) {
                System.out.println("Captura de cod de area: "+ex.getMessage());
            } finally {
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
