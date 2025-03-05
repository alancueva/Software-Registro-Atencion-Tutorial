

import Vistas.Incio_sesion.InicioSesion;
import Vistas.Administracion.Administrador;
import Vistas.Administracion.BuscarDocente;
import Vistas.Administracion.GuardarAlumnos;
import Vistas.instrumento.Instrumento;

//import import
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ejecución {

    public static void main(String[] args) {
//        Instrumento ins = new Instrumento();
//        ins.setVisible(true);
          PantallaCarga pan = new PantallaCarga();
          pan.setVisible(true);
//        Administrador ad = new Administrador();
//        ad.setVisible(true);
/////////
//        InicioSesion in = new InicioSesion();
//        in.setVisible(true);
//        GuardarAlumnos g = new GuardarAlumnos();
//        g.setVisible(true);
//        Registro re = new Registro(parent, true);
//        re.setVisible(true);

//        BuscarDocente b = new BuscarDocente(null, true);
//        b.setVisible(true);



//LocalDateTime locaDate = LocalDateTime.now();
//int hours  = locaDate.getHour();
//int minutes = locaDate.getMinute();
//int seconds = locaDate.getSecond();
//System.out.println("Hora actual : " + hours  + ":"+ minutes +":"+seconds);

 DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
 Date date = new Date();
  System.out.println("Hora actual: " + dateFormat.format(date));
  
  
//   long millis = System.currentTimeMillis();
// int hours   = (int) ((millis / (1000*60*60)) % 24);
// int minutes = (int) ((millis / (1000*60)) % 60);
// int seconds = (int) (millis / 1000) % 60 ;
//
// System.out.println("Hora actual : " + hours + ":"+ minutes+":"+seconds);
 
 
//  long millis = System.currentTimeMillis();
//     System.out.println("Hora actual: " + String.format("%d min, %d sec",
//             TimeUnit.MILLISECONDS.toMinutes(millis),
//             TimeUnit.MILLISECONDS.toSeconds(millis) -
//                     TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
//     ));
    }

}
