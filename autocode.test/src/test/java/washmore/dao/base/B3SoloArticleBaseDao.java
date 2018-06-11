package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloArticle;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_article)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018-06-11
 */
public interface B3SoloArticleBaseDao {

	int insert(B3SoloArticle b3SoloArticle);

	int updateByPrimaryKey(B3SoloArticle b3SoloArticle);

	int deleteByPrimaryKey(String oid);

	B3SoloArticle selectByPrimaryKey(String oid);

	List<B3SoloArticle> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}