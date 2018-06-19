package tech.washmore.autocode.core.generator.base;

import tech.washmore.autocode.model.mysql.TableModel;

import java.util.List;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/15
 */
public interface DaoClassGenerator {
    void generateDaos(List<TableModel> tableModels);
}
