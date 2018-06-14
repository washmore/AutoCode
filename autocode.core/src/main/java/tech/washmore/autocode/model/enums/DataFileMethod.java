package tech.washmore.autocode.model.enums;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018/6/11
 */
public enum DataFileMethod {
    selectByParams,
    countByParams,

    batchInsert,
    batchInsertSelective,
    batchUpdateByPrimaryKeySelective,
    batchDeleteByPrimaryKey,

    insert,
    insertSelective,
    updateByPrimaryKey,
    updateByPrimaryKeySelective,
    deleteByPrimaryKey,

    selectByPrimaryKey,
    selectByExample,
    countByExample;
}
