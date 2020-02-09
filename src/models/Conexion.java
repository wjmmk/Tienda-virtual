
package models;

/**
 * Version: 1.0
 * Fecha: 09/02/2020
 * @author: Wiliam Mosquera 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class Conexion {
    private String username = "root";
    private String password = "";
    private String hostname = "localhost";
    private String port = "3306";
    private String database = "carritojsp";
    private String classname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
    private Connection conn;

    private static final Logger LOGGER = Logger.getLogger(Conexion.class);

    public Conexion() {
        try {
            Class.forName(classname);
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        	LOGGER.log(Level.ERROR, "Error de conexion"+e);
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
}
