
package Controladores;

import Modelo.Conexion;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

public class Atencion {
    Conexion ocon = new Conexion();
    
    public void atencion(DefaultComboBoxModel combo6) {
        combo6.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    ocon.conectar();
                    CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_atencion(NULL, 'SELECT')}");
                    ResultSet rs = cstmt.executeQuery();
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
                for (String atencion : chunks) {
                    combo6.addElement(atencion); // Actualizar el combo box en el hilo de interfaz de usuario
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }
    public String capturacod(String valor) {
        ocon.conectar();
        String datos = "";
        try {
            CallableStatement cstmt = ocon.con.prepareCall("CALL sp_atencion(?, 'CAPTURA')");
            cstmt.setString(1, valor);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                datos = rs.getString(1);
            }
//            ocon.con.close();
//            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
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
