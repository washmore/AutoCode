package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloUser;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_user)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018-06-11
 */
public interface B3SoloUserBaseDao {

	int insert(B3SoloUser b3SoloUser);

	int updateByPrimaryKey(B3SoloUser b3SoloUser);

	int deleteByPrimaryKey(String oid);

	B3SoloUser selectByPrimaryKey(String oid);

	List<B3SoloUser> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}