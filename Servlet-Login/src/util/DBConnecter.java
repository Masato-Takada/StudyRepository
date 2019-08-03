/************************
 * DBコネクションクラス.
 *
 * @author m-takada
 ************************/
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
    private static String driverName = "com.mysql.jdbc.Driver";
    // private static String url = "jdbc:mysql://192.168.3.1:3306/m-takada";
    private static String url = "jdbc:mysql://192.168.80.60:3306/m-takada";

    private static String user = "m-takada";
    private static String password = "m-takada";

    /**********************
     * DBコネクション処理.
     **********************/
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName(driverName);
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
