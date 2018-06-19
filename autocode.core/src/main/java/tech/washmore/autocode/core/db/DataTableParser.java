package tech.washmore.autocode.core.db;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.config.Db;
import tech.washmore.autocode.model.enums.JdbcType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.dataType2FieldType;
import static tech.washmore.autocode.util.StringUtils.underline2Camel;

/**
 * @author Washmore
 * @version V1.0
 * @summary 解析数据库表和列
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/12
 */
public class DataTableParser {
    public static List<ColumnModel> parseColumn(String dbname, String tableName) throws SQLException {
        String sql = "SELECT * FROM information_schema.columns  WHERE TABLE_SCHEMA=? AND table_name=?";

        Connection c = ConnManager.getConn();
        PreparedStatement stat = c.prepareStatement(sql);
        stat.setString(1, dbname);
        stat.setString(2, tableName);
        ResultSet rs = stat.executeQuery();

        String sql2 = "SELECT * FROM " + tableName;
        Connection c2 = ConnManager.getConn();
        PreparedStatement stat2 = c2.prepareStatement(sql2);
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
            cm.setFieldTypeFullName(data.getColumnClassName(index));
            cm.setJdbcType(JdbcType.forCode(data.getColumnType(index)).name());
            columnModels.add(cm);
        }
        c.close();
        c2.close();
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

    private static TableModel parseTable(String dbname, String tableName, List<String> existClsNames) throws SQLException {
        System.out.println("当前解析:" + tableName);
        Db db = ConfigManager.getConfig().getDb();
        String sql = "SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA=? AND table_name=?";
        Connection c = ConnManager.getConn();
        PreparedStatement stat = c.prepareStatement(sql);
        stat.setString(1, dbname);
        stat.setString(2, tableName);
        TableModel tm = new TableModel();
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            tm.setTbName(rs.getString("TABLE_NAME"));
            tm.setTbComment(rs.getString("TABLE_COMMENT"));
            boolean hasTableNamePrefix = false;
            if (db.getTableNamePrefix() != null && db.getTableNamePrefix().size() > 0) {
                for (String s : db.getTableNamePrefix()) {
                    if (tm.getTbName().startsWith(s)) {
                        String virtualTbName = tm.getTbName().substring(s.length());
                        String camel = underline2Camel(virtualTbName, true);
                        while (existClsNames.contains(camel.toUpperCase())) {
                            virtualTbName = virtualTbName + "_copy";
                            camel = underline2Camel(virtualTbName, true);
                        }
                        if (camel.matches("[a-zA-Z_$][a-zA-Z0-9_$]*")) {
                            tm.setClsName(camel);
                            tm.setVirtualTbName(virtualTbName);
                            existClsNames.add(camel.toUpperCase());
                            hasTableNamePrefix = true;
                            break;
                        }
                    }
                }
            }

            if (!hasTableNamePrefix) {
                String virtualTbName = tm.getTbName();
                String camel = underline2Camel(virtualTbName, true);
                while (existClsNames.contains(camel.toUpperCase())) {
                    virtualTbName = virtualTbName + "_copy";
                    camel = underline2Camel(virtualTbName, true);
                }
                tm.setClsName(camel);
                tm.setVirtualTbName(virtualTbName);
                existClsNames.add(camel.toUpperCase());
            }
        }
        c.close();
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
            Connection c = ConnManager.getConn();
            PreparedStatement stat = c.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                tablenames.add(rs.getString(1));
            }
            c.close();
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
        List<String> existClsNames = new ArrayList<>();
        for (String t : tables) {
            try {
                tableModels.add(parseTable(config.getDb().getDbName(), t, existClsNames));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return tableModels;
    }
}
