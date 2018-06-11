package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloPage;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_page)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018-06-11
 */
public interface B3SoloPageBaseDao {

	int insert(B3SoloPage b3SoloPage);

	int updateByPrimaryKey(B3SoloPage b3SoloPage);

	int deleteByPrimaryKey(String oid);

	B3SoloPage selectByPrimaryKey(String oid);

	List<B3SoloPage> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}