package Controladores;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ControladorDocentes {

    Conexion conexion = new Conexion();

    public void mostrarUsuario(DefaultTableModel tabla) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_mostrar_usuario()";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[10];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    datos[8] = rs.getString(9);
                    datos[9] = rs.getString(10);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Usuario: " + ex.getMessage());
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

    public void BucarUsuario(DefaultTableModel tabla, String usuario) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_Buscar_Usuario(?)";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                callableStatement.setString(1, usuario);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[10];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    datos[8] = rs.getString(9);
                    datos[9] = rs.getString(10);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al Buscar Usuario: " + ex.getMessage());
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

    public void mostrarVentanaDocente(DefaultTableModel tabla) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_mostrar_usuario()";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[4];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(3);
                    datos[2] = rs.getString(4);
                    datos[3] = rs.getString(9);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Usuario: " + ex.getMessage());
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

    public void BucarVentanaDocente(DefaultTableModel tabla, String usuario) {
        String sql;
        try {
            conexion.conectar();
            sql = "CALL sp_Buscar_Usuario(?)";
            try ( CallableStatement callableStatement = conexion.con.prepareCall(sql)) {
                callableStatement.setString(1, usuario);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[4];
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(3);
                    datos[2] = rs.getString(4);
                    datos[3] = rs.getString(9);
                    tabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al Buscar Usuario: " + ex.getMessage());
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

    /*---REGISTRO--*/
    public boolean guardar_Usuario(Modelo.Docentes doc) {
        try {
            conexion.conectar();
            String sql = "{CALL sp_insert_usuario(?, ?, ?,?,?,?,?,?,?)}";
            CallableStatement callableStatement = conexion.con.prepareCall(sql);
            callableStatement.setString(1, doc.getDni());
            callableStatement.setString(2, doc.getNombre());
            callableStatement.setString(3, doc.getApellido());
            callableStatement.setString(4, doc.getCorreo());
            callableStatement.setString(5, doc.getClave());
            callableStatement.setString(6, doc.getEstado());
            callableStatement.setString(7, doc.getVigencia());
            callableStatement.setString(8, doc.getPrograma());
            callableStatement.setString(9, doc.getRol());
            callableStatement.executeUpdate();
            System.out.println("Registro insertado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.err.println("Hubo un error al insertar: " + ex.getMessage());
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
    
    public boolean Modificar_Usuario(Modelo.Docentes doc) {
        try {
            conexion.conectar();
            String sql = "{CALL sp_modf_usuario(?,?, ?, ?,?,?,?,?,?,?)}";
            CallableStatement callableStatement = conexion.con.prepareCall(sql);
            callableStatement.setInt(1, doc.getIdusuario());
            callableStatement.setString(2, doc.getDni());
            callableStatement.setString(3, doc.getNombre());
            callableStatement.setString(4, doc.getApellido());
            callableStatement.setString(5, doc.getCorreo());
            callableStatement.setString(6, doc.getClave());
            callableStatement.setString(7, doc.getEstado());
            callableStatement.setString(8, doc.getVigencia());
            callableStatement.setString(9, doc.getPrograma());
            callableStatement.setString(10, doc.getRol());
            callableStatement.executeUpdate();
            System.out.println("Modifico correctamente.");
            return true;
        } catch (SQLException ex) {
            System.err.println("Hubo un error al Modificar: " + ex.getMessage());
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

}
