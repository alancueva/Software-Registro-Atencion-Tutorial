
package Controladores;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

public class Ciclo {

    Conexion ocon = new Conexion();

    public void ciclo(DefaultComboBoxModel combo3) {
        combo3.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                ocon.conectar();
                try {
                    CallableStatement cstmt = ocon.con.prepareCall("CALL sp_ciclo(NULL,'select')");
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        publish(rs.getString(1)); // Publicar los resultados para procesar en el hilo de interfaz de usuario
                    }
                } catch (SQLException ex) {
                    System.err.println("ciclo: "+ex.getMessage());
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
                for (String ciclo : chunks) {
                    combo3.addElement(ciclo); // Actualizar el combo box en el hilo de interfaz de usuario
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }
    
    
    public String capturacod(String valor) {
        ocon.conectar();
        String datos = "";
        try {
            CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_ciclo(?,'captura')}");
            cstmt.setString(1, valor);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                datos = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("captura ciclo"+ex.getMessage());
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
