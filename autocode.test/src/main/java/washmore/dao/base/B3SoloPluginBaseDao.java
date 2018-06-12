package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloPlugin;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_plugin)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloPluginBaseDao {

	int insert(B3SoloPlugin b3SoloPlugin);

	int insertSelective(B3SoloPlugin b3SoloPlugin);

	int updateByPrimaryKey(B3SoloPlugin b3SoloPlugin);

	int updateByPrimaryKeySelective(B3SoloPlugin b3SoloPlugin);

	int deleteByPrimaryKey(String oid);

	B3SoloPlugin selectByPrimaryKey(String oid);

	List<B3SoloPlugin> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}