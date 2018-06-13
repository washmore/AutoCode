package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessTemplateGroup;
/**
 * @author Washmore
 * @version V1
 * @summary 针对模板分组(bless_template_group)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessTemplateGroupBaseDao {

	List<BlessTemplateGroup> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessTemplateGroup blessTemplateGroup);

	int insertSelective(BlessTemplateGroup blessTemplateGroup);

	int updateByPrimaryKey(BlessTemplateGroup blessTemplateGroup);

	int updateByPrimaryKeySelective(BlessTemplateGroup blessTemplateGroup);

	int deleteByPrimaryKey(Long id);

	BlessTemplateGroup selectByPrimaryKey(Long id);

	List<BlessTemplateGroup> selectByExample(BlessTemplateGroup example);

	int countByExample(BlessTemplateGroup example);

}