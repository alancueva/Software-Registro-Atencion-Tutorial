package Controladores;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public class Motivo {

    Conexion ocon = new Conexion();

    public void motivo1(DefaultComboBoxModel combo5, String valor) {
        combo5.addElement("Seleccionar");

        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                String sql;
                try {
                    ocon.conectar();
                    sql = "{CALL sp_motivo(?,NULL,NULL,'SELECT')}";

                    CallableStatement cstmt = ocon.con.prepareCall(sql);
                    cstmt.setString(1, valor);
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        publish(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    System.err.println("motivo: " + ex.getMessage());
                } finally {
                    if (ocon.con != null) {
                        try {
                            ocon.con.close();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String motivo : chunks) {
                    combo5.addElement(motivo);
                }
            }
        };

        worker.execute(); // Ejecutar el SwingWorker en segundo plano
    }

    public void mostrar(DefaultTableModel tabla, String valor) {
        String sql;
        try {
            ocon.conectar();
            sql = "{CALL sp_motivo(?,NULL,NULL,'SELECT')}";

            try ( CallableStatement callableStatement = ocon.con.prepareCall(sql)) {
                callableStatement.setString(1, valor);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[1];
                    datos[0] = rs.getString(1);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar: " + ex.getMessage());
        } finally {

            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void mostrarT(DefaultTableModel tabla, String valor) {
        String sql;
        try {
            ocon.conectar();
            sql = "{CALL sp_motivo(?,NULL,NULL,'MOSTRAR')}";

            try ( CallableStatement callableStatement = ocon.con.prepareCall(sql)) {
                callableStatement.setString(1, valor);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[2];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar: " + ex.getMessage());
        } finally {

            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public boolean guardar(String valor, String motivo) {
        String sql = "{CALL sp_motivo(?,NULL, ?, 'INSERT')}";

        ocon.conectar();
        try ( CallableStatement callableStatement = ocon.con.prepareCall(sql)) {
//            callableStatement.setString(1, valor);
            callableStatement.setString(1, valor);
            callableStatement.setString(2, motivo);
            callableStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar motivo: " + ex.getMessage());
            return false;
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

    public boolean actualizar(String valor, String valomomti, String motivo) {
        String sql = "{CALL sp_motivo(?,?, ?, 'UPDATE')}";

        ocon.conectar();
        try ( CallableStatement callableStatement = ocon.con.prepareCall(sql)) {
            callableStatement.setString(1, valor);
            callableStatement.setString(2, valomomti);
            callableStatement.setString(3, motivo);
            callableStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar motivo: " + ex.getMessage());
            return false;
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }
}
