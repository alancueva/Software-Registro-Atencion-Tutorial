
package Controladores;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;

public class ControladorRolUsuario {
    
    private final Conexion conexion = new Conexion();
    
    
    public void Rol(DefaultComboBoxModel combo3) {
        combo3.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                conexion.conectar();
                try {
                    CallableStatement cstmt = conexion.con.prepareCall("CALL sp_rol_usuario(NULL,'select')");
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        publish(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    System.err.println("Rol: "+ex.getMessage());
                } finally {
                    if (conexion.con != null) {
                        try {
                            conexion.con.close();
                        } catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String rol : chunks) {
                    combo3.addElement(rol);
                }
            }
        };

        worker.execute();
    }
    
    public String capturacod(String valor) {
        conexion.conectar();
        String datos = "";
        try {
            CallableStatement cstmt = conexion.con.prepareCall("{CALL sp_rol_usuario(?,'captura')}");
            cstmt.setString(1, valor);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                datos = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println("captura rol"+ex.getMessage());
        }finally {
                if (conexion.con != null) {
                    try {
                        conexion.con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
        return datos;
    }         
}
