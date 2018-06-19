package tech.washmore.autocode.core;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.db.DataTableParser;
import tech.washmore.autocode.core.generator.factory.MysqlGeneratorFactory;
import tech.washmore.autocode.model.enums.AutoType;
import tech.washmore.autocode.model.mysql.TableModel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CodeMaker {

    public static void main(String[] args) throws Exception {
       generateFromFile("/Users/chenyuqing/IdeaProjects/AutoCode/autocode.test/config.json");
    }

    public static void generateFromJson(String configJson) {
        ConfigManager.initConfigFromJson(configJson);
        handle();
    }

    public static void generateFromFile(String configLocation) {
        ConfigManager.initConfigFromFile(configLocation);
        handle();
    }

    public static void generateFromFileWithPluginClassLoader(String configLocation, ClassLoader classLoader) {
        ConfigManager.initConfigFromFile(configLocation);
        ConfigManager.setClassLoader(classLoader);
        handle();
    }

    private static void handle() {
        List<TableModel> tableModels = DataTableParser.finalTableModels();

        if (tableModels == null || tableModels.size() == 0) {
            return;
        }
        List<String> autoTypes = ConfigManager.getConfig().getAutoTypes();
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("开始输出文件,根目录:" + new File(ConfigManager.getConfig().getProject().getPath()).getPath());

        for (AutoType autoType : AutoType.values()) {
            switch (autoType) {
                case service:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "-----------------------------------------------");
                        System.out.println("开始输出service文件:" + System.lineSeparator());
                        MysqlGeneratorFactory.serviceClassGenerator().generateServices(tableModels);
                    }
                    break;
                case dao:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "-----------------------------------------------");
                        System.out.println("开始输出dao文件:" + System.lineSeparator());
                        MysqlGeneratorFactory.daoClassGenerator().generateDaos(tableModels);
                    }
                    break;
                case model:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "-----------------------------------------------");
                        System.out.println("开始输出model文件:" + System.lineSeparator());
                        MysqlGeneratorFactory.modelClassGenerator().generateModels(tableModels);
                    }
                    break;
                case mapper:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "-----------------------------------------------");
                        System.out.println("开始输出mapper文件:" + System.lineSeparator());
                        MysqlGeneratorFactory.mapperXmlGenerator().generateMappers(tableModels);
                    }
                    break;
            }
        }
    }
}
