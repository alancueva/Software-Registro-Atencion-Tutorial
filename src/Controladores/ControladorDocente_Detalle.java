package Controladores;

import Modelo.Conexion;
import Modelo.Docentes_Detalle;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorDocente_Detalle {

    private final Conexion conexion = new Conexion();

    public void mostrarUsuario_Detalle(DefaultTableModel tabla) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_usuario_detalle(NULL,NULL,NULL,NULL,NULL,'Select')";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[7];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);

                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Usuario Detalle: " + ex.getMessage());
        } finally {

            if (conexion.con != null) {
                try {
                    conexion.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void BucarUsuario_Detalle(DefaultTableModel tabla, String usuario) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_usuario_detalle(NULL,?,NULL,NULL,NULL,'Buscar')";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                callableStatement.setString(1, usuario);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[7];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al Buscar Usuario Detalle: " + ex.getMessage());
        } finally {

            if (conexion.con != null) {
                try {
                    conexion.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public boolean UsuarioDetalle_existe(int id_usu) {
        try {
            conexion.conectar();
            String sql = "{CALL sp_usuario_detalle(?, NULL,NULL,NULL,NULL,'USUARIO_EXISTE')}";
            CallableStatement callableStatement = conexion.con.prepareCall(sql);
            callableStatement.setInt(1, id_usu);
//            callableStatement.executeUpdate();
            try ( ResultSet rs = callableStatement.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Si count es mayor a 0 es true
                }
            }

            return false; // Si no hay resultado, también es false
        } catch (SQLException ex) {
            System.err.println("Hubo un error al insertar detalle: " + ex.getMessage());
            return false;
        } finally {
            if (conexion.con != null) {
                try {
                    conexion.con.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public boolean guardar_Usuario_Detalle(Modelo.Docentes_Detalle doc) {
        CallableStatement callableStatement = null;
        try {
            conexion.conectar();
            String sql = "{CALL sp_usuario_detalle(?,NULL, ?, ?,NULL, 'INSERT')}";
            callableStatement = conexion.con.prepareCall(sql);
            callableStatement.setInt(1, doc.getIdusuario());
            callableStatement.setString(2, doc.getIdturno());
            callableStatement.setString(3, doc.getIdciclo());
            callableStatement.executeUpdate();

            System.out.println("Registros insertados correctamente.");
            return true;
        } catch (SQLException ex) {
            System.err.println("Hubo un error al insertar detalle: " + ex.getMessage());
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                }
            }
            if (conexion.con != null) {
                try {
                    conexion.con.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

    public boolean Modificar_Usuario_Detalle(Modelo.Docentes_Detalle doc) {
        CallableStatement callableStatement = null;
        try {
            conexion.conectar();
            String sql = "{CALL sp_usuario_detalle(?,NULL, ?, ?,?,'UPDATE')}";
            callableStatement = conexion.con.prepareCall(sql);
            callableStatement.setInt(1, doc.getIdusuario());
            callableStatement.setString(2, doc.getIdturno());
            callableStatement.setString(3, doc.getIdciclo());
            callableStatement.setString(4, doc.getVigencia());

            callableStatement.executeUpdate();
            System.out.println("Registro modificado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.err.println("Hubo un error al modificar detalle: " + ex.getMessage());
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                }
            }
            if (conexion.con != null) {
                try {
                    conexion.con.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

}
