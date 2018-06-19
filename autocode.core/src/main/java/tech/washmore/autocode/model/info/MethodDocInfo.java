package tech.washmore.autocode.model.info;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/15
 */
public class MethodDocInfo extends TableDocInfo {

    private String methodName;
    private String returnType;

    private List<String> parmaName = new ArrayList<>();

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<String> getParmaName() {
        return parmaName;
    }

    public void setParmaName(List<String> parmaName) {
        this.parmaName = parmaName;
    }
}
