package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessLinkTheme;
/**
 * @author Washmore
 * @version V1
 * @summary 针对Link主题包(bless_link_theme)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessLinkThemeBaseDao {

	List<BlessLinkTheme> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessLinkTheme blessLinkTheme);

	int insertSelective(BlessLinkTheme blessLinkTheme);

	int updateByPrimaryKey(BlessLinkTheme blessLinkTheme);

	int updateByPrimaryKeySelective(BlessLinkTheme blessLinkTheme);

	int deleteByPrimaryKey(Long id);

	BlessLinkTheme selectByPrimaryKey(Long id);

	List<BlessLinkTheme> selectByExample(BlessLinkTheme example);

	int countByExample(BlessLinkTheme example);

}