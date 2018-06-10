package tech.washmore.autocode.model.config;

public class Model {
    private String packageName;
    private Boolean visitorWithDoc;
    private Boolean toString;

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
