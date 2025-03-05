/**
 *
 * @author Alan Cueva
 */
package Modelo;

public class Docentes_Detalle {
    /*
    * Modelo de Usuario Detalle
    *   
    */
    private int idusuario;
    private String idturno,idciclo;
    private String vigencia;

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getIdusuario() {
//        System.out.println("id " + idusuario);
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
//        System.out.println("id " + idusuario);
        this.idusuario = idusuario;
    }

    public String getIdturno() {
//        System.out.println("idturno " + idturno);
        return idturno;
    }

    public void setIdturno(String idturno) {
//        System.out.println("idturno " + idturno);
        this.idturno = idturno;
    }

    public String getIdciclo() {
//        System.out.println("idciclo " + idciclo);
        return idciclo;
    }

    public void setIdciclo(String idciclo) {
//        System.out.println("idciclo " + idciclo);
        this.idciclo = idciclo;
    }
}
