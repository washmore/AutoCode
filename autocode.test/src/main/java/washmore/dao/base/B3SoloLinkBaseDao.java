package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloLink;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_link)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloLinkBaseDao {

	int insert(B3SoloLink b3SoloLink);

	int insertSelective(B3SoloLink b3SoloLink);

	int updateByPrimaryKey(B3SoloLink b3SoloLink);

	int updateByPrimaryKeySelective(B3SoloLink b3SoloLink);

	int deleteByPrimaryKey(String oid);

	B3SoloLink selectByPrimaryKey(String oid);

	List<B3SoloLink> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}