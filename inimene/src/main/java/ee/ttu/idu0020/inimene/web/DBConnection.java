package ee.ttu.idu0020.inimene.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DBConnection {
    
    private static final Logger log = Logger.getLogger(DBConnection.class);
    
    private static final ThreadLocal<Connection> currentConnection = new ThreadLocal<Connection>();
    
    public DBConnection() {
    }
    
    public static void initConnection() {
        currentConnection.set(createConnection());
    }
    
    public static void close() {
        Connection con = currentConnection.get();
        if(con != null) {
            try { con.close(); } catch (SQLException e) { 
                log.error(e);
            }
        }
    }
    
    public static Connection getConnection() {
        Connection con = currentConnection.get();
        if(con == null) {
            throw new IllegalStateException("No connection");
        }
        return con;
    }

    private static Connection createConnection() {
        Connection con = null;
        String str1 = "";
        String str2 = "";
        String str3 = "";
        try {
            ResourceBundle localResourceBundle = ResourceBundle.getBundle("DBConnection");
            Class.forName(localResourceBundle.getString("driver"));
            str3 = localResourceBundle.getString("url");
            str2 = localResourceBundle.getString("usr");
            str1 = localResourceBundle.getString("pwd");
            con = DriverManager.getConnection(str3, str2, str1);
        } catch (Throwable e) {
            log.error(e);
        }
        return con;
    }


}
