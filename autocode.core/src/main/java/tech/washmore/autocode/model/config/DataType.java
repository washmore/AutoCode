package tech.washmore.autocode.model.config;

import java.util.Arrays;
import java.util.List;

public class DataType {
    private List<String> date = Arrays.asList("timestamp", "datetime");
    private List<String> string = Arrays.asList("char", "varchar", "text");
    private List<String> integer = Arrays.asList("int", "smallint", "tinyint");
    private List<String> longL = Arrays.asList("bigint");
    private List<String> doubleD = Arrays.asList("double", "float");

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }

    public List<String> getInteger() {
        return integer;
    }

    public void setInteger(List<String> integer) {
        this.integer = integer;
    }

    public List<String> getLongL() {
        return longL;
    }

    public void setLongL(List<String> longL) {
        this.longL = longL;
    }

    public List<String> getDoubleD() {
        return doubleD;
    }

    public void setDoubleD(List<String> doubleD) {
        this.doubleD = doubleD;
    }
}
