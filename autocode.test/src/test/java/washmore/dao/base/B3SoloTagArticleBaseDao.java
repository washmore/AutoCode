package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloTagArticle;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_tag_article)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018-06-11
 */
public interface B3SoloTagArticleBaseDao {

	int insert(B3SoloTagArticle b3SoloTagArticle);

	int updateByPrimaryKey(B3SoloTagArticle b3SoloTagArticle);

	int deleteByPrimaryKey(String oid);

	B3SoloTagArticle selectByPrimaryKey(String oid);

	List<B3SoloTagArticle> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}