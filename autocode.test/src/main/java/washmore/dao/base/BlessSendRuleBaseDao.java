package washmore.dao.base;

import java.util.Map;
import java.util.List;
import washmore.model.BlessSendRule;
/**
 * @author Washmore
 * @version V1
 * @summary 针对群发规则(bless_send_rule)表的增删改查基础dao
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public interface BlessSendRuleBaseDao {

	List<BlessSendRule> selectByParams(Map<String, Object> params);

	int countByParams(Map<String, Object> params);

	int insert(BlessSendRule blessSendRule);

	int insertSelective(BlessSendRule blessSendRule);

	int updateByPrimaryKey(BlessSendRule blessSendRule);

	int updateByPrimaryKeySelective(BlessSendRule blessSendRule);

	int deleteByPrimaryKey(Long id);

	BlessSendRule selectByPrimaryKey(Long id);

	List<BlessSendRule> selectByExample(BlessSendRule example);

	int countByExample(BlessSendRule example);

}