package tech.washmore.autocode.model.config;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public class Dao {
    private String suffix;
    private String baseSuffix;

    private String packageName;
    private String packagePath;

    private String basePackageName;
    private String basePackagePath;

    private String extendsPackageName;
    private String extendsPackagePath;
    private String summary;

    private String userGeneratorClass;

    public String getUserGeneratorClass() {
        return userGeneratorClass;
    }

    public void setUserGeneratorClass(String userGeneratorClass) {
        this.userGeneratorClass = userGeneratorClass;
    }

    public String getBaseSuffix() {
        return baseSuffix;
    }

    public void setBaseSuffix(String baseSuffix) {
        this.baseSuffix = baseSuffix;
    }

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }

    public String getBasePackagePath() {
        return basePackagePath;
    }

    public void setBasePackagePath(String basePackagePath) {
        this.basePackagePath = basePackagePath;
    }

    public String getExtendsPackageName() {
        return extendsPackageName;
    }

    public void setExtendsPackageName(String extendsPackageName) {
        this.extendsPackageName = extendsPackageName;
    }

    public String getExtendsPackagePath() {
        return extendsPackagePath;
    }

    public void setExtendsPackagePath(String extendsPackagePath) {
        this.extendsPackagePath = extendsPackagePath;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }


    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
