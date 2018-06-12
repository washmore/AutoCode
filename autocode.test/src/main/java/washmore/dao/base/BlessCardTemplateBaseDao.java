package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessCardTemplate;
/**
 * @author Washmore
 * @version V1
 * @summary 针对贺卡模板(bless_card_template)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessCardTemplateBaseDao {

	List<BlessCardTemplate> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessCardTemplate blessCardTemplate);

	int insertSelective(BlessCardTemplate blessCardTemplate);

	int updateByPrimaryKey(BlessCardTemplate blessCardTemplate);

	int updateByPrimaryKeySelective(BlessCardTemplate blessCardTemplate);

	int deleteByPrimaryKey(Long id);

	BlessCardTemplate selectByPrimaryKey(Long id);

	List<BlessCardTemplate> selectByExample(BlessCardTemplate example);

	int countByExample(BlessCardTemplate example);

}