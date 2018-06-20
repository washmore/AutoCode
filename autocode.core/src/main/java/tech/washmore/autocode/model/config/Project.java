package tech.washmore.autocode.model.config;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String path = "";
    private String subModule = "";
    private String encoding = "UTF-8";
    private String javaRoot = "/src/main/java/";
    private String resourcesRoot = "/src/main/resources/";
    private boolean underline2Camel = true;
    private List<String> exclude = new ArrayList<>();
    private List<String> include = new ArrayList<>();

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getSubModule() {
        return subModule;
    }

    public void setSubModule(String subModule) {
        this.subModule = subModule;
    }

    public String getResourcesRoot() {
        return resourcesRoot;
    }

    public void setResourcesRoot(String resourcesRoot) {
        this.resourcesRoot = resourcesRoot;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getJavaRoot() {
        return javaRoot;
    }

    public void setJavaRoot(String javaRoot) {
        this.javaRoot = javaRoot;
    }

    public boolean getUnderline2Camel() {
        return underline2Camel;
    }

    public void setUnderline2Camel(boolean underline2Camel) {
        this.underline2Camel = underline2Camel;
    }

    public List<String> getExclude() {
        return exclude;
    }

    public void setExclude(List<String> exclude) {
        this.exclude = exclude;
    }

    public List<String> getInclude() {
        return include;
    }

    public void setInclude(List<String> include) {
        this.include = include;
    }
}
