package tech.washmore.autocode.core.generator.factory;

import tech.washmore.autocode.core.generator.mysql.MysqlAbstractDaoClassGenerator;
import tech.washmore.autocode.core.generator.mysql.impl.MysqlDefaultDaoClassGenerator;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/15
 */
public class MysqlGeneratorFactory {
    public static final MysqlAbstractDaoClassGenerator daoClassGenerator;

    static {
        MysqlAbstractDaoClassGenerator daoClassGeneratorTemp = null;
//        try {
//            daoClassGeneratorTemp = (MysqlAbstractDaoClassGenerator) ConfigManager.getClassLoader().loadClass(ConfigManager.getConfig().getDataFile().getDao().getUserGeneratorClass()).newInstance();
//        } catch (Exception e) {
//            System.out.println("daoClassGenerator未找到用户指定类,使用默认配置!");
//        }
//        if (daoClassGeneratorTemp == null) {
        daoClassGeneratorTemp = new MysqlDefaultDaoClassGenerator();
        //   }
        daoClassGenerator = daoClassGeneratorTemp;
    }

    public static MysqlAbstractDaoClassGenerator daoClassGenerator() {
        return daoClassGenerator;
    }

}
