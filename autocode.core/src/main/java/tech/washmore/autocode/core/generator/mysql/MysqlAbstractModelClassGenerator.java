package tech.washmore.autocode.core.generator.mysql;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.generator.base.AutoCodeFileWriter;
import tech.washmore.autocode.core.generator.base.JavaDocBasicAdapter;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.config.Doc;
import tech.washmore.autocode.model.config.Model;
import tech.washmore.autocode.model.config.Project;
import tech.washmore.autocode.model.enums.JavaDataType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static tech.washmore.autocode.util.StringUtils.underline2Camel;

/**
 * @author Washmore
 * @version V1.0
 * @summary 抽象的model生成器, 后续考虑将方法公有化便于用户重写
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public abstract class MysqlAbstractModelClassGenerator {

    public final void generateModels(List<TableModel> tableModels) {
        try {
            for (TableModel t : tableModels) {
                generateModel(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成Model文件
     *
     * @param tm
     * @throws IOException
     */
    private void generateModel(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        //添加包名
        sb.append("package ").append(modelConfig.getPackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        //引入依赖项
        sb.append("import java.io.Serializable;").append(System.lineSeparator());
        for (ColumnModel cm : tm.getColumns()) {
            if (cm.getFieldType().equals(JavaDataType.时间.value)) {
                sb.append("import java.util.Date;").append(System.lineSeparator());
                break;
            }
        }
        sb.append(System.lineSeparator());
        //添加类文件注释
        sb.append(JavaDocBasicAdapter.generateModelTypeDoc(tm));

        sb.append("public class ").append(tm.getClsName()).append(" implements Serializable ").append("{")
                .append(System.lineSeparator());
        //序列化id
        sb.append("\tprivate static final long serialVersionUID = ").append(new Random().nextLong()).append("L;")
                .append(System.lineSeparator());
        if (tm.getColumns() != null && tm.getColumns().size() > 0) {
            //属性列表
            sb.append(appendFields(tm));

            //重写toString方法
            sb.append(appendToString(tm));

            //getter,setter
            sb.append(appendGetterAndSetter(tm));
        }
        sb.append("}");

        AutoCodeFileWriter.writeStringToFile(
                project.getPath() + Constants.pathSplitor + project.getJavaRoot()
                        + Constants.pathSplitor + modelConfig.getPackagePath(),
                tm.getClsName() + ".java", sb.toString(), true
        );
    }

    private String appendFields(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        for (ColumnModel cm : tm.getColumns()) {
            sb.append("\t/**").append(System.lineSeparator());
            sb.append("\t * ");
            if (cm.getComment() != null && cm.getComment().length() > 0) {
                sb.append(cm.getComment()).append(" ");
            }
            sb.append("默认值:").append(cm.getDefaultValue())
                    .append(System.lineSeparator());
            sb.append("\t */").append(System.lineSeparator());
            sb.append("\t").append("private ").append(cm.getFieldType()).append(" ").append(cm.getFieldName())
                    .append(";").append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    private String appendGetterAndSetter(TableModel tm) {
        Model modelConfig = ConfigManager.getConfig().getModel();
        StringBuffer sb = new StringBuffer();
        for (ColumnModel cm : tm.getColumns()) {
            if (modelConfig.getVisitorWithDoc()) {
                sb.append("\t/**").append(System.lineSeparator());
                sb.append("\t * ").append(cm.getComment()).append(" 默认值:").append(cm.getDefaultValue())
                        .append(System.lineSeparator());
                sb.append("\t */").append(System.lineSeparator());
            }
            sb.append("\t").append("public void set").append(underline2Camel(cm.getColumnName(), true)).append("(")
                    .append(cm.getFieldType()).append(" ").append(cm.getFieldName()).append(") {")
                    .append(System.lineSeparator());
            sb.append("\t\t").append("this.").append(cm.getFieldName()).append(" = ").append(cm.getFieldName())
                    .append(";").append(System.lineSeparator());
            sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());

            if (modelConfig.getVisitorWithDoc()) {
                sb.append("\t/**").append(System.lineSeparator());
                sb.append("\t * ").append(cm.getComment()).append(" 默认值:").append(cm.getDefaultValue())
                        .append(System.lineSeparator());
                sb.append("\t */").append(System.lineSeparator());
            }
            sb.append("\t").append("public ").append(cm.getFieldType()).append(" get")
                    .append(underline2Camel(cm.getColumnName(), true)).append("() {").append(System.lineSeparator());
            sb.append("\t\t").append("return this.").append(cm.getFieldName()).append(";")
                    .append(System.lineSeparator());
            sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());

        }
        return sb.toString();
    }

    private String appendToString(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        Model modelConfig = ConfigManager.getConfig().getModel();
        if (!modelConfig.getToString()) {
            return "";
        }
        sb.append("\t@Override").append(System.lineSeparator());
        sb.append("\tpublic String toString() {").append(System.lineSeparator());
        sb.append("\t\treturn \"").append(tm.getClsName()).append("{\" +").append(System.lineSeparator());
        for (int i = 0; i < tm.getColumns().size(); i++) {
            ColumnModel cm = tm.getColumns().get(i);
            sb.append("\t\t\t\t\"");
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(tm.getColumns().get(i).getFieldName()).append("=");
            if (JavaDataType.字符串.value.equals(cm.getFieldType())) {
                sb.append("\\'");
            }
            sb.append("\" + ").append(cm.getFieldName()).append(" +");
            if (JavaDataType.字符串.value.equals(cm.getFieldType())) {
                sb.append(" \"\\'\" +");
            }
            sb.append(System.lineSeparator());

        }
        sb.append("\t\t\t\t\"}\";").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator());
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
