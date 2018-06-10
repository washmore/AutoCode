package tech.washmore.autocode.model;

import java.util.List;

public class TableModel {
    private String tbName;
    private String clsName;
    private String tbComment;
    private List<ColumnModel> columns;

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
