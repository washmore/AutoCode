package tech.washmore.autocode.core.generator.factory;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.Dao;
import tech.washmore.autocode.model.info.ColumnDocInfo;
import tech.washmore.autocode.model.info.MethodDocInfo;
import tech.washmore.autocode.model.info.TableDocInfo;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

/**
 * @author Washmore
 * @version V1.0
 * @summary 用于将数据库原始信息转化为仅包含javadoc需要的信息实体
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/15
 */
public class DocInfoFactory {

    public static TableDocInfo createTableInfo(TableModel tm) {
        TableDocInfo tableInfo = new TableDocInfo();
        fillTableInfo(tableInfo, tm);
        return tableInfo;
    }

    private static void fillTableInfo(TableDocInfo tableInfo, TableModel tm) {
        tableInfo.setTableName(tm.getTbName());
        tableInfo.setTableComment(tm.getTbComment());
        tableInfo.setModelClassName(tm.getClsName());

        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        tableInfo.setBaseDaoClassName(tm.getClsName() + dao.getBaseSuffix());
        tableInfo.setDaoClassName(tm.getClsName() + dao.getSuffix());
    }

    public static ColumnDocInfo createColumnInfo(TableModel tm, ColumnModel cm) {
        ColumnDocInfo columnInfo = new ColumnDocInfo();
        fillTableInfo(columnInfo, tm);
        columnInfo.setColumnName(cm.getColumnName());
        columnInfo.setColumnComment(cm.getComment());
        columnInfo.setDefaultValue(cm.getDefaultValue());
        columnInfo.setFieldName(cm.getFieldName());
        columnInfo.setFieldType(cm.getFieldType());
        return columnInfo;
    }

    public static MethodDocInfo createMethodInfo(TableModel tm) {
        MethodDocInfo methodInfo = new MethodDocInfo();
        fillTableInfo(methodInfo, tm);
        return methodInfo;
    }
}
