package Controladores;

import Modelo.Conexion;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuardarAlumno {

    private String nom, ape, idpro, pro, idtu, turno, idci, ci;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getIdpro() {
        return idpro;
    }

    public void setIdpro(String idpro) {
        this.idpro = idpro;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getIdtu() {
        return idtu;
    }

    public void setIdtu(String idtu) {
        this.idtu = idtu;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getIdci() {
        return idci;
    }

    public void setIdci(String idci) {
        this.idci = idci;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    private Statement stmt;//No getter and setter 
    private ResultSet rs;//No getter and setter 
    Conexion ocon = new Conexion();

    public void grabar() {
        int idalu = 0;
        try {
            ocon.conectar();
            String sql = "insert into alumnos values( '" + idalu + "','" + nom + "','" + idpro + "','" + pro + "','" + idtu + "','" + turno + "','" + idci + "','" + ci + "')";
            stmt = ocon.con.createStatement();
            stmt.execute(sql);
            ocon.con.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void mostrar(DefaultTableModel tabla) {
        String sql;
        ocon.conectar();
        try {
            sql = "select * from alumnos";
////            sql = "Select * from tabla";
            stmt = ocon.con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] datos3 = new String[7];
                datos3[0] = rs.getString(1);
                datos3[1] = rs.getString(2);
                datos3[2] = rs.getString(3);
                datos3[3] = rs.getString(4);
                datos3[4] = rs.getString(5);
                datos3[5] = rs.getString(6);
                datos3[6] = rs.getString(7);
                tabla.addRow(datos3);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
    
    public void mostraralu(DefaultListModel lista, String pro, String tur, String ci) {
        try {
            ocon.conectar();
            try ( CallableStatement callableStatement = ocon.con.prepareCall( "CALL sp_alumnos(?,?,?)")) {
                callableStatement.setString(1, pro);
                callableStatement.setString(2, tur);
                callableStatement.setString(3, ci);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String datos3 = rs.getString(1);
                    lista.addElement(datos3);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al mostrar Alumnos: " + ex.getMessage());
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
}
