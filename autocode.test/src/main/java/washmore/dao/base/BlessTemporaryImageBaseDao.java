package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessTemporaryImage;
/**
 * @author Washmore
 * @version V1
 * @summary 针对临时图片文件(bless_temporary_image)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessTemporaryImageBaseDao {

	List<BlessTemporaryImage> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessTemporaryImage blessTemporaryImage);

	int insertSelective(BlessTemporaryImage blessTemporaryImage);

	int updateByPrimaryKey(BlessTemporaryImage blessTemporaryImage);

	int updateByPrimaryKeySelective(BlessTemporaryImage blessTemporaryImage);

	int deleteByPrimaryKey(Long id);

	BlessTemporaryImage selectByPrimaryKey(Long id);

	List<BlessTemporaryImage> selectByExample(BlessTemporaryImage example);

	int countByExample(BlessTemporaryImage example);

}