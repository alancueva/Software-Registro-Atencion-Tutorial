/**
 *
 * @author Alan Cueva
 */
package Modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Conexion {

    private final String bd;
    private final String usuario;
    private final String clave;
    private final String url_;
    private final String url;
    public Connection con;

    public Conexion() {
        JSONParser parser = new JSONParser();
        try ( InputStream inputStream = getClass().getResourceAsStream("/resources/config.json");  InputStreamReader reader = new InputStreamReader(inputStream)) {
            JSONObject jsonConfig = (JSONObject) parser.parse(reader);
            bd = (String) jsonConfig.get("bd");
            usuario = (String) jsonConfig.get("usuario");
            clave = (String) jsonConfig.get("clave");
            url_ = (String) jsonConfig.get("url");
            url = "jdbc:mysql://"+url_+""+bd+"?noAccessToProcedureBodies=true";
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al leer el archivo de configuración JSON");
        }
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
