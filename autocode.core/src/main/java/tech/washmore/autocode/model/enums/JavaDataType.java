package tech.washmore.autocode.model.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/11
 */
public enum JavaDataType {
    字符串("String"),
    短数字("Integer"),
    长数字("Long"),
    小数("Double"),
    时间("Date");

    public String value;


    JavaDataType(String value) {
        this.value = value;
    }

    public static List<String> strValues() {
        List<String> strValues = new ArrayList<>();
        for (JavaDataType javaDataType : JavaDataType.values()) {
            strValues.add(javaDataType.value);
        }
        return strValues;
    }
}
