package tech.washmore.autocode.model.config;

import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public class DataFile {
    private List<String> methodInclude;
    private Dao dao;
    private Service service;
    private Mapper mapper;
    private List<String> methodExclude;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<String> getMethodExclude() {
        return methodExclude;
    }

    public void setMethodExclude(List<String> methodExclude) {
        this.methodExclude = methodExclude;
    }

    public List<String> getMethodInclude() {
        return methodInclude;
    }

    public void setMethodInclude(List<String> methodInclude) {
        this.methodInclude = methodInclude;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}
