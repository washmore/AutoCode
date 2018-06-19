package tech.washmore.autocode.model.info;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/15
 */
public class TableDocInfo {
    private String tableName;
    private String tableComment;
    private String modelClassName;
    private String daoClassName;
    private String baseDaoClassName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getModelClassName() {
        return modelClassName;
    }

    public void setModelClassName(String modelClassName) {
        this.modelClassName = modelClassName;
    }

    public String getDaoClassName() {
        return daoClassName;
    }

    public void setDaoClassName(String daoClassName) {
        this.daoClassName = daoClassName;
    }

    public String getBaseDaoClassName() {
        return baseDaoClassName;
    }

    public void setBaseDaoClassName(String baseDaoClassName) {
        this.baseDaoClassName = baseDaoClassName;
    }
}
