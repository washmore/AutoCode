package tech.washmore.autocode.model.config;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public class Mapper {
    private String path;
    private String baseSuffix;
    private String suffix;
    private String basePath;
    private boolean usekeyProperty = true;

    private String extendsPath;

    public boolean getUsekeyProperty() {
        return usekeyProperty;
    }

    public void setUsekeyProperty(boolean usekeyProperty) {
        this.usekeyProperty = usekeyProperty;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getExtendsPath() {
        return extendsPath;
    }

    public void setExtendsPath(String extendsPath) {
        this.extendsPath = extendsPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBaseSuffix() {
        return baseSuffix;
    }

    public void setBaseSuffix(String baseSuffix) {
        this.baseSuffix = baseSuffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
