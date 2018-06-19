package tech.washmore.autocode.core.generator.factory;

import tech.washmore.autocode.core.generator.mysql.MysqlAbstractDaoClassGenerator;
import tech.washmore.autocode.core.generator.mysql.MysqlAbstractMapperXmlGenerator;
import tech.washmore.autocode.core.generator.mysql.MysqlAbstractModelClassGenerator;
import tech.washmore.autocode.core.generator.mysql.MysqlAbstractServiceClassGenerator;
import tech.washmore.autocode.core.generator.mysql.impl.MysqlDefaultDaoClassGenerator;
import tech.washmore.autocode.core.generator.mysql.impl.MysqlDefaultMapperXmlGenerator;
import tech.washmore.autocode.core.generator.mysql.impl.MysqlDefaultModelClassGenerator;
import tech.washmore.autocode.core.generator.mysql.impl.MysqlDefaultServiceClassGenerator;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/15
 */
public class MysqlGeneratorFactory {
    private static final MysqlAbstractDaoClassGenerator daoClassGenerator;
    private static final MysqlAbstractServiceClassGenerator serviceClassGenerator;
    private static final MysqlAbstractModelClassGenerator modelClassGenerator;
    private static final MysqlAbstractMapperXmlGenerator mapperXmlGenerator;

    static {
        //MysqlAbstractDaoClassGenerator daoClassGeneratorTemp = null;
//        try {
//            daoClassGeneratorTemp = (MysqlAbstractDaoClassGenerator) ConfigManager.getClassLoader().loadClass(ConfigManager.getConfig().getDataFile().getDao().getUserGeneratorClass()).newInstance();
//        } catch (Exception e) {
//            System.out.println("daoClassGenerator未找到用户指定类,使用默认配置!");
//        }
//        if (daoClassGeneratorTemp == null) {
        daoClassGenerator = new MysqlDefaultDaoClassGenerator();
        //   }
        // daoClassGenerator = daoClassGeneratorTemp;
        serviceClassGenerator = new MysqlDefaultServiceClassGenerator();
        modelClassGenerator = new MysqlDefaultModelClassGenerator();

        mapperXmlGenerator = new MysqlDefaultMapperXmlGenerator();
    }

    public static MysqlAbstractDaoClassGenerator daoClassGenerator() {
        return daoClassGenerator;
    }

    public static MysqlAbstractServiceClassGenerator serviceClassGenerator() {
        return serviceClassGenerator;
    }

    public static MysqlAbstractModelClassGenerator modelClassGenerator() {
        return modelClassGenerator;
    }

    public static MysqlAbstractMapperXmlGenerator mapperXmlGenerator() {
        return mapperXmlGenerator;
    }
}
