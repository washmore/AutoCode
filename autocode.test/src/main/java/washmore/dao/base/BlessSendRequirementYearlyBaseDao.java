package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendRequirementYearly;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发条件_年度事件发送(bless_send_requirement_yearly)表的操作
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public interface BlessSendRequirementYearlyBaseDao {

	List<BlessSendRequirementYearly> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendRequirementYearly blessSendRequirementYearly);

	int insertSelective(BlessSendRequirementYearly blessSendRequirementYearly);

	int updateByPrimaryKey(BlessSendRequirementYearly blessSendRequirementYearly);

	int updateByPrimaryKeySelective(BlessSendRequirementYearly blessSendRequirementYearly);

	int deleteByPrimaryKey(Long id);

	BlessSendRequirementYearly selectByPrimaryKey(Long id);

	List<BlessSendRequirementYearly> selectByExample(BlessSendRequirementYearly example);

	int countByExample(BlessSendRequirementYearly example);

}