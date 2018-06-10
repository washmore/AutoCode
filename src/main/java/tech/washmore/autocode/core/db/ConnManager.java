package tech.washmore.autocode.core.db;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.config.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
    private static Db db;

    static {
        try {
            db = ConfigManager.getConfig().getDb();
            Class.forName(db.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            return DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
