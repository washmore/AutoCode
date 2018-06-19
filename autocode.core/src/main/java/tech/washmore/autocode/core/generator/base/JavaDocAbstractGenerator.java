package tech.washmore.autocode.core.generator.base;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.Doc;
import tech.washmore.autocode.model.info.TableDocInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Washmore
 * @version V1.0
 * @summary 抽象的javadoc生成器, 如果用户需要自定义内容 ,继承此类然后重写相应的方法即可;
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/15
 */
public abstract class JavaDocAbstractGenerator {

    private String generateCommonTypeDoc(String defaultSummary) {
        Doc doc = ConfigManager.getConfig().getDoc();
        StringBuffer sb = new StringBuffer();
        sb.append("/**").append(System.lineSeparator());
        sb.append(" * @author ").append(doc.getAuthor()).append(System.lineSeparator());
        sb.append(" * @version ").append(doc.getVersion()).append(System.lineSeparator());
        sb.append(" * @summary ")
                .append(doc.getSummary() != null && doc.getSummary().length() > 0
                        ? doc.getSummary()
                        : defaultSummary)
                .append(System.lineSeparator());
        sb.append(" * @Copyright ").append(doc.getCopyright()).append(System.lineSeparator());
        sb.append(" * @since ").append(new SimpleDateFormat("yyyy年MM月dd日").format(new Date())).append(System.lineSeparator());
        sb.append(" */").append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * 通用的model类注释
     *
     * @param ti
     * @return
     */
    public String generateModelTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.modelSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    /**
     * 通用的baseService注释
     *
     * @param ti
     * @return
     */
    public String generateBaseServiceTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.serviceSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    /**
     * 通用的service注释
     *
     * @param ti
     * @return
     */
    public String generateServiceTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.serviceSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    /**
     * 通用的dao注释
     *
     * @param ti
     * @return
     */
    public String generateDaoTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.daoSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    /**
     * 通用的baseDao注释
     *
     * @param ti
     * @return
     */
    public String generateBaseDaoTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.daoSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }
    //TODO 后续继续提供getter注释,serviceMethod,daoMethod注释等
}
