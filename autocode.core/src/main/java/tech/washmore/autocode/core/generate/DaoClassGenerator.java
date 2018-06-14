package tech.washmore.autocode.core.generate;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.*;
import tech.washmore.autocode.model.enums.DataFileMethod;
import tech.washmore.autocode.model.enums.JavaDataType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;
import tech.washmore.autocode.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static tech.washmore.autocode.util.StringUtils.underline2Camel;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public class DaoClassGenerator {

    public static void generateDaos(List<TableModel> tableModels) {
        try {
            for (TableModel t : tableModels) {
                generateDao(t);
                generateDaoExtends(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateDaoExtends(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Doc doc = config.getDoc();
        Project project = config.getProject();

        File dic = new File(project.getPath() + Constants.pathSplitor + project.getJavaRoot() + Constants.pathSplitor + dao.getExtendsPackagePath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + dao.getSuffix() + ".java");
        if (file.exists()) {
            return;
        }
        file.createNewFile();

        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(dao.getExtendsPackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append("import ").append(dao.getBasePackageName()).append(".").append(tm.getClsName() + dao.getBaseSuffix()).append(";").append(System.lineSeparator());
        sb.append(System.lineSeparator()).append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ").append(dao.getSummary() != null && dao.getSummary().length() > 0 ? dao.getSummary() : String.format(Constants.daoSummaryTemplate, tm.getTbComment(), tm.getVirtualTbName())).append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        sb.append("public interface ").append(tm.getClsName() + dao.getSuffix()).append(" extends ")
                .append(tm.getClsName() + dao.getBaseSuffix())
                .append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        sb.append("}");

        OutputStream ops = new FileOutputStream(file);
        ops.write(sb.toString().getBytes());
        ops.flush();
        ops.close();
        System.out.println("\t输出文件:" + file.getPath().replace(new File(config.getProject().getPath()).getPath(), ""));
    }

    private static void generateDao(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(dao.getBasePackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append(System.lineSeparator()).append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ").append(dao.getSummary() != null && dao.getSummary().length() > 0 ? dao.getSummary() : String.format(Constants.daoSummaryTemplate, tm.getTbComment(), tm.getTbName())).append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        sb.append("public interface ").append(tm.getClsName() + dao.getBaseSuffix()).append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        List<String> methods = dataFile.getMethodInclude();
        if (methods != null && methods.size() > 0) {
            for (String method : methods) {
                try {
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
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        sb.append("}");

        insertDependencies(sb, tm);

        File dic = new File(project.getPath() + Constants.pathSplitor + project.getJavaRoot() + Constants.pathSplitor + dao.getBasePackagePath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + dao.getBaseSuffix() + ".java");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream ops = new FileOutputStream(file);
        ops.write(sb.toString().getBytes());
        ops.flush();
        ops.close();
        System.out.println("\t输出文件:" + file.getPath().replace(new File(config.getProject().getPath()).getPath(), ""));
    }


    private static String appendCountByParams(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint countByParams(Map<String, Object> params);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendCountByExample(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint countByExample(").append(tm.getClsName()).append(" example);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByParams(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tList<").append(tm.getClsName()).append("> selectByParams(Map<String, Object> params);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByExample(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tList<").append(tm.getClsName()).append("> selectByExample(").append(tm.getClsName()).append(" example);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\t").append(tm.getClsName()).append(" selectByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint updateByPrimaryKeySelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint batchUpdateByPrimaryKeySelective(List<")
                .append(tm.getClsName()).append("> list);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendUpdateByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint updateByPrimaryKey(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\tint deleteByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchInsert(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint batchInsert(List<")
                .append(tm.getClsName()).append("> list);")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsertSelective(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint insertSelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsert(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tint insert(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");")
                .append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static void insertDependencies(StringBuffer source, TableModel tm) {
        Config config = ConfigManager.getConfig();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Service service = dataFile.getService();
        Model model = config.getModel();

        StringUtils.appendAtline3IfNotExist(source, "import javax.annotation.Resource;");
        StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(dao.getExtendsPackageName()).append(".").append(tm.getClsName() + dao.getSuffix()).append(";").toString());
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
