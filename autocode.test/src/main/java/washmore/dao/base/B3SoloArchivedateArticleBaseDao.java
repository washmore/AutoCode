package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloArchivedateArticle;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_archivedate_article)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloArchivedateArticleBaseDao {

	int insert(B3SoloArchivedateArticle b3SoloArchivedateArticle);

	int insertSelective(B3SoloArchivedateArticle b3SoloArchivedateArticle);

	int updateByPrimaryKey(B3SoloArchivedateArticle b3SoloArchivedateArticle);

	int updateByPrimaryKeySelective(B3SoloArchivedateArticle b3SoloArchivedateArticle);

	int deleteByPrimaryKey(String oid);

	B3SoloArchivedateArticle selectByPrimaryKey(String oid);

	List<B3SoloArchivedateArticle> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}