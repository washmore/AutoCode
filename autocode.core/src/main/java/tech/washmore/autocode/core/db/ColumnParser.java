package tech.washmore.autocode.core.db;

import tech.washmore.autocode.model.mysql.ColumnModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
        List<ColumnModel> columnModels = new ArrayList<ColumnModel>();
        while (rs.next()) {
            ColumnModel cm = new ColumnModel();
            cm.setColumnName(rs.getString("COLUMN_NAME"));
            cm.setComment(rs.getString("COLUMN_COMMENT"));
            cm.setDataType(rs.getString("DATA_TYPE").toUpperCase());
            cm.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
            cm.setPrimaryKey(rs.getString("COLUMN_KEY").equals("PRI"));

            cm.setFieldName(underline2Camel(cm.getColumnName(), false));
            cm.setFieldType(dataType2FieldType(cm.getDataType()));
            //todo FULLTYPE?

            columnModels.add(cm);
        }
        columnModels.sort(Comparator.comparing(ColumnModel::isPrimaryKey).reversed());
        return columnModels;
    }
}
