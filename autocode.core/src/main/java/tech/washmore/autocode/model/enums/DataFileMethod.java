package tech.washmore.autocode.model.enums;

/**
 * @author Washmore
 * @version V1.0
 * @summary TODO
 * @Copyright (c) 2018, Washmore All Rights Reserved.
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

    selectByUuid,
    selectByPrimaryKey,
    selectByExample,
    countByExample;
}
