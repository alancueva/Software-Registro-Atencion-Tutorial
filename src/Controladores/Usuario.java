package Controladores;

import Modelo.Conexion;
import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

    Conexion ocon = new Conexion();


    public Map<String, String> inicio_sesion(String dni, String clave) {
        Map<String, String> usuario = new HashMap<>();

        try {
            ocon.conectar();
            CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_inicio_sesion(?,?)}");
            cstmt.setString(1, dni);
            cstmt.setString(2, clave);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                usuario.put("idusuario", rs.getString("idusuario"));  
                usuario.put("nombre", rs.getString("nombre"));
                usuario.put("apellido", rs.getString("apellido"));
                usuario.put("dni", rs.getString("dni"));
                usuario.put("correo", rs.getString("correo"));
                usuario.put("estado", rs.getString("estado"));
                usuario.put("rol", rs.getString("rol"));
                usuario.put("programa", rs.getString("programa"));
                usuario.put("turno", rs.getString("turno"));
                usuario.put("ciclo", rs.getString("ciclo"));
                usuario.put("estado_matricula", rs.getString("estado_matricula"));
            }
        } catch (SQLException ex) {
            System.err.println("Inicio de sesión: " + ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return usuario;
    }

    public boolean actualizar_usuario(String nom, String ape, String dni, String correo) {
        try {
            ocon.conectar();
            String sql = "Call sp_modificar_usuario(?, ?, ?,?)";
            CallableStatement cstmt = ocon.con.prepareCall(sql);
            cstmt.setString(1, nom);
            cstmt.setString(2, ape);
            cstmt.setString(3, dni);
            cstmt.setString(4, correo);
            cstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(" error actualizar_usuario: " + ex.getMessage());
            return false;
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

    public boolean verificar_dni(String dni) {
        try {
            ocon.conectar();
            CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_usuario(?,NULL,'verificar_dni')}");
            cstmt.setString(1, dni);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.err.println("verificar_dni: " + ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return false;
    }

    public boolean cambiarContraseñaDocente(String dni, String clave) {
        try {
            ocon.conectar();
            String sql = "{Call sp_usuario(?, ?, 'cambiarContraseñaDocente')}";
            CallableStatement cstmt = ocon.con.prepareCall(sql);
            cstmt.setString(1, dni);
            cstmt.setString(2, clave);
            cstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("cambiarContraseñaDocente: " + ex.getMessage());
            return false;
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

    public boolean verificarContraseñaAntigua(String dni, String clave) {
        try {
            ocon.conectar();
            CallableStatement cstmt = ocon.con.prepareCall("{CALL sp_usuario(?,?,'verificarContraseñaAntigua')}");
            cstmt.setString(1, dni);
            cstmt.setString(2, clave);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Si count es mayor a 0, la contraseña antigua es correcta
            }
        } catch (SQLException ex) {
            System.err.println("verificarContraseñaAntigua: " + ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return false;
    }

}
