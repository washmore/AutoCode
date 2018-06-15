package tech.washmore.autocode.model.config;

public class Doc {
    private String author;
    private String version;
    private String copyright;
    private String summary;
    private String userGeneratorClass;

    public String getUserGeneratorClass() {
        return userGeneratorClass;
    }

    public void setUserGeneratorClass(String userGeneratorClass) {
        this.userGeneratorClass = userGeneratorClass;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
