package tech.washmore.autocode.core.db;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.enums.JdbcType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.dataType2FieldType;
import static tech.washmore.autocode.util.StringUtils.underline2Camel;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/12
 */
public class DataTableParser {
    public static List<ColumnModel> parseColumn(String dbname, String tableName) throws SQLException {
        String sql = "SELECT * FROM information_schema.columns  WHERE TABLE_SCHEMA=? AND table_name=?";
        PreparedStatement stat = ConnManager.getConn().prepareStatement(sql);
        stat.setString(1, dbname);
        stat.setString(2, tableName);
        ResultSet rs = stat.executeQuery();

        String sql2 = "SELECT * FROM " + tableName;
        PreparedStatement stat2 = ConnManager.getConn().prepareStatement(sql2);
        ResultSet rs2 = stat2.executeQuery();
        ResultSetMetaData data = rs2.getMetaData();

        int index = 0;
        List<ColumnModel> columnModels = new ArrayList<ColumnModel>();
        while (rs.next()) {
            index++;
            ColumnModel cm = new ColumnModel();
            cm.setColumnName(rs.getString("COLUMN_NAME"));
            cm.setComment(rs.getString("COLUMN_COMMENT"));
            cm.setDataType(rs.getString("DATA_TYPE").toUpperCase());
            cm.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
            cm.setPrimaryKey(rs.getString("COLUMN_KEY").equals("PRI"));
            cm.setOrder(rs.getInt("ORDINAL_POSITION"));
            cm.setFieldName(underline2Camel(cm.getColumnName(), false));
            String userType = dataType2FieldType(cm.getDataType());
            if (userType != null) {
                cm.setFieldType(userType);
            } else {
                cm.setFieldType(data.getColumnClassName(index));
            }
            cm.setJdbcType(JdbcType.forCode(data.getColumnType(index)).name());
            columnModels.add(cm);
        }
        Collections.sort(columnModels, new Comparator<ColumnModel>() {
            @Override
            public int compare(ColumnModel o1, ColumnModel o2) {
                if (o1.isPrimaryKey()) {
                    return -1;
                }
                return Integer.compare(o1.getOrder(), o2.getOrder());
            }
        });
        return columnModels;
    }

    private static TableModel parseTable(String dbname, String tableName) throws SQLException {
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
        tm.setColumns(parseColumn(dbname, tableName));

        List<ColumnModel> columnsWithoutPK = new ArrayList<>();
        for (ColumnModel cm : tm.getColumns()) {
            if (cm.isPrimaryKey()) {
                tm.setPrimaryKey(cm);
            } else {
                columnsWithoutPK.add(cm);
            }
        }
        tm.setColumnsWithoutPK(columnsWithoutPK);
        return tm;
    }

    private static List<String> allTables() {
        try {
            List<String> tablenames = new ArrayList<String>();
            String sql = "SHOW TABLES";
            PreparedStatement stat = ConnManager.getConn().prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                tablenames.add(rs.getString(1));
            }
            return tablenames;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<TableModel> finalTableModels() {
        List<String> tables = allTables();
        Config config = ConfigManager.getConfig();
        List<String> includes = config.getProject().getInclude();
        List<String> excludes = config.getProject().getExclude();

        if (includes != null && includes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (String t : tables) {
                if (includes.contains(t)) {
                    temp.add(t);
                }
            }
            tables = temp;
        } else if (excludes != null && excludes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (String t : tables) {
                if (!excludes.contains(t)) {
                    temp.add(t);
                }
            }
            tables = temp;
        }
        List<TableModel> tableModels = new ArrayList<>();
        for (String t : tables) {
            try {
                tableModels.add(parseTable(config.getDb().getDbName(), t));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return tableModels;
    }
}
