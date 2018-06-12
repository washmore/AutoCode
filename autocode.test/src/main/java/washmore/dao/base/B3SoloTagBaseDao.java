package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloTag;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_tag)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloTagBaseDao {

	int insert(B3SoloTag b3SoloTag);

	int insertSelective(B3SoloTag b3SoloTag);

	int updateByPrimaryKey(B3SoloTag b3SoloTag);

	int updateByPrimaryKeySelective(B3SoloTag b3SoloTag);

	int deleteByPrimaryKey(String oid);

	B3SoloTag selectByPrimaryKey(String oid);

	List<B3SoloTag> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}