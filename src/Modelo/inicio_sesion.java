/**
 *
 * @author Alan Cueva
 */
package Modelo;

import java.util.Map;

public class inicio_sesion {

    public static String idusuario;
    public static String nombre;
    public static String apellido;
    public static String dni;
    public static String rol;
    public static String correo;
    public static String estado;
    public static String programa;
    public static String turno;
    public static String ciclo;
    public static String estado_matricula;

    public static void setUserData(Map<String, String> usuario) {
        idusuario = usuario.get("idusuario");
        nombre = usuario.get("nombre");
        apellido = usuario.get("apellido");
        dni = usuario.get("dni");
        rol = usuario.get("rol");
        correo = usuario.get("correo");
        estado = usuario.get("estado");
        programa = usuario.get("programa");
        turno = usuario.get("turno");
        ciclo = usuario.get("ciclo");
        estado_matricula = usuario.get("estado_matricula");
    }
}
