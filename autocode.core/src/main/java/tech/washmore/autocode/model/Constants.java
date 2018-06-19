package tech.washmore.autocode.model;

/**
 * @author Washmore
 * @version V1.0
 * @summary 常用的通用变量
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018/6/11
 */
public interface Constants {
    String extendsDataFileSuffix = "ext";
    String baseDataFileSuffix = "base";

    String daoSummaryTemplate = "针对%s(%s)表的增删改查基础dao";
    String serviceSummaryTemplate = "针对%s(%s)表的增删改查基础service";
    String modelSummaryTemplate = "%s(%s)表的model";

    String pathSplitor = "/";
}
