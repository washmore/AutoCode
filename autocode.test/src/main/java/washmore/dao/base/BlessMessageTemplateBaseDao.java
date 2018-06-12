package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessMessageTemplate;
/**
 * @author Washmore
 * @version V1
 * @summary 针对文案模板(bless_message_template)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessMessageTemplateBaseDao {

	List<BlessMessageTemplate> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessMessageTemplate blessMessageTemplate);

	int insertSelective(BlessMessageTemplate blessMessageTemplate);

	int updateByPrimaryKey(BlessMessageTemplate blessMessageTemplate);

	int updateByPrimaryKeySelective(BlessMessageTemplate blessMessageTemplate);

	int deleteByPrimaryKey(Long id);

	BlessMessageTemplate selectByPrimaryKey(Long id);

	List<BlessMessageTemplate> selectByExample(BlessMessageTemplate example);

	int countByExample(BlessMessageTemplate example);

}