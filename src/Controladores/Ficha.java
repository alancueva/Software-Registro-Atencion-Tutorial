package Controladores;

import Modelo.Conexion;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Ficha {

    Conexion ocon = new Conexion();

    public boolean guardar(List<Modelo.Instrumento> instrumentos) {
        CallableStatement callableStatement = null;
        try {
            ocon.conectar();
            String sql = "CALL sp_guardar_tabla(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            callableStatement = ocon.con.prepareCall(sql);
            for (Modelo.Instrumento ins : instrumentos) {
                callableStatement.setString(1, ins.getNom());
                callableStatement.setString(2, ins.getIdarea());
                callableStatement.setString(3, ins.getArea());
                callableStatement.setString(4, ins.getMotivo());
                callableStatement.setString(5, ins.getOsb());
                callableStatement.setString(6, ins.getFecha());
                callableStatement.setString(7, ins.getIdAtencion());
                callableStatement.setString(8, ins.getAtencion());
                callableStatement.setString(9, ins.getPe());
                callableStatement.setString(10, ins.getTurno());
                callableStatement.setString(11, ins.getCiclo());
                callableStatement.setString(12, ins.getTutor());
                callableStatement.setInt(13, ins.getIdusu());
                callableStatement.addBatch(); // Agregar la llamada al procedimiento a un lote
            }
            callableStatement.executeBatch(); // Ejecutar todas las llamadas al procedimiento en el lote
            return true;
        } catch (SQLException ex) {
            System.err.println("Hubo un error al insertar: " + ex.getMessage());
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                }
            }
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                    System.out.println("Conexion cerrada");
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void mostrar(DefaultTableModel tabla, int id, int conteoLista)  {
        try {
            ocon.conectar();
             String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try {
                callableStatement.setNull(1, java.sql.Types.NULL);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setNull(3, java.sql.Types.NULL);
                callableStatement.setInt(4, conteoLista);
                callableStatement.setNull(5, java.sql.Types.NULL);
                callableStatement.setInt(6, id);
                callableStatement.setString(7, "mostrar");

                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[10];
                    datos[0] = rs.getString("nom_ape");
                    datos[1] = rs.getString("area");
                    datos[2] = rs.getString("motivo");
                    datos[3] = rs.getString("osb");
                    datos[4] = rs.getString("fecha");
                    datos[5] = rs.getString("atencion");
                    datos[6] = rs.getString("programa");
                    datos[7] = rs.getString("turno");
                    datos[8] = rs.getString("ciclo");
                    datos[9] = rs.getString("tutor");
                    tabla.addRow(datos);
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar ficha: " + ex.getMessage());
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

    public void mostrarHistorial(DefaultTableModel tabla, int id) {

        try {
            ocon.conectar();
             String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try {
                callableStatement.setNull(1, java.sql.Types.NULL);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setNull(3, java.sql.Types.NULL);
                callableStatement.setNull(4, java.sql.Types.NULL);
                callableStatement.setNull(5, java.sql.Types.NULL);
                callableStatement.setInt(6, id);
                callableStatement.setString(7, "mostrar_Historial");

                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String[] datos = new String[7];
                    datos[0] = rs.getString("nom_ape");
                    datos[1] = rs.getString("area");
                    datos[2] = rs.getString("motivo");
                    datos[3] = rs.getString("osb");
                    datos[4] = rs.getString("fecha");
                    datos[5] = rs.getString("atencion");
                    datos[6] = rs.getString("fecha_Registro");
                    tabla.addRow(datos);
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar ficha Historial: " + ex.getMessage());
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
    //Reporte Mensual
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public String getFecha1(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public String getFecha2(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public String getMes(JMonthChooser jm) {
        if (jm.getMonth() != -1) {
            return String.valueOf(jm.getMonth() + 1);
        } else {
            return null;
        }

    }

    private String[] nombresMeses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public int getNumeroMes(String nombreMes) {
        for (int i = 0; i < nombresMeses.length; i++) {
            if (nombresMeses[i].equals(nombreMes)) {
                return i + 1; // Los meses en el array empiezan desde 0, así que sumamos 1
            }
        }
        return -1; // Si el nombre del mes no es encontrado, retornar -1
    }

    public String[] getNombresMeses() {
        return nombresMeses;
    }

    public String getNombreMes(JMonthChooser jm) {
        int numeroMes = jm.getMonth() + 1;
        String[] nombresdMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        if (numeroMes >= 1 && numeroMes <= nombresdMeses.length) {
            return nombresdMeses[numeroMes - 1];
        } else {
            return null;
        }
    }

    public boolean mostrarporfecha(DefaultTableModel tabla, String are, String prog, String mes) {
        /*
        * 1- area
        * 2- programa 
        * 3- mes
         */
         String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
        boolean hasResults = false;
        try {
            ocon.conectar();
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try {
                callableStatement.setString(1, are);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setString(3, prog);               
                callableStatement.setNull(4, java.sql.Types.NULL);
                callableStatement.setString(5, mes);
                callableStatement.setNull(6, java.sql.Types.NULL);
                callableStatement.setString(7, "MOSTRAR_FECHA");
                ResultSet rs = callableStatement.executeQuery();

                if (rs.isBeforeFirst()) {
                    hasResults = true;
                    while (rs.next()) {
                        String[] datos = new String[11];
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
                        datos[10] = rs.getString(11);

                        tabla.addRow(datos);
                    }
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en mostrar por fecha: " + ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return hasResults;
    }

    public boolean mostrarporfechaMensual(DefaultTableModel tabla, int mes) {
        /*
        *  mes
         */
         String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
        boolean hasResults = false;
        try {
            ocon.conectar();
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try {
                callableStatement.setNull(1, java.sql.Types.NULL);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setNull(3, java.sql.Types.NULL);
                callableStatement.setNull(4, java.sql.Types.NULL);
                callableStatement.setInt(5, mes);
                callableStatement.setNull(6, java.sql.Types.NULL);
                callableStatement.setString(7, "MOSTRAR_FECHA_MENSUAL");

                ResultSet rs = callableStatement.executeQuery();

                if (rs.isBeforeFirst()) {
                    hasResults = true;
                    while (rs.next()) {
                        String[] datos = new String[11];
                        for (int i = 0; i < 11; i++) {
                            datos[i] = rs.getString(i + 1);
                        }
                        tabla.addRow(datos);
                    }
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en mostrar por fecha: " + ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return hasResults;
    }

    public void numeroporc(DefaultTableModel tabla){
         String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
        try {
            ocon.conectar();
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try{
                callableStatement.setNull(1, java.sql.Types.NULL);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setNull(3, java.sql.Types.NULL);
                callableStatement.setNull(4, java.sql.Types.NULL);
                callableStatement.setNull(5, java.sql.Types.NULL);
                callableStatement.setNull(6, java.sql.Types.NULL);
                callableStatement.setString(7, "NUMERO_PORCENTAJE");
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String area_ta = rs.getString("area");
                    int registros = rs.getInt("registros");
                    int total = rs.getInt("total_registros");
                    double por = rs.getDouble("porcentaje");
                    Object[] datos = {area_ta, registros, total, por};
                    tabla.addRow(datos);
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Numero Porcentaje: "+ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void docenteregistro(DefaultTableModel tabla) {
         String sql = "CALL sp_tabla(?, ?, ?, ?, ?, ?, ?)";
        try {
            ocon.conectar();
            CallableStatement callableStatement = ocon.con.prepareCall(sql);
            try {           
                callableStatement.setNull(1, java.sql.Types.NULL);
                callableStatement.setNull(2, java.sql.Types.NULL);
                callableStatement.setNull(3, java.sql.Types.NULL);
                callableStatement.setNull(4, java.sql.Types.NULL);
                callableStatement.setNull(5, java.sql.Types.NULL);
                callableStatement.setNull(6, java.sql.Types.NULL);
                callableStatement.setString(7, "DOCENTE_REGISTRADO");
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String doc = rs.getString(1);
                    int registros = rs.getInt(2);
                    int sesion = rs.getInt(3);
                    Object[] datos = {doc, registros, sesion};
                    tabla.addRow(datos);
                }
            } finally {
                if (callableStatement != null) {
                    try {
                        callableStatement.close();
                    } catch (SQLException ex) {
                        System.err.println("Error al cerrar CallableStatement: " + ex.getMessage());
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (ocon.con != null) {
                try {
                    ocon.con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
