package tech.washmore.autocode.core.generator.mysql;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.generator.base.AutoCodeFileWriter;
import tech.washmore.autocode.core.generator.base.DaoClassGenerator;
import tech.washmore.autocode.core.generator.base.JavaDocBasicAdapter;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.*;
import tech.washmore.autocode.model.enums.DataFileMethod;
import tech.washmore.autocode.model.enums.JavaDataType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;
import tech.washmore.autocode.util.StringUtils;

import java.io.IOException;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.underline2Camel;

/**
 * @author Washmore
 * @version V1.0
 * @summary 抽象的dao生成器//TODO 有待进一步封装,提供多种dao形式,另外将方法生成暴露给用户用于重写
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/11
 */
public abstract class MysqlAbstractDaoClassGenerator implements DaoClassGenerator {


    @Override
    public final void generateDaos(List<TableModel> tableModels) {
        try {
            for (TableModel t : tableModels) {
                generateDao(t);
                generateBaseDao(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void generateDao(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Doc doc = config.getDoc();
        Project project = config.getProject();

        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(dao.getExtendsPackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append("import ").append(dao.getBasePackageName()).append(".").append(tm.getClsName() + dao.getBaseSuffix()).append(";").append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(JavaDocBasicAdapter.generateDaoTypeDoc(tm));
        sb.append("public interface ").append(tm.getClsName() + dao.getSuffix()).append(" extends ")
                .append(tm.getClsName() + dao.getBaseSuffix())
                .append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        sb.append("}");

        AutoCodeFileWriter.writeStringToFile(project.getPath()
                        + Constants.pathSplitor
                        + project.getJavaRoot()
                        + Constants.pathSplitor
                        + dao.getExtendsPackagePath(),
                tm.getClsName() + dao.getSuffix() + ".java", sb.toString(), false
        );
    }

    private void generateBaseDao(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(dao.getBasePackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(JavaDocBasicAdapter.generateBaseDaoTypeDoc(tm));
        sb.append("public interface ").append(tm.getClsName() + dao.getBaseSuffix()).append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        List<String> methods = dataFile.getMethodInclude();
        if (methods != null && methods.size() > 0) {

            for (String method : methods) {
                boolean hasAppend = true;
                switch (DataFileMethod.valueOf(method)) {
                    case insert:
                        sb.append(appendInsert(tm));
                        break;
                    case insertSelective:
                        sb.append(appendInsertSelective(tm));
                        break;
                    case batchInsert:
                        sb.append(appendBatchInsert(tm));
                        break;
                    case deleteByPrimaryKey:
                        sb.append(appendDeleteByPrimaryKey(tm));
                        break;
                    case batchDeleteByPrimaryKey:
                        sb.append(appendBatchDeleteByPrimaryKey(tm));
                        break;
                    case updateByPrimaryKey:
                        sb.append(appendUpdateByPrimaryKey(tm));
                        break;
                    case updateByPrimaryKeySelective:
                        sb.append(appendUpdateByPrimaryKeySelective(tm));
                        break;
                    case batchUpdateByPrimaryKeySelective:
                        sb.append(appendBatchUpdateByPrimaryKeySelective(tm));
                        break;
                    case selectByPrimaryKey:
                        sb.append(appendSelectByPrimaryKey(tm));
                        break;
                    case selectByExample:
                        sb.append(appendSelectByExample(tm));
                        break;
                    case selectByParams:
                        sb.append(appendSelectByParams(tm));
                        break;
                    case countByExample:
                        sb.append(appendCountByExample(tm));
                        break;
                    case countByParams:
                        sb.append(appendCountByParams(tm));
                        break;
                    default:
                        hasAppend = false;
                        break;
                }
                if (hasAppend) {
                    sb.append(System.lineSeparator());
                }
            }
        }

        sb.append("}");

        insertDependencies(sb, tm);

        AutoCodeFileWriter.writeStringToFile(project.getPath()
                        + Constants.pathSplitor
                        + project.getJavaRoot()
                        + Constants.pathSplitor
                        + dao.getBasePackagePath(),
                tm.getClsName() + dao.getBaseSuffix() + ".java", sb.toString(), true
        );
    }


    public String appendCountByParams(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint countByParams(Map<String, Object> params);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendCountByExample(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint countByExample(").append(tm.getClsName()).append(" example);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendSelectByParams(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tList<").append(tm.getClsName()).append("> selectByParams(Map<String, Object> params);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendSelectByExample(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tList<").append(tm.getClsName()).append("> selectByExample(").append(tm.getClsName()).append(" example);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendSelectByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\t").append(tm.getClsName()).append(" selectByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint updateByPrimaryKeySelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendBatchUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint batchUpdateByPrimaryKeySelective(List<")
                .append(tm.getClsName()).append("> list);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendUpdateByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint updateByPrimaryKey(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendBatchDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint batchDeleteByPrimaryKey(List<")
                .append(pk.getFieldType()).append("> list);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint deleteByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendBatchInsert(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint batchInsert(List<")
                .append(tm.getClsName()).append("> list);")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendInsertSelective(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint insertSelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public String appendInsert(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint insert(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator());
        return sb.toString();
    }

    public void insertDependencies(StringBuffer source, TableModel tm) {
        Config config = ConfigManager.getConfig();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Service service = dataFile.getService();
        Model model = config.getModel();

        List<String> methods = dataFile.getMethodInclude();
        for (String m : methods) {
            if (m.toUpperCase().contains("PrimaryKey" .toUpperCase()) &&
                    tm.getPrimaryKey() != null && JavaDataType.时间.value.equals(tm.getPrimaryKey().getFieldType())) {
                StringUtils.appendAtline3IfNotExist(source, "import java.util.Date;");
            }
            switch (DataFileMethod.valueOf(m)) {
                case insert:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case insertSelective:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case batchInsert:
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case deleteByPrimaryKey:
                    break;
                case batchDeleteByPrimaryKey:
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    break;
                case updateByPrimaryKey:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case updateByPrimaryKeySelective:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case batchUpdateByPrimaryKeySelective:
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case selectByPrimaryKey:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case selectByExample:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    break;
                case selectByParams:
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.Map;");
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    break;
                case countByExample:
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case countByParams:
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.Map;");
                    break;
            }
        }
    }
}
