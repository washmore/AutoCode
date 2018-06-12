package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.B3SoloOption;
/**
 * @author Washmore
 * @version V1
 * @summary 针对(b3_solo_option)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface B3SoloOptionBaseDao {

	int insert(B3SoloOption b3SoloOption);

	int insertSelective(B3SoloOption b3SoloOption);

	int updateByPrimaryKey(B3SoloOption b3SoloOption);

	int updateByPrimaryKeySelective(B3SoloOption b3SoloOption);

	int deleteByPrimaryKey(String oid);

	B3SoloOption selectByPrimaryKey(String oid);

	List<B3SoloOption> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

}