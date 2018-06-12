package tech.washmore.autocode.model.mysql;

import java.util.List;

public class TableModel {
    private String tbName;
    private String clsName;
    private String tbComment;
    private List<ColumnModel> columns;
    private List<ColumnModel> columnsWithoutPK;


    private ColumnModel primaryKey;

    public List<ColumnModel> getColumnsWithoutPK() {
        return columnsWithoutPK;
    }

    public void setColumnsWithoutPK(List<ColumnModel> columnsWithoutPK) {
        this.columnsWithoutPK = columnsWithoutPK;
    }
    public ColumnModel getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnModel primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getTbComment() {
        return tbComment;
    }

    public void setTbComment(String tbComment) {
        this.tbComment = tbComment;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }
}
