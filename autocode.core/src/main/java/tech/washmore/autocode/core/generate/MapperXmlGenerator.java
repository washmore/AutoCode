package tech.washmore.autocode.core.generate;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.*;
import tech.washmore.autocode.model.enums.DataFileMethod;
import tech.washmore.autocode.model.mysql.ColumnModel;
import tech.washmore.autocode.model.mysql.TableModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public class MapperXmlGenerator {

    public static void generateMappers(List<TableModel> tableModels) {
        tableModels.forEach(t -> {
            try {
                generateMapper(t);
                generateMapperExtends(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    private static void generateMapperExtends(TableModel tm) throws IOException {
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Mapper mapper = dataFile.getMapper();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append(System.lineSeparator());
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >").append(System.lineSeparator());
        sb.append("<mapper namespace=\"").append(dao.getExtendsPackageName()).append(".").append(tm.getClsName()).append(dao.getSuffix()).append("\">").append(System.lineSeparator());

        sb.append("</mapper>").append(System.lineSeparator());


        System.out.println(sb.toString());
        File dic = new File(project.getPath() + project.getResourcesRoot() + mapper.getExtendsPath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + mapper.getSuffix() + ".xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream ops = new FileOutputStream(file);
        ops.write(sb.toString().getBytes());
        ops.flush();
        ops.flush();
    }

    private static void generateMapper(TableModel tm) throws IOException {
        ColumnModel pk = tm.getPrimaryKey();
        Config config = ConfigManager.getConfig();
        Model modelConfig = config.getModel();
        DataFile dataFile = config.getDataFile();
        Dao dao = dataFile.getDao();
        Mapper mapper = dataFile.getMapper();
        Doc doc = config.getDoc();
        Project project = config.getProject();
        StringBuffer sb = new StringBuffer("");
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append(System.lineSeparator());
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >").append(System.lineSeparator());
        sb.append("<mapper namespace=\"").append(dao.getExtendsPackageName()).append(".").append(tm.getClsName()).append(dao.getSuffix()).append("\">")
                .append(System.lineSeparator()).append(System.lineSeparator());


        sb.append("\t<resultMap id=\"BaseResultMap\" type=\"").append(modelConfig.getPackageName()).append(".").append(tm.getClsName()).append("\">").append(System.lineSeparator());
        if (pk != null) {
            sb.append("\t\t<id column=\"").append(pk.getColumnName())
                    .append("\" property=\"").append(pk.getFieldName())
                    .append("\" jdbcType=\"").append(pk.getDataType()).append("\"/>").append(System.lineSeparator());
        }
        for (ColumnModel cm : tm.getColumns()) {
            if (!cm.equals(pk)) {
                sb.append("\t\t<result column=\"").append(cm.getColumnName())
                        .append("\" property=\"").append(cm.getFieldName())
                        .append("\" jdbcType=\"").append(cm.getDataType()).append("\"/>").append(System.lineSeparator());
            }
        }
        sb.append("\t</resultMap>").append(System.lineSeparator()).append(System.lineSeparator());


        sb.append("\t<sql id=\"Base_Column_List\">").append(System.lineSeparator());
        sb.append("\t\t");
        for (int i = 0; i < tm.getColumns().size(); i++) {
            ColumnModel cm = tm.getColumns().get(i);
            sb.append(cm.getColumnName());
            if (i == tm.getColumns().size() - 1) {
                sb.append(System.lineSeparator());
            } else {
                sb.append(", ");
                if ((i + 1) % 6 == 0) {
                    sb.append(System.lineSeparator()).append("\t\t");
                }
            }
        }
        sb.append("\t</sql>").append(System.lineSeparator()).append(System.lineSeparator());


        List<String> methods = dataFile.getMethodInclude();
        if (methods != null && methods.size() > 0) {
            for (String method : methods) {
                try {
                    switch (DataFileMethod.valueOf(method)) {
                        case insert:
                            sb.append(appendInsert(tm));
                            break;
                        case deleteByPrimaryKey:
                            sb.append(appendDeleteByPrimaryKey(tm));
                            break;
                        case updateByPrimaryKey:
                            sb.append(appendUpdateByPrimaryKey(tm));
                            break;
                        case selectByPrimaryKey:
                            sb.append(appendSelectByPrimaryKey(tm));
                            break;
                        case selectByParams:
                            sb.append(appendSelectByParams(tm));
                            break;
                        case countByParams:
                            sb.append(appendCountByParams(tm));
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        sb.append("</mapper>").append(System.lineSeparator());


        System.out.println(sb.toString());
        File dic = new File(project.getPath() + project.getResourcesRoot() + mapper.getBasePath());
        if (!dic.exists()) {
            dic.mkdirs();
        }

        File file = new File(dic, tm.getClsName() + mapper.getBaseSuffix() + ".xml");
        if (!file.exists()) {
            file.delete();
            file.createNewFile();
        }
        OutputStream ops = new FileOutputStream(file);
        ops.write(sb.toString().getBytes());
        ops.flush();
        ops.flush();
    }

    String xx =
            "    <select id=\"countByParams\" parameterType=\"map\" resultType=\"int\">\n" +
                    "        select count(*) from bless_jiaxin_notice_user\n" +
                    "        <where>\n" +
                    "            <if test=\"@Ognl@isNotEmpty(id)\">\n" +
                    "                AND id = #{id}\n" +
                    "            </if>\n" +
                    "            <if test=\"@Ognl@isNotEmpty(noticeType)\">\n" +
                    "                AND notice_type = #{noticeType}\n" +
                    "            </if>\n" +
                    "            <if test=\"@Ognl@isNotEmpty(userCode)\">\n" +
                    "                AND user_code = #{userCode}\n" +
                    "            </if>\n" +
                    "        </where>\n" +
                    "    </select>";

    private static String appendCountByParams(TableModel tm) {
        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\"countByParams\" parameterType=\"map\" resultType=\"int\">").append(System.lineSeparator());
        sb.append("\t\tSELECT COUNT(*) FROM ").append(tm.getTbName()).append(System.lineSeparator());
        sb.append("\t\t<where>").append(System.lineSeparator());

        for (ColumnModel cm : tm.getColumns()) {
            sb.append("\t\t\t<if test=\"").append(cm.getFieldName()).append(" != null\">").append(System.lineSeparator());
            sb.append("\t\t\t\tAND ").append(cm.getColumnName()).append(" = ").append("#{").append(cm.getFieldName()).append(",jdbcType=").append(cm.getDataType()).append("}").append(System.lineSeparator());
            sb.append("\t\t\t</if>").append(System.lineSeparator());
        }
        sb.append("\t\t</where>").append(System.lineSeparator());
        sb.append("\t</select>").append(System.lineSeparator()).append(System.lineSeparator());

        return sb.toString();
    }

    private static String appendSelectByParams(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();

        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\"selectByParams\" parameterType=\"map\" resultMap=\"BaseResultMap\">").append(System.lineSeparator());
        sb.append("\t\tSELECT").append(System.lineSeparator());
        sb.append("\t\t<include refid=\"Base_Column_List\"/>").append(System.lineSeparator());
        sb.append("\t\tFROM ").append(tm.getTbName()).append(System.lineSeparator());

        sb.append("\t\t<where>").append(System.lineSeparator());

        for (ColumnModel cm : tm.getColumns()) {
            sb.append("\t\t\t<if test=\"").append(cm.getFieldName()).append(" != null\">").append(System.lineSeparator());
            sb.append("\t\t\t\tAND ").append(cm.getColumnName()).append(" = ").append("#{").append(cm.getFieldName()).append(",jdbcType=").append(cm.getDataType()).append("}").append(System.lineSeparator());
            sb.append("\t\t\t</if>").append(System.lineSeparator());
        }
        sb.append("\t\t</where>").append(System.lineSeparator());
        if (pk != null) {
            sb.append("\t\tORDER BY ").append(pk.getColumnName()).append(" DESC").append(System.lineSeparator());
        }
        sb.append("\t\t<if test=\"start != null and offset != null\">").append(System.lineSeparator());
        sb.append("\t\t\tLIMIT #{start} ,#{offset}").append(System.lineSeparator());
        sb.append("\t\t</if>").append(System.lineSeparator());
        sb.append("\t</select>").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendSelectByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\t<select id=\"selectByPrimaryKey\" resultMap=\"BaseResultMap\" parameterType=\"").append(pk.getFieldType()).append("\">").append(System.lineSeparator());
        sb.append("\t\tSELECT").append(System.lineSeparator());
        sb.append("\t\t<include refid=\"Base_Column_List\"/>").append(System.lineSeparator());
        sb.append("\t\tFROM ").append(tm.getTbName()).append(System.lineSeparator());

        sb.append("\t\tWHERE ").append(pk.getColumnName()).append(" = #{").append(pk.getFieldName()).append(",jdbcType=").append(pk.getDataType()).append("}").append(System.lineSeparator());
        sb.append("\t</select>").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendUpdateByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        Model model = ConfigManager.getConfig().getModel();

        StringBuffer sb = new StringBuffer();
        sb.append("\t<update id=\"updateByPrimaryKeySelective\" parameterType=\"").append(model.getPackageName()).append(".").append(tm.getClsName()).append("\">").append(System.lineSeparator());
        sb.append("\t\tUPDATE ").append(tm.getTbName()).append(System.lineSeparator());
        sb.append("\t\t<set>").append(System.lineSeparator());

        for (ColumnModel cm : tm.getColumns()) {
            sb.append("\t\t\t<if test=\"").append(cm.getFieldName()).append(" != null\">").append(System.lineSeparator());
            sb.append("\t\t\t\t").append(cm.getColumnName()).append(" = ").append("#{").append(cm.getFieldName()).append(",jdbcType=").append(cm.getDataType()).append("},").append(System.lineSeparator());
            sb.append("\t\t\t</if>").append(System.lineSeparator());
        }

        sb.append("\t\t</set>").append(System.lineSeparator());
        sb.append("\t\tWHERE ").append(pk.getColumnName()).append(" = #{").append(pk.getFieldName()).append(",jdbcType=").append(pk.getDataType()).append("}").append(System.lineSeparator());
        sb.append("\t</update>").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendDeleteByPrimaryKey(TableModel tm) {
        ColumnModel pk = tm.getPrimaryKey();
        if (pk == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("\t<delete id=\"deleteByPrimaryKey\" parameterType=\"").append(pk.getFieldType()).append("\">").append(System.lineSeparator());
        sb.append("\t\tDELETE FROM ").append(tm.getTbName()).append(System.lineSeparator());
        sb.append("\t\tWHERE ").append(pk.getColumnName()).append(" = #{").append(pk.getFieldName()).append(",jdbcType=").append(pk.getDataType()).append("}").append(System.lineSeparator());
        sb.append("\t</delete>").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }

    private static String appendInsert(TableModel tm) {
        Model model = ConfigManager.getConfig().getModel();
        Mapper mapper = ConfigManager.getConfig().getDataFile().getMapper();
        StringBuffer sb = new StringBuffer();
        sb.append("\t<insert id=\"insert\" parameterType=\"").append(model.getPackageName()).append(".").append(tm.getClsName()).append("\"");
        if (mapper.getUsekeyProperty().booleanValue() && tm.getPrimaryKey() != null) {
            sb.append(" keyProperty = \"").append(tm.getPrimaryKey().getFieldName()).append("\"");
        }
        sb.append(">").append(System.lineSeparator());
        sb.append("\t\tINSERT INTO ").append(tm.getTbName()).append(System.lineSeparator());
        sb.append("\t\t\t(");
        for (int i = 0; i < tm.getColumns().size(); i++) {
            ColumnModel cm = tm.getColumns().get(i);
            sb.append(cm.getColumnName());
            if (i == tm.getColumns().size() - 1) {
                sb.append(")").append(System.lineSeparator());
            } else {
                sb.append(", ");
                if ((i + 1) % 6 == 0) {
                    sb.append(System.lineSeparator()).append("\t\t\t");
                }
            }
        }
        sb.append("\t\tVALUES").append(System.lineSeparator());
        sb.append("\t\t\t(");

        for (int i = 0; i < tm.getColumns().size(); i++) {
            ColumnModel cm = tm.getColumns().get(i);
            sb.append("#{").append(cm.getFieldName()).append(",jdbcType=").append(cm.getDataType()).append("}");

            if (i == tm.getColumns().size() - 1) {
                sb.append(")").append(System.lineSeparator());
            } else {
                sb.append(", ");
                if ((i + 1) % 3 == 0) {
                    sb.append(System.lineSeparator()).append("\t\t\t");
                }
            }
        }
        sb.append("\t</insert>").append(System.lineSeparator()).append(System.lineSeparator());
        return sb.toString();
    }
}
