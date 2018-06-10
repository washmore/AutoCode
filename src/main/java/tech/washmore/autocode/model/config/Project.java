package tech.washmore.autocode.model.config;

public class Project {
    private String path;
    private String javaRoot;
    private Boolean underline2Camel;
    private String exclude;
    private String include;

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

    public Boolean getUnderline2Camel() {
        return underline2Camel;
    }

    public void setUnderline2Camel(Boolean underline2Camel) {
        this.underline2Camel = underline2Camel;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }
}
