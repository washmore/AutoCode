package tech.washmore.autocode.core.generator.mysql;

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
public class MysqlAbstractServiceClassGenerator {

    public static void generateServices(List<TableModel> tableModels) {
        try {
            for (TableModel t : tableModels) {
                generateService(t);
                generateServiceExtends(t);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateServiceExtends(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Service service = dataFile.getService();
        Doc doc = config.getDoc();
        Project project = config.getProject();

        File dic = new File(project.getPath() + Constants.pathSplitor + project.getJavaRoot() + Constants.pathSplitor + service.getExtendsPackagePath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + service.getSuffix() + ".java");
        if (file.exists()) {
            return;
        }
        file.createNewFile();

        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(service.getExtendsPackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append("import org.springframework.stereotype.Service;").append(System.lineSeparator());
        sb.append("import ").append(service.getBasePackageName()).append(".").append(tm.getClsName() + service.getBaseSuffix()).append(";").append(System.lineSeparator());
        sb.append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ").append(service.getSummary() != null && service.getSummary().length() > 0 ? service.getSummary() : String.format(Constants.serviceSummaryTemplate, tm.getTbComment(), tm.getTbName())).append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        sb.append("@Service").append(System.lineSeparator());
        sb.append("public class ").append(tm.getClsName() + service.getSuffix()).append(" extends ")
                .append(tm.getClsName() + service.getBaseSuffix())
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

    private static void generateService(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Service service = dataFile.getService();
        Dao dao = dataFile.getDao();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        sb.append("package ").append(service.getBasePackageName()).append(";").append(System.lineSeparator()).append(System.lineSeparator());

        sb.append(System.lineSeparator()).append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ").append(service.getSummary() != null && service.getSummary().length() > 0 ? service.getSummary() : String.format(Constants.serviceSummaryTemplate, tm.getTbComment(), tm.getVirtualTbName())).append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        sb.append("public abstract class ").append(tm.getClsName() + service.getBaseSuffix()).append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        sb.append("\t@Resource").append(System.lineSeparator());
        sb.append("\tprotected ")
                .append(tm.getClsName() + dao.getSuffix()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(";")
                .append(System.lineSeparator()).append(System.lineSeparator());


        List<String> methods = dataFile.getMethodInclude();
        if (methods != null && methods.size() > 0) {
            for (String method : methods) {

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
                    case batchInsertSelective:
                        sb.append(appendBatchInsertSelective(tm));
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
                }

            }
        }

        sb.append("}");

        insertDependencies(sb, tm);

        File dic = new File(project.getPath() + Constants.pathSplitor + project.getJavaRoot() + Constants.pathSplitor + service.getBasePackagePath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + service.getBaseSuffix() + ".java");
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
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int countByParams(Map<String, Object> params) {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("countByParams(params);")
                .append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendCountByExample(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int countByExample(").append(tm.getClsName()).append(" example) {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("countByExample(example);")
                .append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByParams(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final List<").append(tm.getClsName()).append("> selectByParams(Map<String, Object> params) {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("selectByParams(params);")
                .append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByExample(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final List<").append(tm.getClsName()).append("> selectByExample(").append(tm.getClsName()).append(" example) {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("selectByExample(example);")
                .append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final ").append(tm.getClsName()).append(" selectByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("selectByPrimaryKey(")
                .append(pk.getFieldName())
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        DataFile dataFile = ConfigManager.getConfig().getDataFile();
        Dao dao = dataFile.getDao();
        Service service = dataFile.getService();
        StringBuffer sb = new StringBuffer();
        if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
            sb.append("\t@Transactional").append(System.lineSeparator());
            sb.append("\tpublic int batchUpdateByPrimaryKeySelective(List<")
                    .append(tm.getClsName()).append("> list) {")
                    .append(System.lineSeparator());
        } else {
            sb.append("\tpublic final int batchUpdateByPrimaryKeySelective(List<")
                    .append(tm.getClsName()).append("> list) {")
                    .append(System.lineSeparator());
        }
//        sb.append("\t\tif (list == null || list.size() == 0) {").append(System.lineSeparator());
//        sb.append("\t\t\treturn 0;").append(System.lineSeparator());
//        sb.append("\t\t}").append(System.lineSeparator());
        if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
            sb.append("\t\tif (list.size() > ").append(service.getBatchLimit()).append(") {").append(System.lineSeparator());
            sb.append("\t\t\tint result = 0;").append(System.lineSeparator());
            sb.append("\t\t\tfor (int i = 0; i < list.size(); i += ").append(service.getBatchLimit()).append(") {").append(System.lineSeparator());
            sb.append("\t\t\t\tresult += ")
                    .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".")
                    .append("batchUpdateByPrimaryKeySelective(list.subList(i, i + ").append(service.getBatchLimit())
                    .append(" > list.size() ? list.size() : i + ").append(service.getBatchLimit()).append("));")
                    .append(System.lineSeparator());
            sb.append("\t\t\t}").append(System.lineSeparator());
            sb.append("\t\t\treturn result;").append(System.lineSeparator());
            sb.append("\t\t}").append(System.lineSeparator());
        }
        sb.append("\t\treturn ")
                .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("batchUpdateByPrimaryKeySelective(list);").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendUpdateByPrimaryKeySelective(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int updateByPrimaryKeySelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("updateByPrimaryKeySelective(")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendUpdateByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int updateByPrimaryKey(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("updateByPrimaryKey(")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int batchDeleteByPrimaryKey(List<")
                .append(pk.getFieldType()).append("> list) {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("batchDeleteByPrimaryKey(list);").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int deleteByPrimaryKey(")
                .append(pk.getFieldType()).append(" ")
                .append(pk.getFieldName())
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("deleteByPrimaryKey(")
                .append(pk.getFieldName())
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchInsertSelective(TableModel tm) {
        DataFile dataFile = ConfigManager.getConfig().getDataFile();
        Dao dao = dataFile.getDao();
        Mapper mapper = dataFile.getMapper();
        StringBuffer sb = new StringBuffer();
        sb.append("\t@Transactional").append(System.lineSeparator());
        sb.append("\t@Deprecated").append(System.lineSeparator());
        sb.append("\tpublic int batchInsertSelective(List<")
                .append(tm.getClsName()).append("> list) {")
                .append(System.lineSeparator());
        sb.append("\t\tint result = 0;").append(System.lineSeparator());
        sb.append("\t\tfor (").append(tm.getClsName()).append(" item : list) {").append(System.lineSeparator());
        sb.append("\t\t\tresult += ")
                .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".")
                .append("insertSelective(item);")
                .append(System.lineSeparator());
        sb.append("\t\t}").append(System.lineSeparator());
        sb.append("\t\treturn result;").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendBatchInsert(TableModel tm) {
        DataFile dataFile = ConfigManager.getConfig().getDataFile();
        Dao dao = dataFile.getDao();
        Service service = dataFile.getService();
        StringBuffer sb = new StringBuffer();
        if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
            sb.append("\t@Transactional").append(System.lineSeparator());
            sb.append("\tpublic int batchInsert(List<")
                    .append(tm.getClsName()).append("> list) {")
                    .append(System.lineSeparator());
        } else {
            sb.append("\tpublic final int batchInsert(List<")
                    .append(tm.getClsName()).append("> list) {")
                    .append(System.lineSeparator());
        }
//        sb.append("\t\tif (list == null || list.size() == 0) {").append(System.lineSeparator());
//        sb.append("\t\t\treturn 0;").append(System.lineSeparator());
//        sb.append("\t\t}").append(System.lineSeparator());
        if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
            sb.append("\t\tif (list.size() > ").append(service.getBatchLimit()).append(") {").append(System.lineSeparator());
            sb.append("\t\t\tint result = 0;").append(System.lineSeparator());
            sb.append("\t\t\tfor (int i = 0; i < list.size(); i += ").append(service.getBatchLimit()).append(") {").append(System.lineSeparator());
            sb.append("\t\t\t\tresult += ")
                    .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".")
                    .append("batchInsert(list.subList(i, i + ").append(service.getBatchLimit())
                    .append(" > list.size() ? list.size() : i + ").append(service.getBatchLimit()).append("));")
                    .append(System.lineSeparator());
            sb.append("\t\t\t}").append(System.lineSeparator());
            sb.append("\t\t\treturn result;").append(System.lineSeparator());
            sb.append("\t\t}").append(System.lineSeparator());
        }
        sb.append("\t\treturn ")
                .append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix())
                .append(".").append("batchInsert(list);").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsertSelective(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int insertSelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("insertSelective(")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsert(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int insert(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getVirtualTbName(), false) + dao.getSuffix()).append(".").append("insert(")
                .append(underline2Camel(tm.getVirtualTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
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
                    if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
                        StringUtils.appendAtline3IfNotExist(source, "import org.springframework.transaction.annotation.Transactional;");
                    }
                    StringUtils.appendAtline3IfNotExist(source, "import java.util.List;");
                    StringUtils.appendAtline3IfNotExist(source, new StringBuffer().append("import ").append(model.getPackageName()).append(".").append(tm.getClsName()).append(";").toString());
                    break;
                case batchInsertSelective:
                    StringUtils.appendAtline3IfNotExist(source, "import org.springframework.transaction.annotation.Transactional;");
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
                    if (service.getBatchLimit() != null && service.getBatchLimit() > 0) {
                        StringUtils.appendAtline3IfNotExist(source, "import org.springframework.transaction.annotation.Transactional;");
                    }
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
