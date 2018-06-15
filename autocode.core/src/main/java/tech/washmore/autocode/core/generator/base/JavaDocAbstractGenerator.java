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
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
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

    public String generateModelTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.modelSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    public String generateBaseServiceTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.serviceSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    public String generateServiceTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.serviceSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    public String generateDaoTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.daoSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }

    public String generateBaseDaoTypeDoc(TableDocInfo ti) {
        return generateCommonTypeDoc(String.format(Constants.daoSummaryTemplate, ti.getTableComment(), ti.getTableName()));
    }
}
