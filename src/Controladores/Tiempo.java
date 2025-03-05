
package Controladores;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tiempo {

    Calendar fecha = new GregorianCalendar();
    SimpleDateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");

    public String getFecha(JDateChooser jd){
        if (jd.getDate()!= null) {
            return formato.format(jd.getDate());
        }else{
            return null;
        }
    }

    public String Tiempo() {
        String timestamp = ZonedDateTime.now(ZoneId.of("America/Lima")).format(DateTimeFormatter.ofPattern("dd MMM yyy"));
        return timestamp; 
    }
}
