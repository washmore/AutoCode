package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloCategory;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_category)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloCategoryBaseDao {

	int insert(B3SoloCategory b3SoloCategory);

	int insertSelective(B3SoloCategory b3SoloCategory);

	int updateByPrimaryKey(B3SoloCategory b3SoloCategory);

	int updateByPrimaryKeySelective(B3SoloCategory b3SoloCategory);

	int deleteByPrimaryKey(String oid);

	B3SoloCategory selectByPrimaryKey(String oid);

	List<B3SoloCategory> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}