package tech.washmore.autocode.core;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.db.DataTableParser;
import tech.washmore.autocode.core.generate.DaoClassGenerator;
import tech.washmore.autocode.core.generate.MapperXmlGenerator;
import tech.washmore.autocode.core.generate.ModelClassGenerator;
import tech.washmore.autocode.model.enums.AutoType;
import tech.washmore.autocode.model.mysql.TableModel;

import java.io.File;
import java.util.List;

public class CodeMaker {

    public static void main(String[] args) {
        generateFromFile("/Users/chenyuqing/IdeaProjects/AutoCode/autocode.test/config.json");
    }



    public static void generate() {
        generateFromFile(System.getProperty("user.dir") + "/config.json");
    }


    public static void generateFromJson(String configJson) {
        ConfigManager.initConfigFromJson(configJson);
        handle();
    }

    public static void generateFromFile(String configLocation) {
        ConfigManager.initConfigFromFile(configLocation);
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
        System.out.println("\t\t开始输出文件,根目录:" + new File(ConfigManager.getConfig().getProject().getPath()).getPath());

        for (AutoType autoType : AutoType.values()) {
            switch (autoType) {
                case dao:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "\t开始输出dao文件:");
                        DaoClassGenerator.generateDaos(tableModels);
                    }
                    break;
                case model:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "\t开始输出model文件:");
                        ModelClassGenerator.generateModels(tableModels);
                    }
                    break;
                case mapper:
                    if (autoTypes.contains(autoType.name())) {
                        System.out.println(System.lineSeparator() + "\t开始输出mapper文件:");
                        MapperXmlGenerator.generateMappers(tableModels);
                    }
                    break;
            }
        }
    }


}
