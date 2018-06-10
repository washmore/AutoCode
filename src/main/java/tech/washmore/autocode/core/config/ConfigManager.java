package tech.washmore.autocode.core.config;

import com.alibaba.fastjson.JSON;
import tech.washmore.autocode.model.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        return config;
    }

    private static Config load() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(ConfigManager.class.getResourceAsStream("/config.json")));
        StringBuffer configJson = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            configJson.append(line).append(System.lineSeparator());
        }
        return JSON.parseObject(configJson.toString(), Config.class);
    }
}
