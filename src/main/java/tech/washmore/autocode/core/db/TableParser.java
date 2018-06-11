package tech.washmore.autocode.core.db;

import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.underline2Camel;

public class TableParser {
    public static TableModel parse(String dbname, String tableName) throws SQLException {
        String sql = "SELECT * FROM information_schema.tables  WHERE TABLE_SCHEMA=? AND table_name=?";
        PreparedStatement stat = ConnManager.getConn().prepareStatement(sql);
        stat.setString(1, dbname);
        stat.setString(2, tableName);
        TableModel tm = new TableModel();

        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            tm.setTbName(rs.getString("TABLE_NAME"));
            tm.setTbComment(rs.getString("TABLE_COMMENT"));
            tm.setClsName(underline2Camel(tm.getTbName(), true));
        }
        tm.setColumns(ColumnParser.parse(dbname, tableName));
        tm.setPrimaryKey(tm.getColumns().stream().filter(ColumnModel::isPrimaryKey).findFirst().orElse(null));
        return tm;
    }

    public static List<String> allTables() throws SQLException {
        List<String> tablenames = new ArrayList<String>();
        String sql = "SHOW TABLES";
        PreparedStatement stat = ConnManager.getConn().prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        while (rs.next()) {
            tablenames.add(rs.getString(1));
        }
        return tablenames;
    }
}
