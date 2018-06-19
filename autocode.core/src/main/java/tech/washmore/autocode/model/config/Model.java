package tech.washmore.autocode.model.config;

public class Model {
    private String packageName;
    private String packagePath;
    private boolean visitorWithDoc = false;
    private boolean toString = true;

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

    public boolean getVisitorWithDoc() {
        return visitorWithDoc;
    }

    public void setVisitorWithDoc(boolean visitorWithDoc) {
        this.visitorWithDoc = visitorWithDoc;
    }

    public boolean getToString() {
        return toString;
    }

    public void setToString(boolean toString) {
        this.toString = toString;
    }
}
