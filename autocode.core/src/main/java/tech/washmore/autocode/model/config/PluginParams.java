package tech.washmore.autocode.model.config;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/20
 */
public class PluginParams {
    private String sourceEncoding;
    private ClassLoader classLoader = PluginParams.class.getClassLoader();

    public String getSourceEncoding() {
        return sourceEncoding;
    }

    public void setSourceEncoding(String sourceEncoding) {
        this.sourceEncoding = sourceEncoding;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
