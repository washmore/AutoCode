package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendTargetOrganization;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发对象_按组织(bless_send_target_organization)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessSendTargetOrganizationBaseDao {

	List<BlessSendTargetOrganization> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendTargetOrganization blessSendTargetOrganization);

	int insertSelective(BlessSendTargetOrganization blessSendTargetOrganization);

	int updateByPrimaryKey(BlessSendTargetOrganization blessSendTargetOrganization);

	int updateByPrimaryKeySelective(BlessSendTargetOrganization blessSendTargetOrganization);

	int deleteByPrimaryKey(Long id);

	BlessSendTargetOrganization selectByPrimaryKey(Long id);

	List<BlessSendTargetOrganization> selectByExample(BlessSendTargetOrganization example);

	int countByExample(BlessSendTargetOrganization example);

}