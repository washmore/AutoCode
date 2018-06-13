package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendTargetUsercode;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发对象_按工号(bless_send_target_usercode)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessSendTargetUsercodeBaseDao {

	List<BlessSendTargetUsercode> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendTargetUsercode blessSendTargetUsercode);

	int insertSelective(BlessSendTargetUsercode blessSendTargetUsercode);

	int updateByPrimaryKey(BlessSendTargetUsercode blessSendTargetUsercode);

	int updateByPrimaryKeySelective(BlessSendTargetUsercode blessSendTargetUsercode);

	int deleteByPrimaryKey(Long id);

	BlessSendTargetUsercode selectByPrimaryKey(Long id);

	List<BlessSendTargetUsercode> selectByExample(BlessSendTargetUsercode example);

	int countByExample(BlessSendTargetUsercode example);

}