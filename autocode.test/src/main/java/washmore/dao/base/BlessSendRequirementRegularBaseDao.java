package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendRequirementRegular;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发条件_固定时间发送(bless_send_requirement_regular)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessSendRequirementRegularBaseDao {

	List<BlessSendRequirementRegular> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendRequirementRegular blessSendRequirementRegular);

	int insertSelective(BlessSendRequirementRegular blessSendRequirementRegular);

	int updateByPrimaryKey(BlessSendRequirementRegular blessSendRequirementRegular);

	int updateByPrimaryKeySelective(BlessSendRequirementRegular blessSendRequirementRegular);

	int deleteByPrimaryKey(Long id);

	BlessSendRequirementRegular selectByPrimaryKey(Long id);

	List<BlessSendRequirementRegular> selectByExample(BlessSendRequirementRegular example);

	int countByExample(BlessSendRequirementRegular example);

}