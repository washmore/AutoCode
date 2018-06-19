package tech.washmore.autocode.model.config;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private String dbName;
    private String driver;
    private String url;
    private String username;
    private String password;
    private List<String> tableNamePrefix = new ArrayList<>();

    public List<String> getTableNamePrefix() {
        return tableNamePrefix;
    }

    public void setTableNamePrefix(List<String> tableNamePrefix) {
        this.tableNamePrefix = tableNamePrefix;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
