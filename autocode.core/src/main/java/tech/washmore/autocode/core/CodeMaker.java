package tech.washmore.autocode.core;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.core.db.TableParser;
import tech.washmore.autocode.core.generate.DaoClassGenerator;
import tech.washmore.autocode.core.generate.MapperXmlGenerator;
import tech.washmore.autocode.core.generate.ModelClassGenerator;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.mysql.TableModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeMaker {

    public static void main(String[] args)  {
        generate();
    }

    public static void generate()  {
        generate(System.getProperty("user.dir") + "/config.json");
    }

    public static void generate(String configFile)  {
        ConfigManager.initConfig(configFile);
        List<String> tables = TableParser.allTables();
        Config config = ConfigManager.getConfig();
        List<String> includes = config.getProject().getInclude();
        List<String> excludes = config.getProject().getExclude();

        if (includes != null && includes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (String t : tables) {
                if (includes.contains(t)) {
                    temp.add(t);
                }
            }
            tables = temp;
            //tables = tables.stream().filter(includes::contains).collect(Collectors.toList());
        } else if (excludes != null && excludes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (String t : tables) {
                if (!excludes.contains(t)) {
                    temp.add(t);
                }
            }
            tables = temp;
//            tables = tables.stream().filter(t -> !excludes.contains(t)).collect(Collectors.toList());
        }
        List<TableModel> tableModels = new ArrayList<>();
        for (String t : tables) {
            try {
                tableModels.add(TableParser.parse(config.getDb().getDbName(), t));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//           tables.stream().map(t -> {
//            try {
//                return TableParser.parse(config.getDb().getDbName(), t);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }).collect(Collectors.toList());

        if (tableModels == null || tableModels.size() == 0) {
            return;
        }

        ModelClassGenerator.generateModels(tableModels);
        DaoClassGenerator.generateDaos(tableModels);
        MapperXmlGenerator.generateMappers(tableModels);
    }


}
