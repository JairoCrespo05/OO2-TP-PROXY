package org.example.ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionManager {
    private static String DRIVER = "com.mysql.jdbc.Driver"; //driver para mysql
    private static String URL_DB = "jdbc:mysql://localhost:3306/";// cadena de conexion
    protected static String DB = "oo2_tp_proxy";//nombre de la base de datos
    protected static String user = "root";
    protected static String pass = "";
    protected static Connection conn = null;// variable para conectarse
    protected static Properties propiedades = null;
    static String FALLO_OBTENCION_PROPIEDADES = "Ocurrio un error al obtener las propiedades";
    static String ERROR_AL_CONECTAR_DB = "Ocurrio un error al conectar con la base de datos";




    public static void connect() throws SQLException {
        try {

           // pasamos url, usuario y contraseña
            conn = DriverManager.getConnection(
                    URL_DB + DB, user, pass
            );

        } catch (SQLException sqlEx) {
            System.out.println("Error al cargar el driver");
            String mensajeError = "No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage();
            throw new SQLException(ERROR_AL_CONECTAR_DB);

        }
    }

    public static void disconnect()throws SQLException {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new SQLException(ERROR_AL_CONECTAR_DB);

            }
        }
    }

    public static void reconnect() throws SQLException {
        disconnect();
        connect();
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            connect();
        }
        return conn;
    }
}
