package tech.washmore.autocode.core.config;

import com.alibaba.fastjson.JSON;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.*;
import tech.washmore.autocode.model.enums.AutoType;
import tech.washmore.autocode.model.enums.DataFileMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private static ClassLoader classLoader;


    private static Config config;


    public static ClassLoader getClassLoader() {
        return classLoader;
    }

    public static void setClassLoader(ClassLoader classLoader) {
        ConfigManager.classLoader = classLoader;
    }

    public static void initConfigFromFile(String fileName) {
        try {
            config = adapte(load(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initConfigFromJson(String configJson) {
        config = adapte(JSON.parseObject(configJson.toString(), Config.class));
    }

    public static Config getConfig() {
        return config;
    }

    private static Config adapte(Config config) {

        List<String> autoTypes = config.getAutoTypes();
        if (autoTypes == null || autoTypes.size() == 0) {
            autoTypes = new ArrayList<>();
            for (AutoType autoType : AutoType.values()) {
                autoTypes.add(autoType.name());
            }
        }

        Db db = config.getDb();
        if (db == null) {
            db = new Db();
            config.setDb(db);
        }
        if (db.getUrl().contains("?")) {
            String sub = db.getUrl().substring(0, db.getUrl().indexOf("?"));
            db.setDbName(sub.substring(sub.lastIndexOf(Constants.pathSplitor) + 1));
        } else {
            db.setDbName(db.getUrl().substring(db.getUrl().lastIndexOf(Constants.pathSplitor) + 1));
        }

        Model model = config.getModel();
        if (model == null) {
            model = new Model();
            config.setModel(model);
        }
        if (model.getPackageName() != null && model.getPackageName().length() > 0) {
            model.setPackagePath(model.getPackageName().replace(".", Constants.pathSplitor));
        } else {
            model.setPackagePath("");
        }

        Project project = config.getProject();
        if (project == null) {
            project = new Project();
            config.setProject(project);
        }
        if (project.getPath() == null || project.getPath().length() == 0) {
            project.setPath(System.getProperty("user.dir"));
        }
        project.setPath(project.getPath() + Constants.pathSplitor + project.getSubModule() + Constants.pathSplitor);

        DataFile dataFile = config.getDataFile();
        if (dataFile == null) {
            dataFile = new DataFile();
            config.setDataFile(dataFile);
        }
        List<String> includes = dataFile.getMethodInclude();
        List<String> excludes = dataFile.getMethodExclude();
        DataFileMethod[] methods = DataFileMethod.values();
        if (includes != null && includes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (DataFileMethod m : methods) {
                if (includes.contains(m.name())) {
                    temp.add(m.name());
                }
            }
            dataFile.setMethodInclude(temp);
        } else if (excludes != null && excludes.size() > 0) {
            List<String> temp = new ArrayList<>();
            for (DataFileMethod m : methods) {
                if (!excludes.contains(m.name())) {
                    temp.add(m.name());
                }
            }
            dataFile.setMethodInclude(temp);
        } else {
            for (DataFileMethod m : methods) {
                dataFile.getMethodInclude().add(m.name());
            }
        }

        Service service = dataFile.getService();

        if (service == null) {
            service = new Service();
            dataFile.setService(service);
        }
        if (service.getPackageName() == null || service.getPackageName().length() == 0) {
            service.setExtendsPackageName(Constants.extendsDataFileSuffix);
            service.setBasePackageName(Constants.baseDataFileSuffix);
            service.setPackagePath("");
        } else {
            service.setExtendsPackageName(service.getPackageName() + "." + Constants.extendsDataFileSuffix);
            service.setBasePackageName(service.getPackageName() + "." + Constants.baseDataFileSuffix);
            service.setPackagePath(service.getPackageName().replace(".", Constants.pathSplitor));
        }
        service.setExtendsPackagePath(service.getExtendsPackageName().replace(".", Constants.pathSplitor));
        service.setBasePackagePath(service.getBasePackageName().replace(".", Constants.pathSplitor));


        Dao dao = dataFile.getDao();
        if (dao == null) {
            dao = new Dao();
            dataFile.setDao(dao);
        }
        if (dao.getPackageName() != null && dao.getPackageName().length() > 0) {
            dao.setExtendsPackageName(dao.getPackageName() + "." + Constants.extendsDataFileSuffix);
            dao.setBasePackageName(dao.getPackageName() + "." + Constants.baseDataFileSuffix);

            dao.setPackagePath(dao.getPackageName().replace(".", Constants.pathSplitor));
        } else {
            dao.setExtendsPackageName(Constants.extendsDataFileSuffix);
            dao.setBasePackageName(Constants.baseDataFileSuffix);

            dao.setPackagePath("");
        }
        dao.setExtendsPackagePath(dao.getExtendsPackageName().replace(".", Constants.pathSplitor));
        dao.setBasePackagePath(dao.getBasePackageName().replace(".", Constants.pathSplitor));

        Mapper mapper = dataFile.getMapper();
        if (mapper == null) {
            mapper = new Mapper();
            dataFile.setMapper(mapper);
        }
        if (mapper.getPath() != null && mapper.getPath().length() > 0) {
            mapper.setBasePath(mapper.getPath() + Constants.pathSplitor + Constants.baseDataFileSuffix);
            mapper.setExtendsPath(mapper.getPath() + Constants.pathSplitor + Constants.extendsDataFileSuffix);
        } else {
            mapper.setBasePath(Constants.baseDataFileSuffix);
            mapper.setExtendsPath(Constants.extendsDataFileSuffix);
        }

        System.out.println("最终生效配置内容:" + System.lineSeparator() + JSON.toJSONString(config, true));

        return config;
    }

    private static Config load(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuffer configJson = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            configJson.append(line).append(System.lineSeparator());
        }
        return JSON.parseObject(configJson.toString(), Config.class);
    }
}
