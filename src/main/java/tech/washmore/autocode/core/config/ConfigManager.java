package tech.washmore.autocode.core.config;

import com.alibaba.fastjson.JSON;
import tech.washmore.autocode.model.Constants;
import tech.washmore.autocode.model.config.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigManager {
    private static Config config;

    public static Config getConfig() {
        if (config != null) {
            return config;
        }
        try {
            return adapte(load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Config adapte(Config config) {
        Db db = config.getDb();
        if (db.getUrl().contains("?")) {
            String sub = db.getUrl().substring(0, db.getUrl().indexOf("?"));
            db.setDbName(sub.substring(sub.lastIndexOf("/") + 1));
        } else {
            db.setDbName(db.getUrl().substring(db.getUrl().lastIndexOf("/") + 1));
        }
        Model model = config.getModel();
        if (model.getPackageName() != null && model.getPackageName().length() > 0) {
            model.setPackagePath(model.getPackageName().replace(".", "/"));
        } else {
            model.setPackagePath("");
        }

        Project project = config.getProject();
        if (project.getPath() == null || project.getPath().length() == 0) {
            project.setPath(System.getProperty("user.dir"));
        }

        Dao dao = config.getDataFile().getDao();
        if (dao.getPackageName() != null && dao.getPackageName().length() > 0) {
            dao.setExtendsPackageName(dao.getPackageName() + "." + Constants.extendsDataFileSuffix);
            dao.setBasePackageName(dao.getPackageName() + "." + Constants.baseDataFileSuffix);

            dao.setPackagePath(dao.getPackageName().replace(".", "/"));
        } else {
            dao.setExtendsPackageName(Constants.extendsDataFileSuffix);
            dao.setBasePackageName(Constants.baseDataFileSuffix);

            dao.setPackagePath("");
        }
        dao.setExtendsPackagePath(dao.getExtendsPackageName().replace(".", "/"));
        dao.setBasePackagePath(dao.getBasePackageName().replace(".", "/"));

        Mapper mapper = config.getDataFile().getMapper();
        if (mapper.getPath() != null && mapper.getPath().length() > 0) {
            mapper.setBasePath(mapper.getPath() + "/" + Constants.baseDataFileSuffix);
            mapper.setExtendsPath(mapper.getPath() + "/" + Constants.extendsDataFileSuffix);
        } else {
            mapper.setBasePath(Constants.baseDataFileSuffix);
            mapper.setExtendsPath(Constants.extendsDataFileSuffix);
        }

        return config;
    }

    private static Config load() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/config.json"));
        StringBuffer configJson = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            configJson.append(line).append(System.lineSeparator());
        }
        return JSON.parseObject(configJson.toString(), Config.class);
    }
}
