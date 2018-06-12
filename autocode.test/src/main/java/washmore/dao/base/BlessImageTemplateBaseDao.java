package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessImageTemplate;
/**
 * @author Washmore
 * @version V1
 * @summary 针对图片模板(bless_image_template)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessImageTemplateBaseDao {

	List<BlessImageTemplate> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessImageTemplate blessImageTemplate);

	int insertSelective(BlessImageTemplate blessImageTemplate);

	int updateByPrimaryKey(BlessImageTemplate blessImageTemplate);

	int updateByPrimaryKeySelective(BlessImageTemplate blessImageTemplate);

	int deleteByPrimaryKey(Long id);

	BlessImageTemplate selectByPrimaryKey(Long id);

	List<BlessImageTemplate> selectByExample(BlessImageTemplate example);

	int countByExample(BlessImageTemplate example);

}