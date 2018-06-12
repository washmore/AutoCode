package tech.washmore.autocode.model.enums;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
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
}
