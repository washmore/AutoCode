package tech.washmore.autocode.model.config;

public class Model {
    private String packageName;
    private String packagePath;
    private Boolean visitorWithDoc;
    private Boolean toString;

    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Boolean getVisitorWithDoc() {
        return visitorWithDoc;
    }

    public void setVisitorWithDoc(Boolean visitorWithDoc) {
        this.visitorWithDoc = visitorWithDoc;
    }

    public Boolean getToString() {
        return toString;
    }

    public void setToString(Boolean toString) {
        this.toString = toString;
    }
}
