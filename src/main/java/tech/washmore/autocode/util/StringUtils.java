package tech.washmore.autocode.util;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.Config;
import tech.washmore.autocode.model.config.DataType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String underline2Camel(String origin, boolean firstUpperCase) {
        Pattern pattern = Pattern.compile("(_)?([A-Za-z\\d]+)");
        Matcher matcher = pattern.matcher(origin);
        StringBuffer sb = new StringBuffer("");
        while (matcher.find()) {
            String temp = matcher.group();
            if (!temp.startsWith("_")) {
                if (firstUpperCase) {
                    sb.append(temp.substring(0, 1).toUpperCase());
                    sb.append(temp.substring(1).toLowerCase());
                } else {
                    sb.append(temp.toLowerCase());
                }
            } else {
                sb.append(temp.replace("_", "").substring(0, 1).toUpperCase());
                sb.append(temp.substring(2).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static String dataType2FieldType(String columnDataType) {
        DataType dataType = ConfigManager.getConfig().getDataType();
        for (String s : dataType.getDate()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return "Date";
            }
        }
        for (String s : dataType.getDoubleD()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return "Double";
            }
        }
        for (String s : dataType.getInteger()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return "Integer";
            }
        }
        for (String s : dataType.getLongL()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return "Long";
            }
        }

        return "String";
    }

}
