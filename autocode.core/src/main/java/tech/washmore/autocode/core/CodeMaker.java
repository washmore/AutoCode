package tech.washmore.autocode.core;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.db.DataTableParser;
import tech.washmore.autocode.core.generate.DaoClassGenerator;
import tech.washmore.autocode.core.generate.MapperXmlGenerator;
import tech.washmore.autocode.core.generate.ModelClassGenerator;
import tech.washmore.autocode.model.enums.AutoType;
import tech.washmore.autocode.model.mysql.TableModel;

import java.util.List;

public class CodeMaker {

    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        generate(System.getProperty("user.dir") + "/config.json");
    }

    public static void generate(String configFile) {
        ConfigManager.initConfig(configFile);
        List<TableModel> tableModels = DataTableParser.finalTableModels();

        if (tableModels == null || tableModels.size() == 0) {
            return;
        }
        List<String> autoTypes = ConfigManager.getConfig().getAutoTypes();
        for (AutoType autoType : AutoType.values()) {
            switch (autoType) {
                case dao:
                    if (autoTypes.contains(autoType.name())) {
                        DaoClassGenerator.generateDaos(tableModels);
                    }
                    break;
                case model:
                    if (autoTypes.contains(autoType.name())) {
                        ModelClassGenerator.generateModels(tableModels);
                    }
                    break;
                case mapper:
                    if (autoTypes.contains(autoType.name())) {
                        MapperXmlGenerator.generateMappers(tableModels);
                    }
                    break;
            }
        }
    }


}
