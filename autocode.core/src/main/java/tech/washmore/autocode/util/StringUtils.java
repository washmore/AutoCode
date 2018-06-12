package tech.washmore.autocode.util;

import tech.washmore.autocode.core.config.ConfigManager;
import tech.washmore.autocode.model.config.DataType;
import tech.washmore.autocode.model.enums.JavaDataType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String underline2Camel(String origin, boolean firstUpperCase) {
        if (!ConfigManager.getConfig().getProject().getUnderline2Camel().booleanValue()) {
            if (firstUpperCase) {
                return origin.substring(0, 1).toUpperCase() + origin.substring(1);
            }
            return origin;
        }
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
                return JavaDataType.时间.value;
            }
        }
        for (String s : dataType.getDoubleD()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return JavaDataType.小数.value;
            }
        }
        for (String s : dataType.getInteger()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return JavaDataType.短数字.value;
            }
        }
        for (String s : dataType.getLongL()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return JavaDataType.长数字.value;
            }
        }
        for (String s : dataType.getString()) {
            if (s.equalsIgnoreCase(columnDataType)) {
                return JavaDataType.字符串.value;
            }
        }
        return null;
    }

}
