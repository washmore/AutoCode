package tech.washmore.autocode.model.info;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/15
 */
public class ColumnDocInfo extends TableDocInfo {

    private String columnName;
    private String columnComment;
    private String defaultValue;
    private String fieldName;
    private String fieldType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
}
