package tech.washmore.autocode.core.generator.base;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.generator.factory.DocInfoFactory;
import tech.washmore.autocode.model.mysql.TableModel;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/15
 */
public class JavaDocBasicAdapter {
    private static JavaDocAbstractGenerator javaDocGenerator;

    static {
        /**
         * 初始化javaDoc生成器
         */
        try {
            javaDocGenerator =
                    (JavaDocAbstractGenerator) ConfigManager.getClassLoader()
                            .loadClass(ConfigManager.getConfig().getDoc().getUserGeneratorClass())
                            .newInstance();
        } catch (Exception e) {
            System.out.println("javaDocGenerator未找到用户指定类,使用默认配置!");
        }
        if (javaDocGenerator == null) {
            javaDocGenerator = new JavaDocBasicGenerator();
        }
    }


    public static String generateModelTypeDoc(TableModel tm) {
        return javaDocGenerator
                .generateModelTypeDoc(DocInfoFactory.createTableInfo(tm));
    }

    public static String generateBaseServiceTypeDoc(TableModel tm) {
        return javaDocGenerator
                .generateBaseServiceTypeDoc(DocInfoFactory.createTableInfo(tm));
    }

    public static String generateServiceTypeDoc(TableModel tm) {
        return javaDocGenerator
                .generateServiceTypeDoc(DocInfoFactory.createTableInfo(tm));
    }

    public static String generateDaoTypeDoc(TableModel tm) {
        return javaDocGenerator
                .generateDaoTypeDoc(DocInfoFactory.createTableInfo(tm));
    }

    public static String generateBaseDaoTypeDoc(TableModel tm) {
        return javaDocGenerator
                .generateBaseDaoTypeDoc(DocInfoFactory.createTableInfo(tm));
    }
}
