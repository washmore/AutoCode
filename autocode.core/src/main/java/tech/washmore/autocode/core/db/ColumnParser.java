package tech.washmore.autocode.core.db;

import tech.washmore.autocode.model.enums.JdbcType;
import tech.washmore.autocode.model.mysql.ColumnModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.dataType2FieldType;
import static tech.washmore.autocode.util.StringUtils.underline2Camel;

public class ColumnParser {
    public static List<ColumnModel> parse(String dbname, String tableName) throws SQLException {
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

        //columnModels.sort(Comparator.comparing(ColumnModel::isPrimaryKey).reversed().thenComparing(ColumnModel::getOrder));
        return columnModels;
    }
}
