package tech.washmore.autocode.core.generate;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.*;
import tech.washmore.autocode.model.enums.DataFileMethod;
import tech.washmore.autocode.model.enums.JavaDataType;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

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
public class ServiceClassGenerator {

    public static void generateServices(List<TableModel> tableModels) {
        try {
            Thread.sleep(2000);
            for (TableModel t : tableModels) {
                Thread.sleep((long) (Math.random() * 10));
                generateService(t);
                Thread.sleep((long) (Math.random() * 10));
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
        if (tm.getPrimaryKey() != null && JavaDataType.时间.value.equals(tm.getPrimaryKey().getFieldType())) {
            sb.append("import java.util.Date;").append(System.lineSeparator());
        }

        sb.append("import ").append(dao.getExtendsPackageName()).append(".").append(tm.getClsName() + dao.getSuffix()).append(";").append(System.lineSeparator());
        sb.append("import ").append(modelConfig.getPackageName()).append(".").append(tm.getClsName()).append(";").append(System.lineSeparator());
        sb.append("import javax.annotation.Resource;").append(System.lineSeparator());
        sb.append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ").append(service.getSummary() != null && service.getSummary().length() > 0 ? service.getSummary() : String.format(Constants.serviceSummaryTemplate, tm.getTbComment(), tm.getTbName())).append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        sb.append("public abstract class ").append(tm.getClsName() + service.getBaseSuffix()).append(" {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        sb.append("\t@Resource").append(System.lineSeparator());
        sb.append("\tprotected ")
                .append(tm.getClsName() + dao.getSuffix()).append(" ")
                .append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(";")
                .append(System.lineSeparator()).append(System.lineSeparator());


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
                        case deleteByPrimaryKey:
                            sb.append(appendDeleteByPrimaryKey(tm));
                            break;
                        case updateByPrimaryKey:
                            sb.append(appendUpdateByPrimaryKey(tm));
                            break;
                        case updateByPrimaryKeySelective:
                            sb.append(appendUpdateByPrimaryKeySelective(tm));
                            break;
                        case selectByPrimaryKey:
                            sb.append(appendSelectByPrimaryKey(tm));
                            break;
                        case selectByExample:
                            sb.append(appendSelectByExample(tm));
                            if (sb.indexOf("import java.util.Map;") == -1) {
                                sb.insert(sb.lastIndexOf("import "), "import java.util.Map;" + System.lineSeparator());
                            }
                            if (sb.indexOf("import java.util.List;") == -1) {
                                sb.insert(sb.lastIndexOf("import "), "import java.util.List;" + System.lineSeparator());
                            }
                            break;
                        case selectByParams:
                            sb.append(appendSelectByParams(tm));
                            if (sb.indexOf("import java.util.Map;") == -1) {
                                sb.insert(sb.lastIndexOf("import "), "import java.util.Map;" + System.lineSeparator());
                            }
                            if (sb.indexOf("import java.util.List;") == -1) {
                                sb.insert(sb.lastIndexOf("import "), "import java.util.List;" + System.lineSeparator());
                            }
                            break;
                        case countByExample:
                            sb.append(appendCountByExample(tm));
                            break;
                        case countByParams:
                            sb.append(appendCountByParams(tm));
                            if (sb.indexOf("import java.util.Map;") == -1) {
                                sb.insert(sb.lastIndexOf("import "), "import java.util.Map;" + System.lineSeparator());
                            }
                            break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        sb.append("}");
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix())
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix())
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix())
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix())
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("selectByPrimaryKey(")
                .append(pk.getFieldName())
                .append(");").append(System.lineSeparator());
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
                .append(underline2Camel(tm.getTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("updateByPrimaryKeySelective(")
                .append(underline2Camel(tm.getTbName(), false))
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
                .append(underline2Camel(tm.getTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("updateByPrimaryKey(")
                .append(underline2Camel(tm.getTbName(), false))
                .append(");").append(System.lineSeparator());
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
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("deleteByPrimaryKey(")
                .append(pk.getFieldName())
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsertSelective(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int insertSelective(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("insertSelective(")
                .append(underline2Camel(tm.getTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsert(TableModel tm) {
        Dao dao = ConfigManager.getConfig().getDataFile().getDao();
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic final int insert(")
                .append(tm.getClsName()).append(" ")
                .append(underline2Camel(tm.getTbName(), false))
                .append(") {")
                .append(System.lineSeparator());
        sb.append("\t\treturn ").append(underline2Camel(tm.getTbName(), false) + dao.getSuffix()).append(".").append("insert(")
                .append(underline2Camel(tm.getTbName(), false))
                .append(");").append(System.lineSeparator());
        sb.append("\t}").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }
}
